
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<#-- @ftlvariable name="" type="com.csit.metrics.resource.MetricsView.MetricsView" -->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Highcharts Example</title>
		
		
		<!-- 1. Add these JavaScript inclusions in the head of your page -->
		<script src="/assets/jquery-1.8.2.min.js" type="text/javascript"></script>
		<script src="/assets/highcharts.js" type="text/javascript"></script>
		<!-- 2. Add the JavaScript to initialize the chart on document ready -->
		<script type="text/javascript">
		var jvmChart;
		var countChart;
		var rateChart;
		var meanChart;

		/**
		 * Request data from the server, add it to the graph and set a timeout to request again
		 */

		function requestData() {
		
			$.ajax({
				url: '/metricsjson',
				success: function(point) {
				
				var series = jvmChart.series[0],
				shift = series.data.length > 20; // shift if the series is longer than 20
					
				series.addPoint([(new Date().getTime()), point[0].jvm.memory.totalUsed], true, shift);

				setTimeout(requestData, 1000);    
				},
				cache: false
			});
		}
			
		$(document).ready(function() {
				jvmChart = new Highcharts.Chart({
					chart: {
						renderTo: 'container',
						defaultSeriesType: 'spline',
						events: {
							load: requestData
						}
					},
					title: {
						text: 'JVM Heap Usage'
					},
					xAxis: {
						type: 'datetime',
						tickPixelInterval: 150,
						maxZoom: 20 * 1000
					},
					yAxis: {
						minPadding: 0.2,
						maxPadding: 0.2,
						title: {
							text: 'Megabytes',
							margin: 80
						}
					},
					series: [
					{
						name: "172.17.57.168:8083",
						data: []
					}]
				});
			});		
		</script>
		
	</head>
	<body>
		
		<!-- 3. Add the container -->
		<div id="container" style="width: 800px; height: 400px; margin: 0 auto"></div>
		
	</body>
</html>
