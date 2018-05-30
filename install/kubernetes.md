Threshold for Kubernetes
========================

There are two ways to run Threshold in a Kubernetes environment:

 1. with a static configuration
 2. with autodiscovered configuration 

In the static approach you add your configuration to a ConfigMap, and deploy the Gateway.

If you wish to use autodiscovery, create an empty ConfigMap and add annotations to your Service (see below). You must also deploy the Gateway component.

# Threshold Gateway

Install the Gateway with `kubectl`:

    cd artifacts/kubernetes
    kubectl apply -f gateway.yml

## Example

```
$ kubectl apply -f artifacts/kubernetes/threshold.yml
configmap "threshold-apis" created
deployment "threshold-deployment" created
service "threshold-service" created

$ kubectl get pods
NAME                                 READY     STATUS    RESTARTS   AGE
threshold-deployment-5d75d65f8b-flwzr   1/1       Running   0          0s

$ kubectl logs -f threshold-deployment-5d75d65f8b-flwzr
[threshold] Generating registry
INFO  Loaded declaration: /opt/threshold/apis/simple.yml
[threshold] Booting gateway
25-Mar-2018 23:32:33.756 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server version:        Apache Tomcat/8.5.29
...
25-Mar-2018 23:32:34.231 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [/usr/local/tomcat/webapps/ROOT.war]
25-Mar-2018 23:32:36.666 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [/usr/local/tomcat/webapps/ROOT.war] has finished in [2,434] ms
25-Mar-2018 23:32:36.670 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
25-Mar-2018 23:32:36.721 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in 2554 ms
```

# Kubernetes Controller

Instead of using a static configuration from a ConfigMap, Threshold can autodiscover your API services.

This requires you to start the Kubernetes Controller, `threshold-controller`, and add annotations to your Kubernetes Services.

> Note: You must also deploy the Gateway component as with the static approach, but an empty ConfigMap will suffice.

## Install the Controller

    cd artifacts/kubernetes
    kubectl apply -f controller.yml

## Annotations

Add these annotations to your Service:

| Annotation                        | Meaning                                      | Type               | Example                   |
|-----------------------------------|----------------------------------------------|--------------------|---------------------------|
| threshold.gatehill.io/name           | API name (default: service name)             | string (optional)  | example                   |
| threshold.gatehill.io/version        | API version                                  | string (required)  | "1.0"                     |
| threshold.gatehill.io/policies       | Policies to apply                            | string (required)  | cache duration 60.seconds | 
| threshold.gatehill.io/service-port   | Service port to expose (default: first port) | string (optional)  | "80"                        | 
| threshold.gatehill.io/backend-prefix | Prefix to prepend to backend path            | string (optional)  | /my/api                   | 

> Note: the policies annotation can be a multiline string, e.g.

```
threshold.gatehill.io/policies: |
  cache duration 60.seconds
  limit to 10 per minute
```

## Example

An example Service with annotations.

```
apiVersion: v1
kind: Service
metadata:
  name: example
  labels:
    app: example
  annotations:
    threshold.gatehill.io/version: "1.0"
    threshold.gatehill.io/policies: |
      cache duration 60.seconds
      limit to 10 per minute
spec:
  type: ClusterIP
  selector:
    app: example
  ports:
  - name: "http"
    port: 80
    targetPort: 8080
```

## What does this do?

The configuration above exposes an API for the 'example' service, with two policies. It would be accessible at:

    http://<threshold gateway>/apis/example/1.0
