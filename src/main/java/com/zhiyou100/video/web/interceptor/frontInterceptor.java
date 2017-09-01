package com.zhiyou100.video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class frontInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		//if(req.getServletPath().endsWith("login.action")){
			if(req.getSession().getAttribute("_front_user")==null){
				req.getRequestDispatcher("/index.jsp").forward(req, res);
			return false;
			}else{
				return true;
			}
	//	}
		/*if(req.getServletPath().endsWith("regist.action")){
				return true;
		}
		if(req.getServletPath().endsWith("forgetpwd.action")){
				return true;
		}
		if(req.getServletPath().endsWith("sendEmail.action")){
				return true;
		}
		if(req.getServletPath().endsWith("resetpwd.action")){
			return true;
		}else{
			return true;
		}*/
		
		
	}
}
