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
		// TODO �Զ����ɵķ������
		//��ȡ���������URL
		String url = request.getRequestURI();
		System.out.println(url);
		//��½��ע��ҳ�����
		if(url.indexOf("login")>=0||url.indexOf("register")>=0) {
			return true;
		}
		//������½��Ϣ�ģ�����
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		if(userInfo!=null) {
			return true;
		}
		//�������������Ҫ��ת������½ҳ��
		request.setAttribute("message", "����û�е�½�����ȵ�½");
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);	
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO �Զ����ɵķ������
		
	}

}
