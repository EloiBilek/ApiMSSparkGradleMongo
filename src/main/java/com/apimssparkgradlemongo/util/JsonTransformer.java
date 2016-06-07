package com.apimssparkgradlemongo.util;

import com.google.gson.Gson;

import spark.ResponseTransformer;

/** 
 * @author eloi
 * 
 * Tranforme response info in json format.
 */
public class JsonTransformer implements ResponseTransformer {

	private Gson gson = new Gson();

	@Override
	public String render(Object model) {
		return gson.toJson(model);
	}

}
