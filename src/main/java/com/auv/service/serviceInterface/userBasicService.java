package com.auv.service.serviceInterface;

import java.util.List;
import java.util.Map;

import com.auv.model.User;

public interface userBasicService {
	public List<User> getAllUserService();
	public User getUserByIdService(int id);
	public Map<String, Object> pageQueryService(Map<String, Object> params);
	public Map<String, Object> selectByFy(Map<String, Object> params);
}
