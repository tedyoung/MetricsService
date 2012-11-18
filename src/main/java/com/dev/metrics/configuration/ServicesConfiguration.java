package com.dev.metrics.configuration;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonProperty;

import com.yammer.dropwizard.config.Configuration;

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
