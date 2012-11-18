MetricsService

MetricsService is a prototype for providing a monitoring GUI for services built using Dropwizard. I tried using Graphite initially but
its a hassle to set it up if you're in a standalone corporate intranet. Hence, I figured a lightweight HTML/JavaScript would do the trick.

It's a bunch of glue code for Dropwizard Views, FreeMarker and Highcharts

Jetty for HTTP servin'.
Jersey for REST modelin'.
Jackson for JSON parsin' and generatin'.
Logback for loggin'.
Hibernate Validator for validatin'.
Metrics for figurin' out what your service is doing in production.
SnakeYAML for YAML parsin' and configuratin'.
Yammer's high-performance, low-latency, Java and Scala services all use Dropwizard. In fact, Dropwizard is really just a simple extraction of Yammer's glue code.

Read more at dropwizard.codahale.com.

MetricsService
==========

*MetricsService is a prototype for providing a monitoring GUI for services built using [Dropwizard] [http://dropwizard.codahale.com].*

I tried using [Graphite] [http://graphite.wikidot.com/] initially but its a hassle to set it up if you're in a standalone corporate intranet. Hence, I figured a lightweight HTML/JavaScript backed by Dropwizard would do the trick.