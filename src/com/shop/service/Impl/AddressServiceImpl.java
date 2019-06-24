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
		// TODO �Զ����ɵķ������
		return addressMapper.selectAddressesByUserId(userId);
	}

	@Override
	public void addAddresses(MailingAddress mailingAddress) {
		// TODO �Զ����ɵķ������
			addressMapper.addAddresses(mailingAddress);
		
		
	}

	@Override
	public MailingAddress selectAddressByMid(int maid) {
		// TODO �Զ����ɵķ������
		return addressMapper.selectAddressByMid(maid);
	}



}
