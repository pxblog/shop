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
		// TODO �Զ����ɵķ������
		orderMapper.insertNewOrder(order);
	}

	@Override
	public void insertOrderDetails(List<OrderDetails> orderDetails) {
		// TODO �Զ����ɵķ������
		orderMapper.insertOrderDetails(orderDetails);
	}

	@Override
	public List<Orders> selectOrdersByUserId(int userId) {
		// TODO �Զ����ɵķ������
		return orderMapper.selectOrdersByUserId(userId);
	}

	@Override
	public List<OrderDetails> selectOrderDetailsByOrderId(String OrderId) {
		// TODO �Զ����ɵķ������
		return orderMapper.selectOrderDetailsByOrderId(OrderId);
	}

	@Override
	public Orders selectOrderByOrderId(String OrderId) {
		// TODO �Զ����ɵķ������
		return orderMapper.selectOrderByOrderId(OrderId);
	}

	@Override
	public List<Orders> selectOrdersByUserIdAndStatus(int userId, int status) {
		// TODO �Զ����ɵķ������
		return orderMapper.selectOrdersByUserIdAndStatus(userId, status);
	}

	@Override
	public int selectAllOrderNum() {
		// TODO �Զ����ɵķ������
		return orderMapper.selectAllOrderNum();
	}

	@Override
	public List<Orders> selectOrdersByPageNum(Page page) {
		// TODO �Զ����ɵķ������
		return orderMapper.selectOrdersByPageNum(page);
	}

	@Override
	public void changeOrderStatus(String orderId) {
		// TODO �Զ����ɵķ������
		orderMapper.updateOrderStatus(orderId);
	}
	
}
