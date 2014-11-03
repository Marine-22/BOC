package sk.posta.boc;

import java.io.IOException;






//import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




public class CheckUserInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(CheckUserInterceptor.class.getName());
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// invalidovat session ak nie je user nalogovany!
		String auth = (String)request.getSession().getAttribute(HomeController.AUTHENTICATED);
		if("1".equals(auth)){
			return true;
		}
		response.sendRedirect("/boc-BOC/login");
		return false;
	}
}
