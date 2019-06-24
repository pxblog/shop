package com.shop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.MailingAddress;
import com.shop.mapper.AddressMapper;
import com.shop.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressMapper addressMapper;
	
	@Override
	public List<MailingAddress> selectAddressesByUserId(int userId) {
		// TODO 自动生成的方法存根
		return addressMapper.selectAddressesByUserId(userId);
	}

	@Override
	public void addAddresses(MailingAddress mailingAddress) {
		// TODO 自动生成的方法存根
			addressMapper.addAddresses(mailingAddress);
		
		
	}

	@Override
	public MailingAddress selectAddressByMid(int maid) {
		// TODO 自动生成的方法存根
		return addressMapper.selectAddressByMid(maid);
	}



}
