package com.client.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

	/**
	 * return all object
	 */
	List<T> getAll();
	
	/**
	 * save object T
	 * 
	 * @param object  the object T
	 *  @return  objects T
	 */
	T save(T object);
	
	/**
	 * save or update object T
	 * 
	 * @param object  the object T
	 *  @return  objects T
	 */
	T saveOrUpdate(T object);
	
	/**
	 * merge object T
	 * 
	 * @param object  the object T
	 *  @return  objects T
	 */
	T merge(T object);

	/**
	 * delete an object
	 * 
	 * @param object the object T
	 * @return  objects T
	 */
	T remove(T object);
	
	/**
	 * update an object
	 * 
	 * @param object the object T
	 * @return  objects T
	 */
	T update(T object);


	T findById(PK id);

}
