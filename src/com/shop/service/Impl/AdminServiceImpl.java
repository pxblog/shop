package com.shop.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Admin;
import com.shop.mapper.AdminMapper;
import com.shop.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminMapper adminMapper;
	
	@Override
	public Admin checkAdmin(Admin admin) {
		// TODO �Զ����ɵķ������
		
		return adminMapper.selectAdminRight(admin);
	}

}
