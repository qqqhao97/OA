package com.bwf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bwf.entity.User;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User)request.getSession().getAttribute("user");
		
		if(user == null){
			System.out.println("未登录，拦住");
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		System.out.println("已登陆，放过");
		return true;
	}
}
