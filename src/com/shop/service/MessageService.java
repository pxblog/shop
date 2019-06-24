package com.shop.service;

import java.util.List;

import com.shop.entity.Message;
import com.shop.entity.Page;

public interface MessageService {
	public void sendMessage(String userName,String email,String content);
	public List<Message> selectMessageByPage(Page page);
	public int selectAllMessageNum();
	public Message selectMessageById(int id);
	public void changeMessageStatusById(int id);
}
