package com.admin.menu.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.admin.menu.entity.TColume;
import com.admin.menu.entity.TJournalism;
import com.admin.menu.entity.TMenu;
import com.admin.menu.entity.TSoncolume;
import com.admin.menu.service.ColumnService;
import com.admin.menu.service.JournalismService;
import com.admin.menu.service.MenuService;
import com.admin.menu.service.SoncolumnService;
import com.admin.user.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import util.Util;
/**
 * 
 * @author SQ
 * 2016年12月25日
 * 下午6:28:30
 */
public class MenuAction extends ActionSupport{
	
	User user;
	
//	工具包
	Util util;
//service
	MenuService menuService;
	ColumnService columnService;
	SoncolumnService soncolumnService;
	JournalismService journalismService;
	/**
	 * 测试用户登录
	 * @return
	 */
	
	public String login(){
		if(user.getUsername().equals("sq")&&user.getPassword().equals("11111")){
		;
			
			
			return "index"; 
		}else{
			return "login";
		}
	}
	
	public String zyyw(){

		TMenu findByName = menuService.findByName("主要业务");
		
//		TColume colume = new TColume();
//		colume.setCId("40288f815980dd9e015980ddc1f60000");
//		TSoncolume soncolume = new TSoncolume();
//		soncolume.setSName("son1");
//		soncolume.setTColume(colume);
//		soncolumnService.save(soncolume);

		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		
		session.put("allmenu", findByName);
		List tColumes = findByName.getTColumes();
		TColume tColume=(TColume) tColumes.get(0);
		return "zyyw";
	}
  
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Util getUtil() {
		return util;
	}

	public void setUtil(Util util) {
		this.util = util;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public ColumnService getColumnService() {
		return columnService;
	}

	public void setColumnService(ColumnService columnService) {
		this.columnService = columnService;
	}

	public SoncolumnService getSoncolumnService() {
		return soncolumnService;
	}

	public void setSoncolumnService(SoncolumnService soncolumnService) {
		this.soncolumnService = soncolumnService;
	}

	public JournalismService getJournalismService() {
		return journalismService;
	}

	public void setJournalismService(JournalismService journalismService) {
		this.journalismService = journalismService;
	}
	
	

	
}
