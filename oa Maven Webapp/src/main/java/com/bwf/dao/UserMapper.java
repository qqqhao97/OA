package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.User;

public interface UserMapper {
	
	void add(User user);
	
	void delete(int id);
	
	void update(User user);

	User getUserById(int id);
	
	User getUserByUsernameAndPassword(User user);
	
	User getMenusAndOperatesByUserId(int userId);

	List<User> getAllUsers();
	
	Integer getAllUsersCount();

	List<User> getAllUsersByPage(@Param("page")Integer page, @Param("pageSize")Integer pageSize);

	void deleteMulti(@Param("idArr") Integer[] idArr);
	
}
