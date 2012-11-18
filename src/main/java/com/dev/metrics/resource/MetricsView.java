package com.dev.metrics.resource;

import com.dev.metrics.dao.Metrics;
import com.yammer.dropwizard.views.View;

public class MetricsView extends View
{
	private final Metrics metrics;

	protected MetricsView(Metrics metrics)
	{
		super("metrics.ftl");
		this.metrics = metrics;
	}

	public Metrics getMetrics()
	{
		return metrics;
	}
}
