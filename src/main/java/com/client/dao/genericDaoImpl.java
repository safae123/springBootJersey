package com.client.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class genericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	private Class<T> persistentClass;
	
	 @Autowired 
	 private SessionFactory _sessionFactory; 
	 
	 
	  public genericDaoImpl(final Class<T> persistentClass) {
	        this.persistentClass = persistentClass;
	 }
	  
	 private Session getSession() { 
		 Session sess = _sessionFactory.getCurrentSession();
			if (sess == null) {
				sess = _sessionFactory.openSession();
			}
			return sess;
	 } 

	 
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/***************************************/

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		//Session sess = sessionFactory.getCurrentSession();
		return getSession().createCriteria(persistentClass).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(PK id) {
		//Session sess = sessionFactory.getCurrentSession();
		return (T) getSession().get(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T save(T object) {
		//Session sess = sessionFactory.getCurrentSession();
		return (T) getSession().merge(object);
	}

	@SuppressWarnings("unchecked")
	public T merge(final T object) {
		return (T) getSession().merge(object);
	}

	public T saveOrUpdate(final T object) {
		getSession().saveOrUpdate(object);
		return object;
	}

	@Override
	public T remove(T object) {
		//Session sess = sessionFactory.getCurrentSession();
		getSession().delete(object);
		return object;
	}

	@Override
	public T update(T object) {
		getSession().update(object);
		return object;
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

}
