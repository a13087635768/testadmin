package com.admin.menu.service.impl;

import com.admin.core.service.Impl.DbServiceImpl;
import com.admin.menu.dao.SoncolumnDao;
import com.admin.menu.entity.TSoncolume;
import com.admin.menu.service.SoncolumnService;


public class SoncolumnServiceImpl extends DbServiceImpl<TSoncolume> implements SoncolumnService{
	
	private SoncolumnDao soncolumnDao;

	public void setSoncolumnDao(SoncolumnDao soncolumnDao) {
		super.setDbDao(soncolumnDao);
		this.soncolumnDao = soncolumnDao;
	}

	
	
}
