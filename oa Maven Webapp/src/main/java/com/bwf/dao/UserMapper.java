package com.bwf.dao;

import com.bwf.entity.User;

public interface UserMapper {

	User getUserById(int id);
	
	User getUserByUsernameAndPassword(User user);
	
	User getMenusByUserId(int id);
	
	void add(User user);
	
	void delete(int id);
	
	void update(User user);
}
