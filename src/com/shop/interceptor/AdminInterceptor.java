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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		// TODO �Զ����ɵķ������
		//������½��Ϣ�ģ�����
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("adminInfo");
		if(admin!=null) {
			return true;
		}
		//�������������Ҫ��ת������½ҳ��
		request.setAttribute("message", "����û�е�½�����ȵ�½");
		request.getRequestDispatcher("/WEB-INF/back/login.jsp").forward(request, response);	
		return true;
	}

}
