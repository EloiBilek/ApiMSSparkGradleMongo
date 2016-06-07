/**
 * 
 */
package com.apimssparkgradlemongo.model.service;

import java.util.List;

import com.apimssparkgradlemongo.model.common.IOperations;
import com.apimssparkgradlemongo.model.dao.AbstractDao;

/**
 * @author eloibilek@gmail.com
 */
public abstract class AbstractService<T> implements IOperations<T> {

	public abstract AbstractDao<T> getDao();

	@Override
	public T findById(String id) {
		return getDao().findById(id);
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	public T create(T entity) {
		return getDao().create(entity);
	}

	@Override
	public T update(T entity) {
		return getDao().update(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public void deleteById(String entityId) {
		getDao().deleteById(entityId);
	}
}