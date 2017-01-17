package com.admin.menu.service.impl;

import com.admin.core.service.Impl.DbServiceImpl;
import com.admin.menu.dao.JournalismDao;
import com.admin.menu.entity.TJournalism;
import com.admin.menu.service.JournalismService;


public class JournalismServiceImpl extends DbServiceImpl<TJournalism> implements JournalismService{
	private JournalismDao  journalismDao;

	public void setJournalismDao(JournalismDao journalismDao) {
		super.setDbDao(journalismDao);
		this.journalismDao = journalismDao;
	}
	
	
}
