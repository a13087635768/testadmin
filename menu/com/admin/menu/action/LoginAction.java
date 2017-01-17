package com.admin.menu.action;

import com.admin.user.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends ActionSupport{

	User user;
	
	public String login(){
		if(user.getUsername().equals("sq")&&user.getPassword().equals("11111")){
			
			
			return "index"; 
		}else{
			return "login";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String zyyw(){
		
		return "zyyw";
	}
	
}
