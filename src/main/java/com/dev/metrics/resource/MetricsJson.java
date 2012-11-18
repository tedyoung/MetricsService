package com.dev.metrics.resource;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.dev.metrics.dao.Metrics;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.yammer.metrics.annotation.Timed;

@Path("/metricsjson")
@Produces(MediaType.APPLICATION_JSON)
public class MetricsJson
{
	//private static final Log LOG = Log.forClass(MetricsJson.class);
	private final Metrics metrics;

	public MetricsJson(Metrics metrics)
	{
		this.metrics = metrics;
	}

	@GET
	@Timed
	public String getMetrics() throws JsonParseException, JsonMappingException, IOException
	{
		Client client = Client.create();
		ObjectMapper mapper = new ObjectMapper();

		ArrayList<String> urls = this.metrics.getUrls();
		ArrayList<Object> json = new ArrayList<Object>();

		for (String url : urls)
		{
			System.out.println("Calling: " + url);
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			String jsonString = response.getEntity(String.class);
			Object metricObject = mapper.readValue(jsonString, Object.class);
			//System.out.println(mapper.writeValueAsString(metricObject));

			//						LOG.info(mapper.writeValueAsString(metricObject));
			//						LOG.info("-----------------------------------------------");
			//						LOG.info("-----------------------------------------------");
			//						LOG.info("-----------------------------------------------");
			//						LOG.info("-----------------------------------------------");
			//						LOG.info("-----------------------------------------------");

			json.add(metricObject);
		}

		return mapper.writeValueAsString(json);
	}
}
