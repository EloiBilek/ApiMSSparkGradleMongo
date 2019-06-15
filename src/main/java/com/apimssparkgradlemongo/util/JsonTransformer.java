package com.apimssparkgradlemongo.util;

import com.google.gson.Gson;

import spark.ResponseTransformer;

/**
 * Transform response info, in json format.
 * 
 * @author eloi
 */
public class JsonTransformer implements ResponseTransformer {

	private Gson gson = new Gson();

	@Override
	public String render(Object model) {
		return gson.toJson(model);
	}

}
