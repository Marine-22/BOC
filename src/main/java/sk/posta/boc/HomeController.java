package sk.posta.boc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.annotate.JsonUnwrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.providers.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mongodb.BasicDBObject;

import sk.posta.boc.util.JacksonUtil;
import sk.posta.data.LoginData;
import sk.posta.data.Predpis;
import sk.posta.data.ReturnData;
import sk.posta.data.Sluzba;
import sk.posta.data.Suggestion;
import sk.posta.data.Urad;
import sk.posta.data.User;
import sk.posta.data.enumm.Permissions;
import sk.posta.data.enumm.UserType;
import sk.posta.data.repo.PredpisRepository;
import sk.posta.data.repo.SluzbaRepository;
import sk.posta.data.repo.UradRepository;
import sk.posta.data.repo.UserRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	public static final String APPLICATION_PREFIX = "/boc-BOC";
	public static final String AUTHENTICATED = "authenticated";
	public static final String LOGIN = "userLogin";
	public static final String USER_TYPE = "userType";
	private static final int MAX_SUGGEST_ITEMS = 15;

	private static final String DATE_FORMAT = "dd.MM.yyyy";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class.getName());
	
	// TODO Remake to more sophisticated approach...
	private static final String SALT = "osol si slzami heslo";
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PredpisRepository predpisRepo;

	@Autowired
	private SluzbaRepository sluzbaRepo;
	
	@Autowired
	private UradRepository uradRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MongoOperations customOps;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String def() {
		return "redirect:/login";
	}
	
	@RequestMapping(value="/addPredpis", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String addPredpis(HttpSession session, Model model, @RequestParam MultiValueMap<String, String> params){
		logger.info("Zavolana metoda addPredpis. Data: " + params);
		ReturnData retVal = new ReturnData();
		try{
			Predpis predpis = new Predpis(params);
			predpis.setIdZamLogin(session.getAttribute(HomeController.LOGIN).toString());
			logger.info("Zavolana metoda addPredpis. Data: " + predpis);
			predpisRepo.save(predpis);
			retVal.setStatus("OK");
			return JacksonUtil.object2Json(retVal);
		}catch(ParseException e){
			retVal.setStatus("NOK");
			retVal.addError("Uvedený dátum má nesprávny formát: '"+params.get("datum").get(0)+"'");
		}
		return JacksonUtil.object2Json(retVal);
	}
	
	@RequestMapping(value="/updatePass", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String updatePass(HttpSession session,
			 							   @RequestParam(value="oldPass", required=true) String oldPass, 
										   @RequestParam(value="newPass", required=true) String newPass){
		logger.info("Zavolana metoda updatePass. Data: oldPass=" + oldPass + "; newPass=" + newPass);
		ReturnData retVal = new ReturnData();
		User u = userRepo.findByIdZamLogin((String)session.getAttribute(LOGIN));
		if(checkPass(oldPass, u)){
			u.setHeslo(getHPass(newPass));
			userRepo.save(u);
			retVal.setStatus("OK");
			return JacksonUtil.object2Json(retVal);
		}
		retVal.setStatus("NOK");
		retVal.addFieldError("#chpass_div .bottom-form-info", "Zle zadané pôvodné heslo!");
		return JacksonUtil.object2Json(retVal);
	}
	
	@RequestMapping(value="/updateUser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String updateUser(@RequestParam(value="zamId", required=true) String zamId, 
										   @RequestParam(value="field", required=true) String field, 
										   @RequestParam(value="value", required=true) String value){
		logger.info("Zavolana metoda updateUser. Data: zamId=" + zamId + "; field=" + field + "; value=" + value);
		ReturnData retVal = new ReturnData();
		BasicQuery bq = new BasicQuery("{idZamLogin:\""+zamId+"\"}");
		if("heslo".equals(field)){
			value = getHPass(value);
		}
		Update upd = new Update();
		upd.set(field, value);
		customOps.updateFirst(bq, upd, User.class);
		retVal.setStatus("OK");
		return JacksonUtil.object2Json(retVal);
	}
	
	@RequestMapping(value="/addUser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String addUser(HttpSession session, Model model, @ModelAttribute User user){
		logger.info("Zavolana metoda addUser: " + user);
		ReturnData retVal = new ReturnData();
		User u = userRepo.findByIdZamLogin(user.getIdZamLogin());
		
		if(u != null){
			retVal.setStatus("NOK");
			retVal.addFieldError("#idZamLogin_err", "Zadané id zamestnanca už existuje");
			return JacksonUtil.object2Json(retVal);
		}
		user.setHeslo(getHPass(user.getHeslo()));
		userRepo.save(user);
		retVal.setStatus("OK");
		return JacksonUtil.object2Json(retVal);

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session, Locale locale, Model model) {
		logger.info("Zavolana metoda login.");
		session.setAttribute(HomeController.AUTHENTICATED, null);
		session.setAttribute(HomeController.USER_TYPE, null);
		return "login";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(HttpSession session, Locale locale, Model model) {
		logger.info("Zavolana metoda user. ");
		return "user";
	}
	
	@RequestMapping(value = "/searchUsers", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String searchUsers(HttpServletRequest req, HttpSession session, Locale locale, @RequestParam(value="sq", required=false) String sq) {
		logger.info("Zavolana metoda searchUsers. sq = " + sq);
		ReturnData retVal = new ReturnData();
		BasicQuery bq = null;
		if(sq == null || "".equals(sq)){
			logger.info("Sortujem naprazdno");
			bq = new BasicQuery("{}");
		}
		else{
			logger.info("Sortujem s query tazkou zlozitou");
			bq = new BasicQuery("{$or:[" +
												"{idZamLogin:	{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
												"{meno:			{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
												"{priezvisko:	{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}" +
											"]}");
		}
		bq.with(new Sort("priezvisko"));
		bq.limit(10);
		List<User> l = customOps.find(bq, User.class);
		logger.info("List pouzivatelov: " + l);
		retVal.setStatus("OK");
		retVal.setData(l);
		return JacksonUtil.object2Json(retVal);
	}
	
	@RequestMapping(value = "/testdb", method = RequestMethod.GET)
	public @ResponseBody String xxx(){
		//Query q = new Query();
		//q.addCriteria(Criteria.where("datum").is(new Date()));
		
		logger.info("BasicDBObject append = " + new BasicDBObject("date", new Date()).append("doklad", "valu"));
		logger.info("BasicDBObject put    = " + new BasicDBObject("date", new Date()).put("doklad", "valu"));
		
		BasicQuery bq = new BasicQuery("{ \"date\" : { \"$lt\" : { \"$date\" : \"2014-11-12T16:53:03.111Z\" } } }");
		List<Predpis> l = customOps.find(bq, Predpis.class);
		logger.info("List Predpiss: " + l);
		return "OK";
	}
	
	
	
	@RequestMapping(value = "/searchPredpis", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String searchPredpis(HttpSession session, 
			@RequestParam(value="urad", required=false) String urad,
			@RequestParam(value="datumOd", required=false) String datumOd,
			@RequestParam(value="datumDo", required=false) String datumDo,
			@RequestParam(value="sq", required=false) String sq) {
		logger.info("Zavolana metoda searchPredpis. sq = " + sq + "; urad = " + urad + "; od = " + datumOd + "; do = " + datumDo);
		ReturnData retVal = new ReturnData();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		UserType uType = (UserType)session.getAttribute(USER_TYPE);
		Long dateFrom = null;
		Long dateTo = null;
		try{
			dateFrom = sdf.parse(datumOd).getTime();
		}catch(ParseException ex){}
		
		try{
			dateTo = sdf.parse(datumDo).getTime();
		}catch(ParseException ex){}
		
		
		BasicQuery bq = null;
		if((sq == null || "".equals(sq)) && (urad == null || "".equals(urad)) && (dateFrom == null) && (dateTo == null)){
			bq = new BasicQuery(UserType.checkPermission(uType, Permissions.SEARCH_ALL_PREDPIS) ? "{}" : "{idZamLogin:\""+session.getAttribute(LOGIN)+"\"}");
		}
		else{
			logger.info("Robim queru tazku najzlozitejsiu");
			bq = new BasicQuery("{$and:[" + 
					((urad == null || "".equals(urad)) ? "" : 									"{urad: \""+urad+"\"},") +
					(dateFrom == null ? "" : 													"{datum: { \"$gte\" : "+dateFrom+"}},") +
					(dateTo == null ? "" : 														"{datum: { \"$lte\" : "+dateTo+"}},") +
					(UserType.checkPermission(uType, Permissions.SEARCH_ALL_PREDPIS) ? "" : 	"{idZamLogin:\""+session.getAttribute(LOGIN)+"\"},") + 
								"{$or:[" +
											"{doklad:{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
											"{konanie:{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
											"{sluzba:{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
											"{idnom:{$regex:\"^"+sq+"\\w*\"}} " +
										"]}" +
								"]}");
		}
		bq.with(new Sort("datum"));
		bq.limit(10);
		List<Predpis> l = customOps.find(bq, Predpis.class);
		for(Predpis p : l){
			// pouzivatelov, uradov a sluzieb nebude velmi vela, toto vyhladanie by malo byt rychle
			User u = userRepo.findByIdZamLogin(p.getIdZamLogin());
			Urad ur = uradRepo.findByBusId(p.getUrad());
			Sluzba s = sluzbaRepo.findByBusId(p.getSluzba());
			p.setGUIStaff(u, ur, s);
			logger.info("Datum v predpise: " + p.getDatum());
		}
		retVal.setStatus("OK");
		retVal.setData(l);
		return JacksonUtil.object2Json(retVal);
	}
	
	@RequestMapping(value = "/initUradSluzby", method = RequestMethod.GET)
	public @ResponseBody String initUradSluzby(){
		logger.info("Zavolana metoda initUradSluzby.");
		long count = sluzbaRepo.count();
		logger.info("Sluzba count = " + count);
		if(count == 0){
			sluzbaRepo.save(new Sluzba("1.1.1.", "Žiadosť o vydanie technického preukazu"));
			sluzbaRepo.save(new Sluzba("1.2.1.", "Žiadosť o vydanie občianskeho preukazu"));
			sluzbaRepo.save(new Sluzba("2.3.1.", "Žiadosť o stavebné povolenie"));
			sluzbaRepo.save(new Sluzba("2.3.10.", "Žiadosť o zápis do katastra"));
		}
		count = uradRepo.count();
		logger.info("Urad count = " + count);
		if(count == 0){
			uradRepo.save(new Urad("1", "Bratislava - Polícia"));
			uradRepo.save(new Urad("2", "Košice Katastrálny úrad"));
			uradRepo.save(new Urad("3", "Banká Bystrica Cudzinecká polícia"));
			uradRepo.save(new Urad("4", "Zvolen hlavná stanica"));
		}
		return "OK";
	}
	
	
	@RequestMapping(value = "/superuser", method = RequestMethod.GET)
	public String superuser(HttpSession session, Locale locale, Model model) {
		logger.info("Zavolana metoda superuser.");
		return "superuser";
		
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(HttpSession session, Locale locale, Model model, RedirectAttributes attrs, @ModelAttribute LoginData login) {
		logger.info("Zavolana metoda loginUser. ");
		User u = userRepo.findByIdZamLogin(login.getLogin());
		// zadany login neexistuje alebo je chybne heslo 
		if(!checkPass(login.getPass(), u)){
			attrs.addFlashAttribute("loginError", "Zle zadané meno alebo heslo.");
			return "redirect:/login";
		}
		if(!u.isActive()){
			attrs.addFlashAttribute("loginError", "Používateľ je neaktívny.");
			return "redirect:/login";
		}
		session.setAttribute(HomeController.LOGIN, u.getIdZamLogin());
		session.setAttribute(USER_TYPE, u.getUserType());
		//session.setMaxInactiveInterval(5);
		if(UserType.checkPermission(u.getUserType(), Permissions.USER_VIEW)){
			return "redirect:/user";
		}
		else if(UserType.checkPermission(u.getUserType(), Permissions.ADMIN_VIEW)){
			return "redirect:/superuser";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/getUrad", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getUrad(HttpSession session, @RequestParam(value="term", required=true) String term){
		logger.info("Zavolana metoda getUrad. id = " + term);
		ReturnData retVal = new ReturnData();
		Urad u = uradRepo.findByBusId(term);
		logger.info("Urad found: " + u);
		if(u == null){
			u = uradRepo.findByName(term);
		}
		if(u == null){
			retVal.setStatus("NOK");
			retVal.addFieldError("#urad_err", "Úrad nenájdený!");
			return JacksonUtil.object2Json(retVal);
		}
		logger.info("Urad found: " + u);
		retVal.setStatus("OK");
		retVal.setData(u);
		return JacksonUtil.object2Json(retVal);
		
	}
	
	@RequestMapping(value = "/searchUrad", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String searchUrad(HttpSession session, @RequestParam(value="term", required=false) String term){
		logger.info("Zavolana metoda searchUrad. sq = " + term);
		int maxInList = MAX_SUGGEST_ITEMS;
		if(term == null || "".equals(term)) return "";
		BasicQuery bq = new BasicQuery("{busId:{$regex:\"^"+term+"\\w*\", $options:\"i\"}}");
		bq.with(new Sort("busId"));
		bq.limit(maxInList);
		List<Suggestion> lOut = Suggestion.getSuggestionList(customOps.find(bq, Urad.class), Suggestion.BUS_ID);
		if(lOut.size() < 10){
			maxInList -= lOut.size();
			bq = new BasicQuery("{name:{$regex:\"^"+term+"\\w*\", $options:\"i\"}}");
			bq.with(new Sort("busId"));
			bq.limit(maxInList);
			lOut.addAll(Suggestion.getSuggestionList((customOps.find(bq, Urad.class)), Suggestion.NAME));
		}
		return JacksonUtil.object2Json(lOut);

	}
	
	@RequestMapping(value = "/getSluzba", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getSluzba(HttpSession session, @RequestParam(value="id", required=true) String id){
		logger.info("Zavolana metoda getSluzba. id = " + id);
		ReturnData retVal = new ReturnData();
		
		Sluzba s = sluzbaRepo.findByBusId(id);
		if(s == null){
			retVal.setStatus("NOK");
			retVal.addFieldError("#sluzba_err", "Služba nenájdená!");
			return JacksonUtil.object2Json(retVal);
		}
		retVal.setStatus("OK");
		retVal.setData(s);
		return JacksonUtil.object2Json(retVal);
	}
	
	
	@RequestMapping(value = "/searchSluzba", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String searchSluzba(HttpSession session, @RequestParam(value="term", required=false) String term){
		logger.info("Zavolana metoda searchSluzba. term = " + term);
		int maxInList = MAX_SUGGEST_ITEMS;
		if(term == null || "".equals(term)) return "";
		BasicQuery bq = new BasicQuery("{busId:{$regex:\"^"+term+"\\w*\", $options:\"i\"}}");
		bq.with(new Sort("busId"));
		bq.limit(maxInList);
		List<Suggestion> lOut = Suggestion.getSuggestionList(customOps.find(bq, Sluzba.class), Suggestion.BUS_ID);
		return JacksonUtil.object2Json(lOut);
	}
	
	private String getHPass(String pass){
		return passwordEncoder.encodePassword(pass, SALT);
	}
	
	private boolean checkPass(String pass, String hashPass){
		return hashPass != null && hashPass.equals(getHPass(pass));
	}
	private boolean checkPass(String pass, User u){
		return u != null && u.getHeslo().equals(getHPass(pass));
	}

	
	
	/*
	// Toto je nejake divne zapnutie formatera pre datum dd.MM.yyyy
	// nakoniec datum riesim inak, nechavam to tu ako priklad.
	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class,
		    new PropertyEditorSupport() {
		        public void setAsText(String value) {
		            try {
		                Date parsedDate = new SimpleDateFormat("dd.MM.yyyy").parse(value);
		                setValue(parsedDate);
		            } catch (ParseException e) {
		                setValue(null);
		            }
		        }
		    });
	}
	*/
}
