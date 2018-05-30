Threshold for Docker
====================

These instructions are for running Threshold as a plain Docker container.

See instructions for:

* [Kubernetes](kubernetes.md)
* [Docker Compose](docker-compose.md)

---

Start Threshold using:

    docker run -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/threshold/apis gatehill/threshold-gateway

## Example

```
$ docker run -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/threshold/apis gatehill/threshold-gateway
[threshold] Generating registry
INFO  Loaded declaration: /opt/threshold/apis/simple.yml
[threshold] Booting gateway
25-Mar-2018 23:32:33.756 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server version:        Apache Tomcat/8.5.29
...
25-Mar-2018 23:32:34.231 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [/usr/local/tomcat/webapps/ROOT.war]
25-Mar-2018 23:32:36.666 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [/usr/local/tomcat/webapps/ROOT.war] has finished in [2,434] ms
25-Mar-2018 23:32:36.670 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
```
