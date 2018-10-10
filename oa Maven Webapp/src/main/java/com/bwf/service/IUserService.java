package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;

public interface IUserService {

	User login(User user);

	List<User> getAllUsers();

	Integer getAllUsersCount();

	List<User> getAllUsersByPage(Integer page, Integer pageSize);

	void delete(Integer id);

	void deleteMulti(Integer[] idArr);
	
}
