package com.bwf.dao;

import com.bwf.entity.User;

public interface UserMapper {
	
	void add(User user);
	
	void delete(int id);
	
	void update(User user);

	User getUserById(int id);
	
	User getUserByUsernameAndPassword(User user);
	
	User getMenusByUserId(int userId);
	
}
