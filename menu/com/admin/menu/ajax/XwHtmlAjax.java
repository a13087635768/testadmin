package com.admin.menu.ajax;

import com.admin.html.Xwdao;
import com.opensymphony.xwork2.ActionSupport;


public class XwHtmlAjax extends ActionSupport {
	
	public String name;
	public String value;
	Xwdao dao;
	
	public String insert(){
		dao.insert(name, value);
		return null;
	}
	public String update(){
		if(!dao.judge(name)){
			dao.insert(name, value);
		}else{
			dao.update(name, value); 
		}
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Xwdao getDao() {
		return dao;
	}
	public void setDao(Xwdao dao) {
		this.dao = dao;
	}
	
}
