package com.shop.mapper;

import java.util.List;
import java.util.Map;

import com.shop.entity.Cart;

public interface CarMapper {
	public void insertShop(List<Integer> list);
	public int selectExistByUserId(Map<String, Integer> map);
	public void updataOrderAmount(Map<String, Integer> map);
	public void decreaseOrderAmountByCarId(int id);
	public void increaseOrderAmountByCarId(int id);
	public void updateOrderAmountByCarIdAndChangeNum(int id,int changeNum);
	public void deleteOrderAmountByCarIds(int ids[]);
	public List<Cart> selectMyCartByUserId(int id);
	public List<Cart> selectMyCartByCarIds(int carIds[]);
}
