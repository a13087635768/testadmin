package com.admin.core.service.Impl;

import java.io.Serializable;
import java.util.List;

import com.admin.core.dao.DbDao;
import com.admin.core.dao.impl.DbDaoImpl;
import com.admin.core.service.DbService;
import com.admin.menu.dao.MenuDao;

public class DbServiceImpl<T> implements DbService<T> {

	protected DbDao<T> dbDao;
	public void  setDbDao(DbDao<T> dbDao) {
		this.dbDao=dbDao;
	}
	@Override
	public void save(T entity) {
		dbDao.save(entity);
	}
	@Override
	public void update(String value ,String newvalue) {
		dbDao.update(value,newvalue);		
	}
	@Override
	public void delete(Serializable id) {
		dbDao.delete(id);		
	}
	@Override
	public T findById(Serializable id) {
		return dbDao.findById(id);
	}
	@Override
	public List<T> findObjects() {
		return dbDao.findObjects();
	}
	@Override
	public T findByName(String name) {
		return dbDao.findByName(name);
	}
	@Override
	public void setindex(String tablename, String idname, String idvalue) {
		dbDao.setindex(tablename, idname, idvalue);
	}
	


}
