package com.auv.service.serviceInterface;

import java.util.List;

import com.auv.model.User;

public interface userBasicService {
	public List<User> getAllUserService();
	public User getUserByIdService(int id);
}
