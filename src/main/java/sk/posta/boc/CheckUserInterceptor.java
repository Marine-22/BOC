package sk.posta.boc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import sk.posta.boc.util.JacksonUtil;
import sk.posta.data.ReturnData;
import sk.posta.data.enumm.UserType;




public class CheckUserInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(CheckUserInterceptor.class.getName());
	
	
	@Value("#{appProps['application.prefix']}") 
	private String applicationPrefix;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String methodName = ((HandlerMethod)handler).getMethod().getName();
		logger.info("Zavolana metoda: " + methodName);
		Object uType = request.getSession().getAttribute(HomeController.USER_TYPE);
		if(UserType.checkPermission(uType, methodName)){
			return true;
		}
		if(request.getParameter("JSR") == null){
			response.sendRedirect(applicationPrefix + "/login");
		}
		else{
			ReturnData retVal = new ReturnData();
			retVal.setStatus("REDIRECT");
			retVal.setReason("Platnosť Vášho pripojenia vypršala. Prosím prihláste sa znovu.");
			retVal.setRedirect("/login");
			response.getWriter().append(JacksonUtil.object2Json(retVal));
		}
		return false;
		
	}
}
