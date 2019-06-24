package com.shop.service;

import java.util.List;
import java.util.Map;

import com.shop.entity.Cart;

public interface CarService {
	public void addShop(List<Integer> list);
	public void addOrderAmountById(Map<String, Integer> map);
	public int selectExistById(Map<String, Integer> map);
	public List<Cart> selectMyCartByUserId(int id);
	public void updateCarByCarIdAndKeyWord(int carId,String keyWord);
	public void updateCarByCarIdsAndKeyWord(int carIds[],String keyWord);
	public List<Cart> selectMyCartByCarIds(int carIds[]);
	public void deleteCarRecordByCarId(int [] list);
	public void updateCarByCarIdAndChangeNum(int carId,int changeNum);
}
