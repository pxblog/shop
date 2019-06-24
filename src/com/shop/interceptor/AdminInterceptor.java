package com.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shop.entity.Admin;
import com.shop.entity.UserInfo;

public class AdminInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		// TODO 自动生成的方法存根
		//包含登陆信息的，放行
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("adminInfo");
		if(admin!=null) {
			return true;
		}
		//如果不符合如上要求，转发到登陆页面
		request.setAttribute("message", "您还没有登陆，请先登陆");
		request.getRequestDispatcher("/WEB-INF/back/login.jsp").forward(request, response);	
		return true;
	}

}
