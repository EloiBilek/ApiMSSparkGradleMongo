/**
 * 
 */
package com.apimssparkgradlemongo.config;

import org.mongodb.morphia.Datastore;

/**
 * @author eloibilek@gmail.com
 */
public interface IConnectionDB {
	public Datastore getConnection();
	public void closeConnetion();
}
