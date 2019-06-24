package com.shop.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.OrderDetails;
import com.shop.entity.Orders;
import com.shop.entity.Page;
import com.shop.entity.UserInfo;
import com.shop.mapper.OrderMapper;
import com.shop.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public void insertNewOrder(Orders order) {
		// TODO 自动生成的方法存根
		orderMapper.insertNewOrder(order);
	}

	@Override
	public void insertOrderDetails(List<OrderDetails> orderDetails) {
		// TODO 自动生成的方法存根
		orderMapper.insertOrderDetails(orderDetails);
	}

	@Override
	public List<Orders> selectOrdersByUserId(int userId) {
		// TODO 自动生成的方法存根
		return orderMapper.selectOrdersByUserId(userId);
	}

	@Override
	public List<OrderDetails> selectOrderDetailsByOrderId(String OrderId) {
		// TODO 自动生成的方法存根
		return orderMapper.selectOrderDetailsByOrderId(OrderId);
	}

	@Override
	public Orders selectOrderByOrderId(String OrderId) {
		// TODO 自动生成的方法存根
		return orderMapper.selectOrderByOrderId(OrderId);
	}

	@Override
	public List<Orders> selectOrdersByUserIdAndStatus(int userId, int status) {
		// TODO 自动生成的方法存根
		return orderMapper.selectOrdersByUserIdAndStatus(userId, status);
	}

	@Override
	public int selectAllOrderNum() {
		// TODO 自动生成的方法存根
		return orderMapper.selectAllOrderNum();
	}

	@Override
	public List<Orders> selectOrdersByPageNum(Page page) {
		// TODO 自动生成的方法存根
		return orderMapper.selectOrdersByPageNum(page);
	}

	@Override
	public void changeOrderStatus(String orderId) {
		// TODO 自动生成的方法存根
		orderMapper.updateOrderStatus(orderId);
	}
	
}
