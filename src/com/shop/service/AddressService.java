package com.shop.service;

import java.util.List;

import com.shop.entity.MailingAddress;

public interface AddressService {
	public List<MailingAddress> selectAddressesByUserId(int userId);
	public MailingAddress selectAddressByMid(int maid);
	public void addAddresses(MailingAddress mailingAddress);
}
