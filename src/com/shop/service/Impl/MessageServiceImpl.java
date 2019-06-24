package com.shop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Message;
import com.shop.entity.Page;
import com.shop.mapper.MessageMapper;
import com.shop.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	MessageMapper messageMapper;

	@Override
	public void sendMessage(String userName, String email, String content) {
		// TODO 自动生成的方法存根
		messageMapper.sendMessage(userName, email, content);
	}

	@Override
	public List<Message> selectMessageByPage(Page page) {
		// TODO 自动生成的方法存根
		return messageMapper.selectMessageByPage(page);
	}

	@Override
	public int selectAllMessageNum() {
		// TODO 自动生成的方法存根
		return messageMapper.selectAllMessageNum();
	}

	@Override
	public Message selectMessageById(int id) {
		// TODO 自动生成的方法存根
		return messageMapper.selectMessageById(id);
	}

	@Override
	public void changeMessageStatusById(int id) {
		// TODO 自动生成的方法存根
		messageMapper.updateMessageStatusById(id);
	}

}
