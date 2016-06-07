/**
 * 
 */
package com.apimssparkgradlemongo.controller;

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
 * @author eloibilek@gmail.com
 */
public class UserController {

	@Inject
	private IUserService userService;

	private static final String API_CONTEXT = "ApiMSSparkGradleMongo/";

	private static final String API_VERSION = "v1/";

	private static final String API_RESOURCE = "users";

	public UserController() {

		JsonTransformer jsonTransformer = new JsonTransformer();

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
