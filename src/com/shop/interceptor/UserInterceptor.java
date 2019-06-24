package com.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shop.entity.UserInfo;

public class UserInterceptor implements HandlerInterceptor{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO 自动生成的方法存根
		//获取发送请求的URL
		String url = request.getRequestURI();
		System.out.println(url);
		//登陆和注册页面放行
		if(url.indexOf("login")>=0||url.indexOf("register")>=0) {
			return true;
		}
		//包含登陆信息的，放行
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		if(userInfo!=null) {
			return true;
		}
		//如果不符合如上要求，转发到登陆页面
		request.setAttribute("message", "您还没有登陆，请先登陆");
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);	
		return false;
	}

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

}
