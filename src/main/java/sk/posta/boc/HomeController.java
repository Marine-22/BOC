package sk.posta.boc;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
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

import sk.posta.boc.util.JacksonUtil;
import sk.posta.data.LoginData;
import sk.posta.data.Predpis;
import sk.posta.data.User;
import sk.posta.data.repo.PredpisRepository;
import sk.posta.data.repo.UserRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	public static final String APPLICATION_PREFIX = "/boc-BOC";
	public static final String AUTHENTICATED = "authenticated";
	public static final String SPRAVCA = "spravca";
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class.getName());
	
	// TODO Remake to more sophisticated approach...
	private static final String SALT = "osol si slzami heslo";
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PredpisRepository predpisRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MongoOperations customOps;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String def() {
		return "redirect:/login";
	}
	
	@RequestMapping(value="/addPredpis", method = RequestMethod.POST)
	public @ResponseBody String addPredpis(HttpSession session, Model model, @RequestParam MultiValueMap<String, String> params){
		logger.info("Zavolana metoda addPredpis. Data: " + params);
		if("0".equals(session.getAttribute(HomeController.SPRAVCA))){
			try{
				Predpis predpis = new Predpis(params);
				logger.info("Zavolana metoda addPredpis. Data: " + predpis);
				predpisRepo.save(predpis);
				return "OK";
			}catch(ParseException e){
				// pridat chybovu hlasku do GUI
			}
		}
		return "NOK";
	}
	
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public String addUser(HttpSession session, Model model, @ModelAttribute User user){
		logger.info("Zavolana metoda addUser: " + user);
		if("1".equals(session.getAttribute(HomeController.SPRAVCA))){
			user.setHeslo(passwordEncoder.encodePassword(user.getHeslo(), SALT));
			userRepo.save(user);
			return "redirect:/superuser";
		}
		return "redirect:/login";

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session, Locale locale, Model model) {
		logger.info("Zavolana metoda login. customOps = " + customOps);
		session.setAttribute(HomeController.AUTHENTICATED, null);
		session.setAttribute(HomeController.SPRAVCA, null);
		return "login";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(HttpSession session, Locale locale, Model model) {
		logger.info("Zavolana metoda user. ");
		if("0".equals(session.getAttribute(HomeController.SPRAVCA))){
			return "user";
		}
		return "redirect:/login";
	}
	
	// ajax method
	@RequestMapping(value = "/searchUsers", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody String searchUsers(HttpServletRequest req, HttpSession session, Locale locale, @RequestParam(value="sq", required=false) String sq) {
		logger.info("Zavolana metoda searchUsers. sq = " + sq);
		if("1".equals(session.getAttribute(HomeController.SPRAVCA))){
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
			return JacksonUtil.object2Json(l);
		}
		return "";
	}
	
	
	@RequestMapping(value = "/searchPredpis", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody String searchPredpis(HttpServletRequest req, HttpSession session, Locale locale, @RequestParam(value="sq", required=false) String sq) {
		logger.info("Zavolana metoda searchPredpis. sq = " + sq);
		// iba pre pouzivatelov, nie pre spravcov
		if("0".equals(session.getAttribute(HomeController.SPRAVCA))){
			BasicQuery bq = null;
			if(sq == null || "".equals(sq)){
				logger.info("Sortujem naprazdno");
				bq = new BasicQuery("{}");
			}
			else{
				logger.info("Robim queru tazku najzlozitejsiu");
				bq = new BasicQuery("{$or:[" +
											"{doklad:{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
											"{konanie:{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
											"{sluzba:{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
											"{urad:{$regex:\"^"+sq+"\\w*\", $options:\"i\"}}, " +
											"{idnom:{$regex:\"^"+sq+"\\w*\"}} " +
										"]}");
			}
			bq.with(new Sort("datum"));
			bq.limit(10);
			List<Predpis> l = customOps.find(bq, Predpis.class);
			logger.info("List Predpisov: " + l);
			return JacksonUtil.object2Json(l);
			
		}
		return "";
	}
	
	
	@RequestMapping(value = "/superuser", method = RequestMethod.GET)
	public String superuser(HttpSession session, Locale locale, Model model) {
		logger.info("Zavolana metoda superuser. ");
		if("1".equals(session.getAttribute(HomeController.SPRAVCA))){
			return "superuser";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(HttpSession session, Locale locale, Model model, RedirectAttributes attrs, @ModelAttribute LoginData login) {
		logger.info("Zavolana metoda loginUser. ");
		User u = userRepo.findByIdZamLogin(login.getLogin());
		// zadany login neexistuje alebo je chybne heslo
		if(u == null || !passwordEncoder.encodePassword(login.getPass(), SALT).equals(u.getHeslo())){
			attrs.addFlashAttribute("loginError", "Zle zadané meno alebo heslo.");
			return "redirect:/login";
		}
		// pouzivatel sa uspesne prihlasil, nastavim mu prava
		session.setAttribute(HomeController.AUTHENTICATED, "1");
		if(u.isSpravca()){
			session.setAttribute(HomeController.SPRAVCA, "1");
			return "redirect:/superuser";
		}
		session.setAttribute(HomeController.SPRAVCA, "0");
		return "redirect:/user";
	}
	
	/*
	// Toto je nejake divne zapnutie formatera pre datum dd.MM.yyyy
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
