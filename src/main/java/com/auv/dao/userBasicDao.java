package com.auv.dao;

import java.util.List;
import java.util.Map;

import com.auv.model.User;

public interface userBasicDao {
	public List<User> getAllUsers();
	public User getUserById(int id);
	public List<User> pageQuery(Map<String, Object> params);
	public List<User> selectByFy(Map<String, Object> params);
}
