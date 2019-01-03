Threshold for Kubernetes
========================

There are two elements of a Threshold installation on Kubernetes:

* *Gateway* - the actual API Gateway - installation is mandatory
* *Controller* - automatically configures the Gateway based on the Services running in your Kubernetes cluster - installation is optional, but recommended for ease of use

# Choosing your configuration approach

Before deploying anything you should decide whether you want to run Threshold with either:

 1. a static configuration - simple to start with, but requires changes to Threshold configuration every time you update your services, or
 2. autodiscovered configuration - your Threshold configuration updates automatically when your services change.

In the static approach you add your configuration to a ConfigMap, and deploy only the Gateway element.

If you wish to use autodiscovery, skip creating a ConfigMap and instead add [annotations to your Service](../kubernetes/tutorial.md). You must deploy both the Controller and Gateway components.

# Deploying the Gateway

Install the Gateway with `kubectl`:

    cd artifacts/kubernetes
    kubectl apply -f gateway.yml

> Get the files for this example [on GitHub](https://github.com/thresholdcloud/documentation/tree/master/artifacts/kubernetes).

## Example

```
$ kubectl apply -f artifacts/kubernetes/threshold.yml
configmap "threshold-apis" created
deployment "threshold-deployment" created
service "threshold-service" created
```

You should now be able to see the running pods:

```
$ kubectl get pods
NAME                                 READY     STATUS    RESTARTS   AGE
threshold-gateway-5d75d65f8b-flwzr   1/1       Running   0          0s
```

You can view the logs as follows:

```
$ kubectl logs -f threshold-deployment-5d75d65f8b-flwzr
[threshold] Generating registry
INFO  Loaded declaration: /opt/kamara/apis/simple.yml
[threshold] Booting gateway
25-Mar-2018 23:32:33.756 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server version:        Apache Tomcat/8.5.29
...
25-Mar-2018 23:32:34.231 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [/usr/local/tomcat/webapps/ROOT.war]
25-Mar-2018 23:32:36.666 INFO [localhost-startStop-1] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [/usr/local/tomcat/webapps/ROOT.war] has finished in [2,434] ms
25-Mar-2018 23:32:36.670 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
25-Mar-2018 23:32:36.721 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in 2554 ms
```

## Next steps

* Continue to install the Controller, if you are using autodiscovered configuration
* Learn about the [options](../configuration.md) for static configuration

# Deploying the Controller

Instead of using a static configuration from a ConfigMap, Threshold can autodiscover your API services.

This requires you to start the Kubernetes Controller, `threshold-controller`, and add annotations to your Kubernetes Services.

> Note: You must also deploy the Gateway component, as above, but you can skip creating the ConfigMap.

## Install the Controller

    cd artifacts/kubernetes
    kubectl apply -f controller.yml

> Get the files for this example [on GitHub](https://github.com/thresholdcloud/documentation/tree/master/artifacts/kubernetes).

## Next steps

* Continue to the [Kubernetes tutorial](../kubernetes/tutorial.md)
* Learn about the [annotations](../kubernetes/configuration.md) recognised by the Controller
