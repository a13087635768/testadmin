package com.admin.menu.service.impl;

import com.admin.core.service.Impl.DbServiceImpl;
import com.admin.menu.dao.ColumnDao;
import com.admin.menu.entity.TColume;
import com.admin.menu.service.ColumnService;


public class ColumnServiceImpl extends DbServiceImpl<TColume> implements ColumnService {
		
	private ColumnDao columnDao;

		public void setColumnDao(ColumnDao columnDao) {
			super.setDbDao(columnDao);
			this.columnDao = columnDao;
		}

		
}
