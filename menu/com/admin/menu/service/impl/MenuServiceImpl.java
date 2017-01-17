package com.admin.menu.service.impl;

import com.admin.core.service.Impl.DbServiceImpl;
import com.admin.menu.dao.MenuDao;
import com.admin.menu.entity.TMenu;
import com.admin.menu.service.MenuService;


public class MenuServiceImpl extends DbServiceImpl<TMenu>  implements  MenuService{

	
	private MenuDao menuDao;


	public void setMenuDao(MenuDao menuDao) {
		super.setDbDao(menuDao);
		this.menuDao = menuDao;
	}
	
	public MenuDao getMenuDao() {
		return menuDao;
	}



}
