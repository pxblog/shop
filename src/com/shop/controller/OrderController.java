package com.shop.controller;


import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.entity.Cart;
import com.shop.entity.MailingAddress;
import com.shop.entity.OrderDetails;
import com.shop.entity.Orders;
import com.shop.entity.Product;
import com.shop.entity.UserInfo;
import com.shop.service.AddressService;
import com.shop.service.CarService;
import com.shop.service.OrderService;
import com.shop.service.ProductItemsService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	@Autowired 
	AddressService addressService;
	@Autowired
	CarService carService;
	@Autowired
	ProductItemsService productItemsService;
	
	//һ���������⣬����жϡ��ڼ��빺�ﳵҳ�洦��
	@RequestMapping("/addOrder.action")
	public ModelAndView addOrder(HttpServletRequest request,HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		int userId = userInfo.getId();
		int maid = Integer.valueOf(request.getParameter("maidHid"));
		MailingAddress mailingAddress = addressService.selectAddressByMid(maid);
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat orderNum = new SimpleDateFormat("yyyyMMddHHmmss");
		
		//��ַ��ĸ����ֶ�
		String addressee = mailingAddress.getAddressee();
		String cityAddress = mailingAddress.getCityAddress();
		String streetAddress = mailingAddress.getStreetAddress();
		String phone = mailingAddress.getPhone();
		
		//ԭ���ֶ�
		String postType = request.getParameter("postType");
		String payType = request.getParameter("payType");
		String remark = request.getParameter("remark");
		String createTime = sFormat.format(date);
		double totalPrice = Integer.valueOf(request.getParameter("totalPrice").replace("��", "").trim());
		//ʹ�õ�ǰʱ���userid��16�������ɶ�����
		String orderId = orderNum.format(date)+Integer.toHexString(userId);
		Orders order = new Orders(orderId, createTime, 1, totalPrice, payType, postType, remark, maid, addressee, cityAddress, streetAddress, phone,userId);
		//������Ĳ���
		orderService.insertNewOrder(order);
		
		String carIds = request.getParameter("carIds").trim();
		String carIdStringArray [] = carIds.split(", ");
		int carIdIntArray [] = new int[carIdStringArray.length];
		for(int i = 0; i < carIdStringArray.length; i++)
		{
			carIdIntArray[i] = Integer.valueOf(carIdStringArray[i]);
		}
		List<Cart> carts = carService.selectMyCartByCarIds(carIdIntArray);
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
 		for (Cart cart : carts) {
			OrderDetails orderDetail = new OrderDetails();
			orderDetail.setOrderId(orderId);
			orderDetail.setProductid(cart.getProduct().getId());
			orderDetail.setNum(cart.getNum());
			orderDetail.setPrice(cart.getNum()*cart.getProduct().getPrice());
			orderDetails.add(orderDetail);
		}
		//����ϸ�ڱ�Ĳ���
		orderService.insertOrderDetails(orderDetails);
		//������Ʒ��� | ���ڴ˴������棬���ݵ����ﳵ����
		/*for (OrderDetails orderDetail : orderDetails) {
			productItemsService.updateProductstorageByProductId(orderDetail);
		}*/
		//ɾȥ���ﳵ��¼
		carService.deleteCarRecordByCarId(carIdIntArray);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ordersuccess");
		return modelAndView;
	}
	@RequestMapping("/getOrders.action")
	public ModelAndView getOrders(HttpServletRequest request ,HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();	
		UserInfo userInfo  = (UserInfo)session.getAttribute("userInfo");
		int userId = userInfo.getId();
		
		List<Orders> orders = orderService.selectOrdersByUserId(userId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orders", orders);
		modelAndView.setViewName("order");
		return modelAndView;
		
	}
	@RequestMapping("/showOrderDetail.action")
	public ModelAndView showOrderDetail(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String orderId = request.getParameter("orderId");
		List<OrderDetails> orderDetails = orderService.selectOrderDetailsByOrderId(orderId);
		Orders orders = orderService.selectOrderByOrderId(orderId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("order", orders);
		modelAndView.addObject("odlist", orderDetails);
		modelAndView.setViewName("orderDetail");
		return modelAndView;
	}
	@RequestMapping("/changeOrdersByOrderStatus.action")
	public void changeOrdersByOrderStatus(HttpServletRequest request,HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();	
		UserInfo userInfo  = (UserInfo)session.getAttribute("userInfo");
		int userId = userInfo.getId();
		int orderStatus = Integer.valueOf(request.getParameter("status"));
		List<Orders> orders = orderService.selectOrdersByUserIdAndStatus(userId, orderStatus);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		for (Orders order : orders) {
			out.print("<tr>");
			out.print("<td>"+order.getOrderId()+"</td>");
			out.print("<td>"+order.getCreateTime()+"</td>");
			out.print("<td>"+order.getSumPrice()+"</td>	");
			out.print("<td>");
			if(order.getState()==1) {
				out.print("δ����");
			}else if(order.getState()==2) {
				out.print("�ѷ���");
			}else if(order.getState()==3) {
				out.print("�����");
			}
			out.print("</td>");
			out.print("<td>");
			out.print("<a href='"+request.getContextPath()+"/showOrderDetail.action?orderId="+order.getOrderId()+"'>�鿴����</a>");
			if(order.getState()==1) {
				out.print("&nbsp;&nbsp;|&nbsp;&nbsp;<a href='"+request.getContextPath()+"/payTest.action?orderId="+order.getOrderId()+"'>����֧��</a>");
			}
			out.print("</td>");
			out.print("</tr>");
		}
	}
	@RequestMapping("/payTest.action")
	public ModelAndView payTest(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String orderId = request.getParameter("orderId");
		orderService.changeOrderStatus(orderId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("paysuccess");
		return modelAndView;
	}
}
