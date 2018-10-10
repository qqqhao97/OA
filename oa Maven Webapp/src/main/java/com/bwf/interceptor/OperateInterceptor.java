package com.bwf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bwf.entity.Operate;
import com.bwf.entity.User;

public class OperateInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println(request.getRequestURI());
		//获取session中的User对象
		User user = (User)request.getSession().getAttribute("user");
		
		boolean urlContains = false;
		//遍历对象中的Operate集合，查看是否有权限访问该uri
		for(Operate o : user.getOperates()){
			if(request.getRequestURI().contains(o.getOperateAction())){
				urlContains = true;
			}
			System.out.println(o.getOperateAction());
		}
		
		if(urlContains){
			System.out.println("有权限，放过");
			return true;
		}else{
			//没有权限 ， 返回错误页面
			System.out.println("无权限，拦截");
			response.sendRedirect(request.getContextPath()+"/error/operate");
			return false;
		}
	}
}
