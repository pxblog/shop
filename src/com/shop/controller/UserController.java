package com.shop.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.entity.Product;
import com.shop.entity.UserInfo;
import com.shop.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/register.action")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		HttpSession session = request.getSession();
		//即一个小时失效
		session.setMaxInactiveInterval(60*60);
		
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		
		UserInfo user = new UserInfo();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPwd(password);
		userService.insertUser(user);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(user.getId()!=0) {
			session.setAttribute("userInfo", user);
			response.sendRedirect("index.jsp");
		}else {
			modelAndView.addObject("message","注册失败，请重新尝试");
			modelAndView.setViewName("register");
		}
		return modelAndView;
	}
	@RequestMapping("/registerAjax.action")
	public void ajaxUser(HttpServletRequest request, HttpServletResponse response) throws Exception   {
		
		String userName = request.getParameter("username");
		int exist = userService.userNameCheck(userName);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(exist>=1) {
			out.print("<font color='red'>账号已存在<font>");
		}else {
			out.print("<font color='green'>账号可以注册<font>");
		}
	}
	
	@RequestMapping("/login.action")
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		//即一个小时失效
		session.setMaxInactiveInterval(60*60);
		String userName = request.getParameter("username");
		String password = request.getParameter("pwd");
		UserInfo user = new UserInfo();
		ModelAndView modelAndView = new ModelAndView();
		
		if (userName!=null&&password!=null) {
			
			user.setUserName(userName);
			user.setPwd(password);
			 
			user = userService.checkUser(user);
			
			if(user!=null) {
				session.setAttribute("userInfo", user);
				response.sendRedirect("index.jsp");
			}else {
				modelAndView.addObject("message","登陆失败，请检查账号和密码");
				modelAndView.setViewName("login");
			}
		}else {
			modelAndView.addObject("message","登陆失败，请检查账号和密码");
			modelAndView.setViewName("login");
		}
		return modelAndView;
	} 
	
	@RequestMapping("/userSessionClear.action")
	public void userSessionClear(HttpServletRequest request, HttpServletResponse response) throws Exception   {
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		response.sendRedirect(request.getContextPath());
	}
	//用户信息更新/删除
	@RequestMapping("/admin/updateUser.action")
	public String updateUser(UserInfo userInfo,@RequestParam("userId") String userId,HttpServletResponse response,HttpServletRequest request)throws Exception{
		if (!userId.equals("")&&userId!=null&&!userId.trim().equals("0")) {
			int id = Integer.valueOf(userId);
			userInfo.setId(id);
			userService.updateUserById(userInfo);
		}else {
			userService.insertUser(userInfo);
		}
		return "redirect:/admin/showUsers/1";
	}
	//用户删除
	@RequestMapping("/admin/deleteUser/{id}/{page}")
	public String deleteProductAjax(@PathVariable("id") int id,@PathVariable("page") int page,HttpServletRequest request,HttpServletResponse response)throws Exception{
		int userId = id;
		userService.deleteUserById(userId);
		return "redirect:/admin/showUsers/"+page;
	}
}
