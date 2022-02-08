package env;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class 로그인확인자 extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		boolean 로그인중 = false;
		if(session != null && session.getAttribute("loginUser") != null) {
			로그인중 = true;
		} else {
			response.sendRedirect("/login");
		}
		return 로그인중;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response, 
						   Object handler,
						   ModelAndView modelAndView) throws Exception {
		
	}

}
