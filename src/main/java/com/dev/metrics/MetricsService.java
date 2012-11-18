package com.dev.metrics;

import java.util.ArrayList;

import com.dev.metrics.configuration.MetricsConfiguration;
import com.dev.metrics.dao.Metrics;
import com.dev.metrics.resource.MetricsJson;
import com.dev.metrics.resource.MetricsResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.bundles.AssetsBundle;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

public class MetricsService extends  Service<MetricsConfiguration>
{
	public static void main(String[] args) throws Exception
	{
		new MetricsService().run(args);
	}

	private MetricsService()
	{
		super("metrics-service");
		addBundle(new ViewBundle());
		addBundle(new AssetsBundle());
	}

    @Override
	protected void initialize(MetricsConfiguration configuration, Environment environment) throws Exception
	{
		final ArrayList<String> urls = configuration.getUrls();
		environment.addResource(new MetricsResource(new Metrics(urls)));
		environment.addResource(new MetricsJson(new Metrics(urls)));
	}
}
