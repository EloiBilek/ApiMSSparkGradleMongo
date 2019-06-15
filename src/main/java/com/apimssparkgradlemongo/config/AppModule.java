/**
 * 
 */
package com.apimssparkgradlemongo.config;

import com.apimssparkgradlemongo.model.dao.IUserDao;
import com.apimssparkgradlemongo.model.dao.impl.UserDao;
import com.apimssparkgradlemongo.model.service.IUserService;
import com.apimssparkgradlemongo.model.service.impl.UserService;
import com.google.inject.AbstractModule;

/**
 * Class to implement dependency injection, between interfaces and concrete
 * classes.
 * 
 * @author eloibilek@gmail.com
 */
public class AppModule extends AbstractModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(IUserDao.class).to(UserDao.class);
		bind(IUserService.class).to(UserService.class);
		bind(IConnectionDB.class).to(MongoDBConnection.class);
	}
}
