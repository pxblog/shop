package com.shop.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.entity.Cart;
import com.shop.entity.MailingAddress;
import com.shop.entity.UserInfo;
import com.shop.service.AddressService;
import com.shop.service.CarService;
import com.shop.service.ProductItemsService;


/**
 * ��Bug��������
 * 
 * */
@Controller
public class CarController {
	
	@Autowired
	CarService carService;
	@Autowired
	AddressService addressService;
	@Autowired
	ProductItemsService productItemsService;
	
	//���빺�ﳵ��������
	@RequestMapping("/addShopping.action")
	public ModelAndView addShopping(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.valueOf(request.getParameter("id"));
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		int Productstorage = productItemsService.getProductstorageByProductId(id);
		ModelAndView modelAndView = new ModelAndView();
		if(Productstorage-1>=0) {
			if (userInfo != null) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("userId", userInfo.getId());
				map.put("productId", id);
				int exist = carService.selectExistById(map);
				//����ù����¼�Ѿ������ˣ����������ϼ�һ
				if(exist>0) {
					carService.addOrderAmountById(map);
					modelAndView.addObject("id",id);
				}else {
					//�����½����ڸ��û��ò�Ʒ�Ĺ����¼
					List<Integer> list = new ArrayList<Integer>();
					list.add(userInfo.getId());
					list.add(id);
					list.add(1);
					carService.addShop(list);
					modelAndView.addObject("id",id);
				}
				//���ٿ��
				productItemsService.updateProductstorageByProductId(id, 1);
				//request�ﱾ�����id���ʲ�����������
				modelAndView.addObject("message","�ѳɹ�����");
				modelAndView.setViewName("productDetail");
			}else {
				modelAndView.addObject("message","����ʧ�ܣ����ȵ�¼");
				modelAndView.setViewName("login");
			}
		}else {
			modelAndView.addObject("id",id);
			modelAndView.addObject("message","��治�㣬����ʧ��");
			modelAndView.setViewName("productDetail");
		}
		
		return modelAndView;
	}
	
	@RequestMapping("/myCart.action")
	public ModelAndView myCart(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		ModelAndView modelAndView = new ModelAndView();
		if (userInfo != null) {
			int id = userInfo.getId();
			List<Cart> carts = carService.selectMyCartByUserId(id);
			modelAndView.addObject("carts",carts);
			modelAndView.setViewName("cart");
		}else {
			modelAndView.addObject("message","�οͲ��ܲ鿴���ﳵ�����ȵ�¼");
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	//���ѡ����ɾ������Ӧ�ð���Ӧ�Ŀ�����ȥ
	//�����ڹ��ﳵ����ҳ���ÿ�棬������̬ҳ�棬��js�����������������Ӧ�أ�������
	@RequestMapping("/myCartAjax.action")
	public void myCartAjax(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		int id = userInfo.getId();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//���ajax����������
		String keyWord = request.getParameter("keyword");
		if(keyWord.equals("delete")) {
			String carIds = request.getParameter("carIds").trim();
			//�ַ����Ŀո��޷�ȥ���������±ߵķ���
			String carIdStringArray [] = carIds.split(", ");
			int carIdIntArray [] = new int[carIdStringArray.length];
			for(int i = 0; i < carIdStringArray.length; i++)
			{
				carIdIntArray[i] = Integer.valueOf(carIdStringArray[i]);
			}
			int Productstorage = productItemsService.getProductstorageByProductId(id);
			List<Cart> carts = carService.selectMyCartByCarIds(carIdIntArray);
			for (Cart cart : carts) {
				productItemsService.updateProductstorageByProductId(cart.getProduct().getId(),cart.getNum());
			}
			carService.updateCarByCarIdsAndKeyWord(carIdIntArray, keyWord);
			out.print("ok");
		}else if(keyWord.equals("changeNum")){
			int carId = Integer.valueOf(request.getParameter("carId").trim()) ;
			int shopNum = Integer.valueOf(request.getParameter("shopNum").trim());
			//ʡ��ʹȻ��ʹ��֮ǰд�õصõ�list�ķ���
			int carIds [] = {carId};
			int Productstorage = productItemsService.getProductstorageByProductId(id);
			List<Cart> carts = carService.selectMyCartByCarIds(carIds);
				for (Cart cart : carts) {
					int changeNum = shopNum-cart.getNum();
					if(changeNum<Productstorage&&shopNum>=0) {
						productItemsService.updateProductstorageByProductId(cart.getProduct().getId(),changeNum);
						carService.updateCarByCarIdAndChangeNum(carId, changeNum);
						out.print("ok");
					}else {
						out.print("������Ч");
					}
				}
			
		}else {
			int carId = Integer.valueOf(request.getParameter("carId").trim()) ;
			int shopNum = Integer.valueOf(request.getParameter("shopNum").trim());
			//ʡ��ʹȻ��ʹ��֮ǰд�õصõ�list�ķ���
			int carIds [] = {carId};
			List<Cart> carts = carService.selectMyCartByCarIds(carIds);
			int Productstorage = productItemsService.getProductstorageByProductId(id);
			for (Cart cart : carts) {
				int cartNum = cart.getNum();
				if(keyWord.equals("jia")) {
					if(Productstorage-1>=0&&(shopNum-cartNum)<Productstorage) {
						productItemsService.updateProductstorageByProductId(cart.getProduct().getId(),shopNum-cartNum);
						carService.updateCarByCarIdAndKeyWord(carId, keyWord);
						out.print("ok");
					}else {
						out.print("������Ч");
					}
				}else if(keyWord.equals("jian")) {
					if(shopNum>=0&&(shopNum-cartNum)<Productstorage) {
						productItemsService.updateProductstorageByProductId(cart.getProduct().getId(), shopNum-cartNum);					
						carService.updateCarByCarIdAndKeyWord(carId, keyWord);
						out.print("ok");
					}else {
						out.print("������Ч");
					}
				}
			}
		}
	}
	@RequestMapping("/carSettlement.action")
	public ModelAndView carSettlement(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		int userId = userInfo.getId();
		ModelAndView modelAndView = new ModelAndView();
		String carIds = request.getParameter("carIds").trim();
		if(carIds!=""&&carIds!=null) {
			//�ַ����Ŀո��޷�ȥ���������±ߵķ���
			String carIdStringArray [] = carIds.split(", ");
			int carIdIntArray [] = new int[carIdStringArray.length];
			for(int i = 0; i < carIdStringArray.length; i++)
			{
				carIdIntArray[i] = Integer.valueOf(carIdStringArray[i]);
			}
			List<Cart> carts = carService.selectMyCartByCarIds(carIdIntArray);
			int totalPrice = 0;
			for (Cart cart : carts) {
				totalPrice += (cart.getProduct().getPrice()*cart.getNum());
			}
			List<MailingAddress> mailingAddresses = addressService.selectAddressesByUserId(userId);
			
			modelAndView.addObject("mailingAddresses",mailingAddresses);
			modelAndView.addObject("carIds",carIds);
			modelAndView.addObject("totalPrice",totalPrice);
			modelAndView.setViewName("pay");
		}else {
			modelAndView.setViewName("cart");
		}
		
		return modelAndView;
	}
}
