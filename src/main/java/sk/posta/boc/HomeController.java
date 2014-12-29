package sk.posta.boc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;
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

import sk.posta.boc.ispep.ExportPredpis;
import sk.posta.boc.ispep.PepConfig;
import sk.posta.boc.util.JacksonUtil;
import sk.posta.data.LoginData;
import sk.posta.data.Predpis;
import sk.posta.data.ReturnData;
import sk.posta.data.Sluzba;
import sk.posta.data.Suggestion;
import sk.posta.data.Urad;
import sk.posta.data.User;
import sk.posta.data.enumm.Permissions;
import sk.posta.data.enumm.PredpisStav;
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

	@Value("#{dbsProps['mongo.name']}") 
	private String dbName;
	

	@Value("#{appProps['app.version']}") 
	private String appVersion;
	
	@Value("#{appProps['app.gui.maxSuggestItems']}") 
	private int MAX_SUGGEST_ITEMS;
	
	public static final String APPLICATION_PREFIX = "/BOC";
	public static final String AUTHENTICATED = "authenticated";
	public static final String LOGIN = "userLogin";
	public static final String USER_TYPE = "userType";
	

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
	
	@Autowired
	private ExportPredpis exportPredpis;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String def() {
		return "redirect:/login";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/addPredpis", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String addPredpis(HttpSession session, Model model, @RequestParam MultiValueMap<String, String> params){
		logger.info("Zavolana metoda addPredpis. Data: " + params);
		ReturnData retVal = null;
		Predpis predpis = new Predpis(params);
		predpis.setIdZamLogin(session.getAttribute(HomeController.LOGIN).toString());
		logger.info("Zavolana metoda addPredpis. Data: " + predpis);
		predpis = predpisRepo.save(predpis);
		if(PepConfig.initialDelayPredpis == Integer.MAX_VALUE){ // vypnuta auto sync, musi sa spravit hned
			predpis.setStav(PredpisStav.WAITING);
			predpis = predpisRepo.save(predpis);
			exportPredpis.exportPredpis(predpis);
		}
		else{
			predpis = predpisRepo.save(predpis);
		}
		retVal = setRetVal();
		return JacksonUtil.object2Json(retVal);
	}
	
	@RequestMapping(value="/updatePass", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String updatePass(HttpSession session,
			 							   @RequestParam(value="oldPass", required=true) String oldPass, 
										   @RequestParam(value="newPass", required=true) String newPass){
		logger.info("Zavolana metoda updatePass. Data: oldPass=" + oldPass + "; newPass=" + newPass);
		ReturnData retVal = null;
		User u = userRepo.findByIdZamLogin((String)session.getAttribute(LOGIN));
		if(checkPass(oldPass, u)){
			u.setHeslo(getHPass(newPass));
			userRepo.save(u);
			retVal = setRetVal();
			return JacksonUtil.object2Json(retVal);
		}
		retVal = setRetValError(retVal, "#chpass_div .bottom-form-info", "Zle zadané pôvodné heslo!");
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
		retVal = setRetVal();
		return JacksonUtil.object2Json(retVal);
	}
	
	@RequestMapping(value="/addUser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String addUser(HttpSession session, Model model, @ModelAttribute User user){
		logger.info("Zavolana metoda addUser: " + user);
		ReturnData retVal = null;
		User u = userRepo.findByIdZamLogin(user.getIdZamLogin());
		
		if(u != null){
			retVal = setRetValError(retVal, "#idZamLogin_err", "Zadané id zamestnanca už existuje");
			return JacksonUtil.object2Json(retVal);
		}
		user.setHeslo(getHPass(user.getHeslo()));
		userRepo.save(user);
		retVal = setRetVal();
		return JacksonUtil.object2Json(retVal);

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session, Locale locale, Model model) {
		logger.info("Zavolana metoda login.");
		session.setAttribute(HomeController.AUTHENTICATED, null);
		session.setAttribute(HomeController.USER_TYPE, null);
		model.addAttribute("dbName", dbName);
		model.addAttribute("appVersion", appVersion);
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
		ReturnData retVal = null;
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
		retVal = setRetVal(l);
		return JacksonUtil.object2Json(retVal);
	}
	
	
	@RequestMapping(value = "/searchPredpis", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String searchPredpis(HttpSession session, 
			@RequestParam(value="urad", required=false) String urad,
			@RequestParam(value="datumPredajaOd", required=false) String datumPredajaOd,
			@RequestParam(value="datumPredajaDo", required=false) String datumPredajaDo,
			@RequestParam(value="datumPridaniaOd", required=false) String datumPridaniaOd,
			@RequestParam(value="datumPridaniaDo", required=false) String datumPridaniaDo,
			@RequestParam(value="datumSyncOd", required=false) String datumSyncOd,
			@RequestParam(value="datumSyncDo", required=false) String datumSyncDo,
			@RequestParam(value="states[]", required=false) Boolean[] states,
			@RequestParam(value="sq", required=false) String sq) {
		logger.info("Zavolana metoda searchPredpis. sq = " + sq + "; urad = " + urad + "; datumPredajaOd = " + datumPredajaOd + "; datumPredajaDo = " + datumPredajaDo + "States count: " + states.length);
		ReturnData retVal = null;
		
		class StatesFilter{
			private boolean isFiltering;
			private String filter;
			public StatesFilter(Boolean[] b){
				logger.info("Bools: " + b[0] + " " + b[1] + " " + b[2] + " " + b[3]);
				isFiltering = false;
				for(int i = 0; i < b.length; i++){
					if(b[i].equals(false)){
						logger.info("Zapina filter: " + i);
						isFiltering = true;
					}
				}
				if(isFiltering){
					filter = "{stav:\"UNDEFINED\"}";
					for(int i = 0; i < b.length; i++){
						if(b[i].equals(true)){
							filter += (", {stav:\""+getStav(i)+"\"}");				
						}
					}
					logger.info("filter: " + filter);
					filter = "{$or:["+filter+"]}";
				}
			}
			public boolean isFiltering(){
				return isFiltering;
			}
			
			public String getFilter(){
				return filter;
			}
			
			private PredpisStav getStav(int i){
				switch(i){
				case 0:
					return PredpisStav.LOADED;
				case 1:
					return PredpisStav.WAITING;
				case 2:
					return PredpisStav.PROCESSED;
				case 3:
					return PredpisStav.ERROR;
				}
				return null;
			}
		}
		
		StatesFilter statesFilter = new StatesFilter(states);
		
		UserType uType = (UserType)session.getAttribute(USER_TYPE);
		String datesFilter = getDatesFilter(datumPredajaOd, datumPredajaDo, datumPridaniaOd, datumPridaniaDo, datumSyncOd, datumSyncDo);
	
		logger.info("Filter stavov: " + statesFilter.isFiltering() + ": " + statesFilter.getFilter());
		BasicQuery bq = null;
		if((sq == null || "".equals(sq)) && (urad == null || "".equals(urad)) && (datesFilter == null) && !statesFilter.isFiltering()){
			bq = new BasicQuery(UserType.checkPermission(uType, Permissions.SEARCH_ALL_PREDPIS) ? "{}" : "{idZamLogin:\""+session.getAttribute(LOGIN)+"\"}");
		}
		else{
			String sbq = "{$and:[" + 
					((urad == null || "".equals(urad)) ? "" : 									"{urad: \""+urad+"\"},") +	// filter uradu
					(datesFilter == null ? "" : 												datesFilter) +				// filter vsetkych datumov (3x od do)
					(UserType.checkPermission(uType, Permissions.SEARCH_ALL_PREDPIS) ? "" : 	"{idZamLogin:\""+session.getAttribute(LOGIN)+"\"},") + // filter na prihlaseneho zamestnanca
					(!statesFilter.isFiltering() ? "" : 										statesFilter.getFilter() + ",") + // filter na stavy
								"{$or:[" +
											"{doklad:{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
											"{konanie:{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
											"{idnom:{$regex:\"^"+sq+"\\w*\"}} " +
										"]}" +
								"]}";
			logger.info("Query: " + sbq);
			bq = new BasicQuery(sbq);
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
		}
		retVal = setRetVal(l);
		retVal.setUserType(uType);
		return JacksonUtil.object2Json(retVal);
	}
	
	private String getDatesFilter(String... dates){
		String retVal = "";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		int count = 0;
		String[] fields = {"datumPredaja", "datumPredaja", "datumPridania", "datumPridania", "datumSync", "datumSync"};
		String[] compars = {"gte", "lte", "gte", "lte","gte", "lte"};
		boolean[] setMax = {false, true, false, true, false, true};
		
		for(int i = 0; i < 6; i++){
			try{
				if(setMax[i]){
					Calendar c = Calendar.getInstance();
					c.setTime(sdf.parse(dates[i]));
					c.set(Calendar.HOUR_OF_DAY, 23);
					c.set(Calendar.MINUTE, 59);
					c.set(Calendar.SECOND, 59);
					retVal += "{"+fields[i]+": { \"$"+compars[i]+"\" : "+c.getTimeInMillis()+"}},";
				}
				else{
					retVal += "{"+fields[i]+": { \"$"+compars[i]+"\" : "+sdf.parse(dates[i]).getTime()+"}},";
				}
				count++;
			}catch(ParseException ex){}
		}
		if(count == 0) return null; 
		return retVal; // niektory datum je zadany
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
		ReturnData retVal = null;
		Urad u = uradRepo.findByBusId(term);
		logger.info("Urad found: " + u);
		if(u == null){
			u = uradRepo.findByName(term);
		}
		if(u == null || !u.isActive()){
			retVal = setRetValError(retVal, "#urad_err", "Úrad nenájdený!");
			return JacksonUtil.object2Json(retVal);
		}
		logger.info("Urad found: " + u);
		retVal = setRetVal(u);
		return JacksonUtil.object2Json(retVal);
		
	}
	
	@RequestMapping(value = "/searchUrad", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String searchUrad(HttpSession session, @RequestParam(value="term", required=false) String term){
		logger.info("Zavolana metoda searchUrad. sq = " + term);
		int maxInList = MAX_SUGGEST_ITEMS;
		if(term == null || "".equals(term)) return "";
		BasicQuery bq = new BasicQuery("{$and:["
				+ 								"{busId:{$regex:\"^"+term+"\\w*\", $options:\"i\"}},"
				+								"{active:true}"
				+ 							 "]"
				+ 						"}");
		bq.with(new Sort("busId"));
		bq.limit(maxInList);
		List<Suggestion> lOut = Suggestion.getSuggestionList(customOps.find(bq, Urad.class), Suggestion.BUS_ID);
		if(lOut.size() < 10){
			maxInList -= lOut.size();
			bq = new BasicQuery("{$and:["
					+ 						"{name:{$regex:\"^"+term+"\\w*\", $options:\"i\"}},"
					+						"{active:true}"
					+ 				  "]"
					+ 			"}");
			bq.with(new Sort("busId"));
			bq.limit(maxInList);
			lOut.addAll(Suggestion.getSuggestionList((customOps.find(bq, Urad.class)), Suggestion.NAME));
		}
		return JacksonUtil.object2Json(lOut);

	}
	
	@RequestMapping(value = "/getSluzba", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getSluzba(HttpSession session, @RequestParam(value="id", required=true) String id){
		logger.info("Zavolana metoda getSluzba. id = " + id);
		ReturnData retVal = null;
		
		Sluzba s = sluzbaRepo.findByBusId(id);
		if(s == null || !s.isActive()){
			retVal = setRetValError(retVal, "#sluzba_err", "Služba nenájdená!");
			return JacksonUtil.object2Json(retVal);
		}
		retVal = setRetVal(s);
		return JacksonUtil.object2Json(retVal);
	}
	
	
	@RequestMapping(value = "/searchSluzba", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String searchSluzba(HttpSession session, @RequestParam(value="term", required=false) String term){
		logger.info("Zavolana metoda searchSluzba. term = " + term);
		int maxInList = MAX_SUGGEST_ITEMS;
		if(term == null || "".equals(term)) return "";
		BasicQuery bq = new BasicQuery("{$and:["
				+ 								"{busId:{$regex:\"^"+term+"\\w*\", $options:\"i\"}},"
				+ 								"{active:true}"
				+ 							 "]"
				+ 						"}");
		bq.with(new Sort("busId"));
		bq.limit(maxInList);
		List<Suggestion> lOut = Suggestion.getSuggestionList(customOps.find(bq, Sluzba.class), Suggestion.BUS_ID);
		return JacksonUtil.object2Json(lOut);
	}
	
	
	@RequestMapping(value = "/resendPredpis", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String resendPredpis(@RequestParam(value="id", required=true) String id){
		logger.info("Zavolana metoda resendPredpis: " + id);
		ReturnData retVal = null;
		Predpis p = predpisRepo.findOne(id);
		p.setErrorMsg(null);
		p.setStav(PredpisStav.WAITING);
		predpisRepo.save(p);
		exportPredpis.exportPredpis(p);
		logger.info("Najdeny predpis: " + p);
		retVal = setRetVal();
		return JacksonUtil.object2Json(retVal);
	}
	
	
	
	private String getHPass(String pass){
		return passwordEncoder.encodePassword(pass, SALT);
	}
	
	private boolean checkPass(String pass, User u){
		return u != null && u.getHeslo().equals(getHPass(pass));
	}
	
	
	private ReturnData setRetVal(){
		return setRetVal(null);
	}
	private ReturnData setRetVal(Object data){
		ReturnData retVal = new ReturnData();
		retVal.setData(data);
		retVal.setStatus("OK");
		return retVal;
	}
	
	@SuppressWarnings("unused")
	private ReturnData setRetValError(ReturnData r, String errMsg){
		if(r == null){
			r = new ReturnData();
			r.setStatus("NOK");
		}
		r.addError(errMsg);
		return r;
	}
	
	private ReturnData setRetValError(ReturnData r, String field, String errMsg){
		if(r == null){
			r = new ReturnData();
			r.setStatus("NOK");
		}
		r.addFieldError(field, errMsg);
		return r;
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
