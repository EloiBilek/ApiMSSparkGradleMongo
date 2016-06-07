package com.apimssparkgradlemongo.model.common;

import java.util.List;

/**
 * @author eloi eloibilek@gmail.com
 */
public interface IOperations<T> {

	T findById(final String id);

	List<T> findAll();

	T create(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final String entityId);

}
