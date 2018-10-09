package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserMapper usermapper;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		//含基本信息的对象
		User u = usermapper.getUserByUsernameAndPassword(user);
		
		if(u!= null){
			u = usermapper.getMenusByUserId(user.getUserId());
		}
		return u;
	}


//	public User getMenusByUserId(int id) {
//		// TODO Auto-generated method stub
//		return usermapper.getMenusByUserId(id);
//	}

}
