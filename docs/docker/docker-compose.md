Threshold for Docker Compose
============================

These instructions are for running Threshold with Docker Compose.

## Running

Start Threshold using `docker-compose`:

    cd artifacts/docker-compose
	docker-compose up

> Get the files for this example [on GitHub](https://github.com/gatehill/threshold-docs/tree/master/artifacts/docker-compose).

## Example

```
$ docker-compose up
Creating network "compose_default" with the default driver
Creating compose_threshold_1 ... done
Attaching to compose_threshold_1
threshold_1  | [threshold] Generating registry
threshold_1  | INFO  Loaded declaration: /opt/kamara/apis/simple.yml
threshold_1  | [threshold] Booting gateway
threshold_1  | 25-Mar-2018 23:32:33.756 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server version:        Apache Tomcat/8.5.29
...
threshold_1  | 25-Mar-2018 23:32:34.231 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [/usr/local/tomcat/webapps/ROOT.war]
threshold_1  | 25-Mar-2018 23:32:36.666 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [/usr/local/tomcat/webapps/ROOT.war] has finished in [2,434] ms
threshold_1  | 25-Mar-2018 23:32:36.670 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
threshold_1  | 25-Mar-2018 23:32:36.721 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in 2554 ms
```

You now have an API Gateway running at [http://localhost:8080](http://localhost:8080), complete with a sample caching policy. 

### Test it

    curl -v http://localhost:8080/apis/example/1.0/

The first time you run this, you will receive an HTTP response from the backend - in this case, the website `example.com`. Because our example here adds a caching policy, if you run this command again you will receive a cached copy of the page for 60 seconds.

## What's next?

* Learn about all the [policies](../policies.md) you can apply to your APIs to control their behaviour.
* See [tips and tricks](../tips.md) to help you get the most out of your Threshold installation.
