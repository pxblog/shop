package com.shop.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.entity.Cart;
import com.shop.mapper.CarMapper;
import com.shop.service.CarService;

@Service("carService")
public class CarServiceImpl implements CarService{
	
	@Resource(name="carMapper")
	CarMapper carMapper; 
	
	@Override
	public void addShop(List<Integer> list) {
		// TODO 自动生成的方法存根
		carMapper.insertShop(list);
	} 

	@Override
	public int selectExistById(Map<String, Integer> map) {
		// TODO 自动生成的方法存根
		return carMapper.selectExistByUserId(map);
	}

	@Override
	public void addOrderAmountById(Map<String, Integer> map) {
		// TODO 自动生成的方法存根
		carMapper.updataOrderAmount(map);
	}

	@Override
	public List<Cart> selectMyCartByUserId(int id) {
		// TODO 自动生成的方法存根
		
		return carMapper.selectMyCartByUserId(id);
	}

	@Override
	public void updateCarByCarIdAndKeyWord(int carId,String keyWord) {
		// TODO 自动生成的方法存根
		if(keyWord.equals("jia")) {
			carMapper.increaseOrderAmountByCarId(carId);
		}else if(keyWord.equals("jian")) {
			carMapper.decreaseOrderAmountByCarId(carId);
		}
		
	}

	@Override
	public void updateCarByCarIdsAndKeyWord(int[] carIds, String keyWord) {
		// TODO 自动生成的方法存根
		carMapper.deleteOrderAmountByCarIds(carIds);
	}

	@Override
	public List<Cart> selectMyCartByCarIds(int carIds[]) {
		// TODO 自动生成的方法存根
		return carMapper.selectMyCartByCarIds(carIds);
	}

	@Override
	public void deleteCarRecordByCarId(int[] list) {
		// TODO 自动生成的方法存根
		carMapper.deleteOrderAmountByCarIds(list);
	}

	@Override
	public void updateCarByCarIdAndChangeNum(int carId, int changeNum) {
		// TODO 自动生成的方法存根
		carMapper.updateOrderAmountByCarIdAndChangeNum(carId, changeNum);
	}

}
