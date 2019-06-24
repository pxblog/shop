package com.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.entity.UserInfo;
import com.shop.service.MessageService;
	

@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/feedback.action")
	public ModelAndView feedbackAction(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String feedBack = request.getParameter("feedBack");
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		if(userInfo!=null) {
			messageService.sendMessage(userInfo.getUserName(), userInfo.getEmail(), feedBack);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("feedback");
		return modelAndView;
	}
	
	
}
