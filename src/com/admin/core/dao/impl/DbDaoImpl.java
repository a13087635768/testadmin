package com.admin.core.dao.impl;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.admin.core.dao.DbDao;

public class DbDaoImpl<T>  extends HibernateDaoSupport implements DbDao<T>{
	
	
	Class<T> clazz;
	public DbDaoImpl() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class<T>)type.getActualTypeArguments()[0];
	}

	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
		
		
	}

	@Override
	public void update(String value ,String newvalue) {
		
		
		
		//ªÒµ√ Ù–‘
		Field[] fields = clazz.getDeclaredFields();
		String temp=null;
		for (Field field : fields) {
			if(field.getName().indexOf("name")!=-1||field.getName().indexOf("Name")!=-1){
				temp=field.getName();
			}
		}
		Query query = getSession().createQuery("update "+clazz.getSimpleName()+" "+"set "+temp+" "+"= ? "+"where "+temp+" "+"= ?");
		query.setString(0, newvalue);
		query.setString(1, value);
		query.executeUpdate();

}

	@Override
	public void delete(Serializable id) {

		getHibernateTemplate().delete(findById(id));
	}

	@Override
	public T findById(Serializable id) {
		
		return 	getHibernateTemplate().get(clazz, id);

	}

	@Override
	public List<T> findObjects() {
		Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
		Query query = getSession().createQuery("from "+ clazz.getSimpleName());
		return query.list();
	}

	@Override
	public T findByName(String name) {
		Field[] fields = clazz.getDeclaredFields();
		String temp=null;
		for (Field field : fields) {
			if(field.getName().indexOf("name")!=-1||field.getName().indexOf("Name")!=-1){
				temp=field.getName();
			}
		}
		 Query query = getSession().createQuery("from "+ clazz.getSimpleName()+" where "+temp +"= ?");
		 query.setString(0, name);
		 List list = query.list();
		 System.out.println(list.get(0));
		 return (T) list.get(0);
	}

	@Override
	public void setindex(String tablename,String idname,String idvalue ) {
		String selectsql="select max(indexlist) from "+tablename;
		SQLQuery select = getSession().createSQLQuery(selectsql);
		String sql= "update  "+ tablename +" set indexlist = "+(Integer.valueOf( select.list().get(0).toString())+1)+" where "+idname+"='"+idvalue+"'";
		getSession().createSQLQuery(sql)
		.executeUpdate();
	}
	


}
