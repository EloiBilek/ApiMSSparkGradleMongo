/**
 * 
 */
package com.apimssparkgradlemongo.resource;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import com.apimssparkgradlemongo.model.entity.User;
import com.apimssparkgradlemongo.model.service.IUserService;
import com.apimssparkgradlemongo.util.JsonTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

/**
 * Controlle / Resource class to CRUD access through the use of Rest.
 * 
 * @author eloibilek@gmail.com
 */
public class UserResource {

	@Inject
	private IUserService userService;

	/*
	 * Other way (best), is use Properties file...
	 */
	private static final String API_CONTEXT = "ApiMSSparkGradleMongo/";
	private static final String API_VERSION = "v1/";
	private static final String API_RESOURCE = "users";

	public UserResource() {

		JsonTransformer jsonTransformer = new JsonTransformer();

		/**
		 * The methods, are implemented with Spark, using lambda expression of Java 8!!!
		 */

		// Get all
		get(API_CONTEXT + API_VERSION + API_RESOURCE, (request, response) -> userService.findAll(),
				jsonTransformer::render);

		// Get by id
		get(API_CONTEXT + API_VERSION + API_RESOURCE + "/:id", (request, response) -> {
			try {
				String id = request.params(":id");
				User user = userService.findById(id);
				if (user != null) {
					return user;
				}
				return user;
			} catch (Exception e) {
				response.status(500);
				return e.getMessage();
			}
		}, jsonTransformer::render);

		// Post
		post(API_CONTEXT + API_VERSION + API_RESOURCE, (request, response) -> {
			try {
				ObjectMapper mapper = new ObjectMapper();
				User user = mapper.readValue(request.body(), User.class);
				user = userService.create(user);
				response.status(201);
				response.type("application/json");
				return user;
			} catch (Exception e) {
				response.status(500);
				return e.getMessage();
			}
		}, jsonTransformer::render);

		// Put
		put(API_CONTEXT + API_VERSION + API_RESOURCE, (request, response) -> {
			try {
				ObjectMapper mapper = new ObjectMapper();
				User user = mapper.readValue(request.body(), User.class);
				user = userService.update(user);
				response.status(200);
				response.type("application/json");
				return user;
			} catch (Exception e) {
				response.status(500);
				return e.getMessage();
			}
		}, jsonTransformer::render);

		// Delete
		delete(API_CONTEXT + API_VERSION + API_RESOURCE + "/:id", (request, response) -> {
			String id = request.params(":id");
			userService.deleteById(id);
			return "User deleted!!!";
		});

		// Test requests...
		get("/test", (request, response) -> "Jetty Server On!!!");
	}
}
