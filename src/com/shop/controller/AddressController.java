package com.shop.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.entity.MailingAddress;
import com.shop.entity.UserInfo;
import com.shop.service.AddressService;
	
@Controller
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	
	@RequestMapping("/addAddress.action")
	public void addAddress(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		int userId = userInfo.getId();
		String addressee = request.getParameter("addressee");
		String cityAddress = request.getParameter("cityAddress");
		String streetAddress = request.getParameter("streetAddress");
		String phone = request.getParameter("phone");
		MailingAddress mailingAddress = new MailingAddress(addressee, cityAddress, streetAddress, phone, userId);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		addressService.addAddresses(mailingAddress);
		
		if(mailingAddress.getMaid()>0) {
			out.print(" <span  class='addspan'>");
			out.print("<input type='radio'class='fl'name='maid'value='"+mailingAddress.getMaid()+"'  onclick='changeMaid(this.value)'/>");
			out.print("<i>"+mailingAddress.getCityAddress()+"-"+mailingAddress.getStreetAddress()+"-"+mailingAddress.getAddressee()+"-"+mailingAddress.getPhone()+"</i>");
			out.print("</span>");
		}
		
	}
	
}
