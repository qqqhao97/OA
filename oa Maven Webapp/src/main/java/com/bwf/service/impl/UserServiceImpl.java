package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserMapper usermapper;
	
	@Transactional
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		//含基本信息的对象
		User u = usermapper.getUserByUsernameAndPassword(user);
		if(u!= null){
			u = usermapper.getMenusAndOperatesByUserId(u.getUserId());
		}
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return usermapper.getAllUsers();
	}

	@Override
	public Integer getAllUsersCount() {
		// TODO Auto-generated method stub
		return usermapper.getAllUsersCount();
	}

	@Override
	public List<User> getAllUsersByPage(Integer page , Integer pageSize) {
		// TODO Auto-generated method stub
		Integer p = (page-1)*pageSize;
		return usermapper.getAllUsersByPage(p,pageSize);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		usermapper.delete(id);
	}

	@Override
	public void deleteMulti(Integer[] idArr) {
		// TODO Auto-generated method stub
		usermapper.deleteMulti(idArr);
	}


//	public User getMenusByUserId(int id) {
//		// TODO Auto-generated method stub
//		return usermapper.getMenusByUserId(id);
//	}

}
