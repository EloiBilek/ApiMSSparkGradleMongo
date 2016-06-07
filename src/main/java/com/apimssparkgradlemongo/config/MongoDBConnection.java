/**
 * 
 */
package com.apimssparkgradlemongo.config;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.google.inject.Singleton;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author eloibilek@gmail.com
 */
@Singleton
public class MongoDBConnection implements IConnectionDB {

	private Datastore datastore;
	private static MongoClient mongoClient;

	private static final String dbHost = "127.0.0.1";
	private static final String dbName = "api_example";
	private static final Integer dbPort = 27017;

	static final Logger LOGGER = Logger.getLogger(MongoDBConnection.class.getName());

	private Mongo getMongoClient() throws UnknownHostException, Exception {
		if (mongoClient == null) {
			mongoClient = new MongoClient(dbHost, dbPort);
		}
		return mongoClient;
	}

	@Override
	public Datastore getConnection() {
		if (datastore == null) {
			try {
				Morphia morphia = new Morphia();
				morphia.mapPackage("com.apimssparkgradlemongo.model.entity");
				datastore = morphia.createDatastore((MongoClient) getMongoClient(), dbName);
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, ":::Error in MongoDBConnection -> getConnection:::", e);
			}
		}
		return datastore;
	}

	@Override
	public void closeConnetion() {
		datastore.getMongo().close();
		if (mongoClient != null) {
			mongoClient.close();
		}
	}
}
