package com.dev.metrics;

import com.dev.metrics.configuration.MetricsConfiguration;
import com.dev.metrics.dao.Metrics;
import com.dev.metrics.resource.MetricsJson;
import com.dev.metrics.resource.MetricsResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

import java.util.ArrayList;

public class MetricsService extends  Service<MetricsConfiguration>
{
	public static void main(String[] args) throws Exception
	{
		new MetricsService().run(args);
	}

  @Override
  public void initialize(Bootstrap<MetricsConfiguration> bootstrap)
  {
    bootstrap.setName("metrics-service");
    bootstrap.addBundle(new ViewBundle());
    bootstrap.addBundle(new AssetsBundle());
  }

  @Override
  public void run(MetricsConfiguration configuration, Environment environment) throws Exception {
    final ArrayList<String> urls = configuration.getUrls();
    environment.addResource(new MetricsResource(new Metrics(urls)));
    environment.addResource(new MetricsJson(new Metrics(urls)));
  }

}
