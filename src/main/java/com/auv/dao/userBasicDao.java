package com.auv.dao;

import java.util.List;
import com.auv.model.User;

public interface userBasicDao {
	public List<User> getAllUsers();
	public User getUserById(int id);
}
