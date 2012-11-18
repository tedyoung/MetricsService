package com.dev.metrics.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dev.metrics.dao.Metrics;
import com.yammer.metrics.annotation.Timed;

@Path("/metricsview")
@Produces(MediaType.TEXT_HTML)
public class MetricsResource
{
	private final Metrics metrics;

	public MetricsResource(Metrics metrics)
	{
		this.metrics = metrics;
	}

	@GET
	@Timed
	public MetricsView getMetrics()
	{
		return new MetricsView(metrics);
	}
}
