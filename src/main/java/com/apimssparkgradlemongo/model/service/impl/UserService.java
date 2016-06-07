/**
 * 
 */
package com.apimssparkgradlemongo.model.service.impl;

import com.apimssparkgradlemongo.model.dao.AbstractDao;
import com.apimssparkgradlemongo.model.dao.IUserDao;
import com.apimssparkgradlemongo.model.entity.User;
import com.apimssparkgradlemongo.model.service.AbstractService;
import com.apimssparkgradlemongo.model.service.IUserService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author eloibilek@gmail.com
 */
@Singleton
public class UserService extends AbstractService<User> implements IUserService{

	private IUserDao userDao;
	
	@Inject
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AbstractDao<User> getDao() {
		return (AbstractDao<User>) userDao;
	}
}
