package com.dev.metrics.dao;

import java.util.ArrayList;

public class Metrics
{
	private final ArrayList<String> urls;

	public Metrics(ArrayList<String> urls)
	{
		this.urls = urls;
	}

	public ArrayList<String> getUrls()
	{
		return this.urls;
	}
}
