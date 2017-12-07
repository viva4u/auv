package com.auv.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auv.dao.userBasicDao;
import com.auv.model.User;
import com.auv.service.serviceInterface.userBasicService;

@Service
public class userBasicServiceImpl implements userBasicService{
	@Autowired
	userBasicDao userBasicDao;
	@Override
	public List<User> getAllUserService(){
		return userBasicDao.getAllUsers();
	}
	@Override
	public User getUserByIdService(int id) {
		return userBasicDao.getUserById(id);
	}
	@Override
	public Map<String, Object> pageQueryService(Map<String, Object> params){
		Map<String, Object> result = new HashMap<String,Object>();
		int total = userBasicDao.pageQuery(null).size();
		List<User> rows = userBasicDao.pageQuery(params);
		result.put("total", total);
		result.put("rows", rows);
		return result;
	}
	@Override
	public Map<String, Object> selectByFy(Map<String, Object> params){
		Map<String, Object> result = new HashMap<String,Object>();
		int total = userBasicDao.selectByFy(null).size();
		List<User> rows = userBasicDao.selectByFy(params);
		result.put("total", total);
		result.put("rows", rows);
		return result;
	}
}
