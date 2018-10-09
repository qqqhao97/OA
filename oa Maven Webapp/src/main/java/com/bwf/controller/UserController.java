package com.bwf.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Menu;
import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.StringUtils;

@Controller
@RequestMapping("user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userservice;
	
	@GetMapping("login")
	public String login(Integer error , ModelMap modelmap){
		modelmap.addAttribute("error", error);
		return "user/login";
	}
	
	@PostMapping("doLogin")
	public String dologin(User user , HttpSession session){

//		logger.info("{},{}",user.getUsername(),user.getPassword());
		//密码加密
		user.setPassword(StringUtils.md5(user.getPassword()));
		
		//执行登陆
		User loginUser = userservice.login(user);
		
		if(loginUser==null){
			logger.info("登录失败");
			return "redirect:/user/login?error=1";
		}else{
			logger.info("登录成功");
//			User userWithMenus = userservice.getMenusByUserId(loginUser.getUserId());
			session.setAttribute("user", loginUser);
//			for(Menu m : userWithMenus.getMenus()){
//				logger.info(m.getMenuName());
//			}
			return "redirect:/index";
		}
	}
	
	//退出登录
	@GetMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/user/login";
	}
}
