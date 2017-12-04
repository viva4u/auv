package com.auv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auv.dao.userBasicDao;
import com.auv.model.User;
import com.auv.service.serviceInterface.userBasicService;

@Service
public class userBasicServiceImpl implements userBasicService{
	@Autowired
	userBasicDao userBasicDao;
	public List<User> getAllUserService(){
		return userBasicDao.getAllUsers();
	}
	public User getUserByIdService(int id) {
		return userBasicDao.getUserById(id);
	}
}
