/**
 * 
 */
package com.apimssparkgradlemongo.init;

import static spark.Spark.port;

import java.util.logging.Logger;

import com.apimssparkgradlemongo.config.AppModule;
import com.apimssparkgradlemongo.resource.UserResource;
import com.google.inject.Guice;
import com.google.inject.Injector;
/**
 * @author eloibilek@gmail.com
 */
public class Main {
	static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		port(8080);

		Injector injector = Guice.createInjector(new AppModule());
		UserResource controller = injector.getInstance(UserResource.class);

		new UserResource();
		
		LOGGER.info("Init Jetty Server - ApiMSSparkGradleMongo On ");
	}
}
