/**
 * 
 */
package com.apimssparkgradlemongo.model.dao.impl;

import org.mongodb.morphia.Datastore;

import com.apimssparkgradlemongo.config.IConnectionDB;
import com.apimssparkgradlemongo.model.dao.AbstractDao;
import com.apimssparkgradlemongo.model.dao.IUserDao;
import com.apimssparkgradlemongo.model.entity.User;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author eloibilek@gmail.com
 */
@Singleton
public class UserDao extends AbstractDao<User> implements IUserDao {

	@Inject
	public IConnectionDB mongoConnection;

	public UserDao() {
		super(User.class);
	}

	@Override
	public Datastore getDatastore() {
		return mongoConnection.getConnection();
	}

}
