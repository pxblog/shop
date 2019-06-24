package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.entity.Admin;
import com.shop.entity.Category;
import com.shop.entity.Message;
import com.shop.entity.Orders;
import com.shop.entity.Page;
import com.shop.entity.Product;
import com.shop.entity.UserInfo;
import com.shop.service.AdminService;
import com.shop.service.MessageService;
import com.shop.service.OrderService;
import com.shop.service.ProductItemsService;
import com.shop.service.UserService;

@Controller
public class AdminController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	AdminService adminService;
	@Autowired
	ProductItemsService productItemsService;
	@Autowired
	UserService userService;
	@Autowired
	OrderService orderService;
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/admin")
	public ModelAndView admin(HttpServletRequest request,HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("adminInfo");
		ModelAndView modelAndView = new ModelAndView();
		if(admin != null) {
			modelAndView.setViewName("forward:WEB-INF/back/index.jsp");
		}else {
			modelAndView.setViewName("forward:WEB-INF/back/login.jsp");
		}
		return modelAndView;
	}
	@RequestMapping("/adminCheck.action")
	public ModelAndView adminCheck(Admin admin)throws Exception{
		HttpSession session = request.getSession();
		//即一个小时失效
		session.setMaxInactiveInterval(60*60);
		admin = adminService.checkAdmin(admin);
		String[] adminRem = request.getParameterValues("checked");
		
		ModelAndView modelAndView = new ModelAndView();
		if(admin!=null) {
			if(adminRem.length>0&&adminRem[0].equals("true")) {
				//设置本地Cookie
				Cookie adminName = new Cookie("adminName", admin.getAdminName());
				adminName.setMaxAge(60*60*24*7);
				Cookie adminPassword = new Cookie("passWord", admin.getPassword());
				adminPassword.setMaxAge(60*60*24*7);
				response.addCookie(adminName);
				response.addCookie(adminPassword);
			}
			//设置session
			session.setAttribute("adminInfo", admin);
			modelAndView.setViewName("forward:WEB-INF/back/index.jsp");
		}else {
			modelAndView.addObject("message","登陆失败，请检查账号和密码");
			modelAndView.setViewName("forward:WEB-INF/back/login.jsp");
		}
		return modelAndView;
	}
	@RequestMapping("/adminClear.action")
	public ModelAndView adminClear(HttpServletRequest request,HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		session.removeAttribute("adminInfo");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:WEB-INF/back/login.jsp");
		return modelAndView;
	}
	@RequestMapping("/admin/updateShop/{id}")
	public ModelAndView addShop(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		//分类的加载
		List<Category> categories = productItemsService.getCategorys();
		List<Category> removeCategories = new ArrayList<Category>();
		for (Category category : categories) {
			List<Category> childCategories = new ArrayList<Category>();
			for (Category category2 : categories) {
				if (category.getCid() == category2.getPid()) {
					childCategories.add(category2);
					removeCategories.add(category2);
				}
			}
			category.setChildCategories(childCategories);
		}
		categories.removeAll(removeCategories);
		//product的加载
		Product product = productItemsService.selectProductDetailById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("categories",categories);
		modelAndView.addObject("product",product);
		modelAndView.setViewName("forward:/WEB-INF/back/productadd.jsp");
		return modelAndView;
	}
	@RequestMapping("/admin/showShops/{pageNum}")
	public ModelAndView showShops(@PathVariable("pageNum") int pageNum,HttpServletRequest request,HttpServletResponse response)throws Exception{
		int totalRecordsNum = productItemsService.selectAllProductNum();
		int pageSize = 8;
		Page page = new Page(pageNum, totalRecordsNum, pageSize);
		List<Product> products = productItemsService.selectProductByPage(pageNum);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("page",page);
		modelAndView.addObject("products",products);
		modelAndView.setViewName("forward:/WEB-INF/back/showproduct.jsp");
		return modelAndView;
	}
	@RequestMapping("/admin/showUsers/{pageNum}")
	public ModelAndView showUsers(@PathVariable("pageNum") int pageNum,HttpServletRequest request,HttpServletResponse response)throws Exception{
		//分页程序
		int totalRecordsNum = userService.getAllUserNum();
		int pageSize = 8;
		Page page = new Page(pageNum, totalRecordsNum, pageSize);
		List<UserInfo> userInfos = userService.selectUserByPageNum(page);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pages",page);
		modelAndView.addObject("userInfos",userInfos);
		modelAndView.setViewName("forward:/WEB-INF/back/users.jsp");
		return modelAndView;
	}
	@RequestMapping("/admin/userUpdate/{userId}")
	public ModelAndView userUpdate(@PathVariable("userId") int userId,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		if(userId>0) {
			UserInfo userInfo = userService.getUserByUserId(userId);
			modelAndView.addObject("userInfo", userInfo);
		}
		modelAndView.setViewName("forward:/WEB-INF/back/userupdate.jsp");
		return modelAndView;
	}
	@RequestMapping("/admin/showOrders/{pageNum}")
	public ModelAndView showOrders(@PathVariable("pageNum") int pageNum,HttpServletRequest request,HttpServletResponse response)throws Exception{
		//分页程序
		int totalRecordsNum = orderService.selectAllOrderNum();
		int pageSize = 8;
		Page page = new Page(pageNum, totalRecordsNum, pageSize);
		List<Orders> orders = orderService.selectOrdersByPageNum(page);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("page",page);
		modelAndView.addObject("orders",orders);
		modelAndView.setViewName("forward:/WEB-INF/back/showorder.jsp");
		return modelAndView;
	}
	@RequestMapping("/admin/showMessages/{pageNum}")
	public ModelAndView showMessages(@PathVariable("pageNum") int pageNum,HttpServletRequest request,HttpServletResponse response)throws Exception{
		//分页程序
		int totalRecordsNum = messageService.selectAllMessageNum();
		int pageSize = 8;
		Page page = new Page(pageNum, totalRecordsNum, pageSize);
		List<Message> messages = messageService.selectMessageByPage(page);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("page",page);
		modelAndView.addObject("messages",messages);
		modelAndView.setViewName("forward:/WEB-INF/back/showMessages.jsp");
		return modelAndView;
	}
	@RequestMapping("/admin/readMessage/{id}")
	public ModelAndView readMessage(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		Message message = messageService.selectMessageById(id);
		//变更信息为已读
		if(message!=null) {
			messageService.changeMessageStatusById(id);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.setViewName("forward:/WEB-INF/back/readMessage.jsp");
		return modelAndView;
	}
}
