package com.dev.metrics.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class ServicesConfiguration extends Configuration
{
	@Valid
	@NotNull
	@JsonProperty
	private ArrayList<String> urls;

	public ArrayList<String> getUrls()
	{
		for (String url : urls)
			System.out.println("URL: " + url);
		return urls;
	}
}
