package com.dev.metrics.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class MetricsConfiguration extends Configuration
{
	@Valid
	@NotNull
	@JsonProperty
	private ServicesConfiguration services = new ServicesConfiguration();

	public ArrayList<String> getUrls()
	{
		return services.getUrls();
	}
}
