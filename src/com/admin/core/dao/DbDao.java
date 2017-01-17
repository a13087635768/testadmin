package com.admin.core.dao;

import java.io.Serializable;
import java.util.List;

public interface DbDao<T> {

		public void save(T entity);  
	  
	    public void update(String value ,String newvalue);  
	  
	    public void delete(Serializable id);  
	  
	    public T findById(Serializable id);  
	    public T findByName(String name);  
	    public List<T> findObjects();;
	    public void setindex(String tablename,String idname,String idvalue );
}
