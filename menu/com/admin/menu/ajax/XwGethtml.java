package com.admin.menu.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.admin.html.Xwdao;
import com.admin.menu.ajax.entity.AjaxColumeEntity;
import com.admin.menu.ajax.entity.AjaxMenuEntity;
import com.admin.menu.entity.TColume;
import com.admin.menu.entity.TMenu;
import com.admin.menu.entity.TSoncolume;
import com.admin.menu.service.MenuService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class XwGethtml extends ActionSupport{
	MenuService menuService;
	String menu;
	String name;
	Xwdao dao;
	/**
	 * @参数 name 
	 * @return
	 * @throws IOException
	 */
	public String select() throws IOException{
		ActionContext context = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)context.get(ServletActionContext.HTTP_RESPONSE);
		PrintWriter out = response.getWriter();
		String xw = dao.select(name);
		out.print(xw);
		out.flush();
		out.close();
		return null; 
	}
	
	/**
	 * @参数 menu
	 * @return
	 * @throws IOException
	 */
	public String allmenu() throws IOException{
		List list  = new ArrayList();
		ActionContext context = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)context.get(ServletActionContext.HTTP_RESPONSE);
		response. setCharacterEncoding("UTF-8");
		TMenu findByName = menuService.findByName(menu);
		AjaxMenuEntity ajaxMenuEntity = new AjaxMenuEntity();
		AjaxColumeEntity ajaxColumeEntity = new AjaxColumeEntity();
		List tColumes = findByName.getTColumes();
		Iterator iterator = tColumes.iterator();
		while (iterator.hasNext()) {
			TColume colum = (TColume)iterator.next();
			List tSoncolumes = colum.getTSoncolumes();
			Iterator iterator2 = tSoncolumes.iterator();
			while(iterator2.hasNext()){
				TSoncolume soncolume = (TSoncolume)iterator2.next();
				ajaxColumeEntity.setName(soncolume.getSName());
				System.out.println(soncolume.getSName());
			}
			System.out.println(colum.getCName());
			ajaxMenuEntity.setName(colum.getCName());
			list.add(ajaxColumeEntity);
			ajaxMenuEntity.setList(list);
		}
		ArrayList arrayList = new ArrayList();
		arrayList.add(ajaxMenuEntity);
		JSONArray jsonArray = JSONArray.fromObject(arrayList);
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toString());
		out.flush();
		out.close();
		return null;
	}
	public MenuService getMenuService() {
		return menuService;
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Xwdao getDao() {
		return dao;
	}
	public void setDao(Xwdao dao) {
		this.dao = dao;
	}
	
	
}
