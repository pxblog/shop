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
		// TODO �Զ����ɵķ������
		carMapper.insertShop(list);
	} 

	@Override
	public int selectExistById(Map<String, Integer> map) {
		// TODO �Զ����ɵķ������
		return carMapper.selectExistByUserId(map);
	}

	@Override
	public void addOrderAmountById(Map<String, Integer> map) {
		// TODO �Զ����ɵķ������
		carMapper.updataOrderAmount(map);
	}

	@Override
	public List<Cart> selectMyCartByUserId(int id) {
		// TODO �Զ����ɵķ������
		
		return carMapper.selectMyCartByUserId(id);
	}

	@Override
	public void updateCarByCarIdAndKeyWord(int carId,String keyWord) {
		// TODO �Զ����ɵķ������
		if(keyWord.equals("jia")) {
			carMapper.increaseOrderAmountByCarId(carId);
		}else if(keyWord.equals("jian")) {
			carMapper.decreaseOrderAmountByCarId(carId);
		}
		
	}

	@Override
	public void updateCarByCarIdsAndKeyWord(int[] carIds, String keyWord) {
		// TODO �Զ����ɵķ������
		carMapper.deleteOrderAmountByCarIds(carIds);
	}

	@Override
	public List<Cart> selectMyCartByCarIds(int carIds[]) {
		// TODO �Զ����ɵķ������
		return carMapper.selectMyCartByCarIds(carIds);
	}

	@Override
	public void deleteCarRecordByCarId(int[] list) {
		// TODO �Զ����ɵķ������
		carMapper.deleteOrderAmountByCarIds(list);
	}

	@Override
	public void updateCarByCarIdAndChangeNum(int carId, int changeNum) {
		// TODO �Զ����ɵķ������
		carMapper.updateOrderAmountByCarIdAndChangeNum(carId, changeNum);
	}

}
