## Prerequisites

Ensure you have followed the [Kubernetes installation](../install/kubernetes.md) instructions.

You will need to have installed _Threshold Controller_ as well as the _Gateway_ element.

Let's assume you have a Kubernetes Service that represents your backend. We are going to expose this as an API using Threshold.

### Example service

```
apiVersion: v1
kind: Service
metadata:
  name: example
  labels:
    app: example
spec:
  type: ClusterIP
  selector:
    app: example
  ports:
  - name: "http"
    port: 80
    targetPort: 8080
```

In the next section, we'll show you how to add a Threshold API endpoint to your service, and add policies to control behaviour.

## Configuration with annotations

You can configure Threshold by adding [annotations](./configuration.md) to your Kubernetes Service.

In this section, we're going to add annotations to enable the response body to be cached for 60 seconds, and we're going to limit the number of requests to the API to a maximum of 10 per minute.

Add these to the `metadata/annotations` section of your Service:

```
threshold.gatehill.io/policies: |
  cache duration 60.seconds
  limit to 10 per minute
```

> Note: in the example above we are using a YAML multiline string, denoted by the `|` character. As long as the following lines are indented (per normal YAML syntax), you can add multiple policies, each separated by a new line.

### Example

We're going to modify our example service from above to include our annotations. Note the additions to the `metadata` section:

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

### What does this do?

The configuration above exposes an API for the 'example' service, with two policies.

It would be accessible at:

    http://<threshold gateway>/apis/example/1.0

You'll note that, by default:

* the name of the service - in this case, 'example' forms part of the URL
* the API is placed into the default API Group, named 'apis'
* the API is assigned an initial version of 1.0

You can change these elements using annotations.

## What's next?

* Learn about all the [annotations](./configuration.md) you can add to your Kubernetes Service.
* Learn about all the [policies](../policies.md) you can apply to control behaviour.
