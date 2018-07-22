Threshold for Docker
====================

These instructions are for running Threshold as a plain Docker container.

See instructions for:

* [Kubernetes](../kubernetes/tutorial.md)
* [Docker Compose](docker-compose.md)

---

Start Threshold using:

    docker run -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway

## Example

```
$ docker run -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway
[threshold] Generating registry
INFO  Loaded declaration: /opt/kamara/apis/simple.yml
[threshold] Booting gateway
25-Mar-2018 23:32:33.756 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server version:        Apache Tomcat/8.5.29
...
25-Mar-2018 23:32:34.231 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [/usr/local/tomcat/webapps/ROOT.war]
25-Mar-2018 23:32:36.666 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [/usr/local/tomcat/webapps/ROOT.war] has finished in [2,434] ms
25-Mar-2018 23:32:36.670 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
```

You now have an API Gateway running at [http://localhost:8080](http://localhost:8080), complete with a sample caching policy. 

### Test it

    curl -v http://localhost:8080/apis/example/1.0/

The first time you run this, you will receive an HTTP response from the backend - in this case, the website `example.com`. Because our example here adds a caching policy, if you run this command again you will receive a cached copy of the page for 60 seconds.

## What's next?

* Learn about the [annotations](./configuration.md) you can add to your Kubernetes Services.
* Learn about all the [policies](../policies.md) you can apply to your APIs to control their behaviour.
* See [tips and tricks](../tips.md)help you get the most out of your Threshold installation.
