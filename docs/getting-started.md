Getting started
===============

There are lots of ways to run Threshold. See instructions for:

* [Kubernetes](kubernetes/tutorial.md)
* [Docker Compose](docker/docker-compose.md)
* [Docker](docker/docker.md)

---

We're going to run Threshold as a standalone Docker container. This will allow us to get familiar with the Gateway and explore some simple policies.

> Explore the example policies [on GitHub](https://github.com/gatehill/threshold-docs/tree/master/examples/src).

## Step 1: Policies

First, we need some policies.

Let's clone this repository and set the working directory:

    git clone https://github.com/gatehill/threshold-docs.git
    cd threshold-docs

> You can explore the example policies under the `examples/src` directory.

For this example, we're going to pick the `simple` policy.

### Step 2: Running

Let's start the gateway, pointing to the `examples/src/simple` directory.

    docker run -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway

In the logs, you'll see the gateway start, read the policy and get ready to serve traffic.

### Step 3: Testing

We now have an API Gateway running at [http://localhost:8080](http://localhost:8080), complete with a sample caching policy. 

    curl -v http://localhost:8080/apis/example/1.0/

The first time we run this, we will receive an HTTP response from the backend - in this case, the website `example.com`. Because our example here adds a caching policy, if you run this command again you will receive a cached copy of the page for 60 seconds.

## What's next?

* Learn about the [annotations](./configuration.md) you can add to your Kubernetes Services.
* Learn about all the [policies](../policies.md) you can apply to your APIs to control their behaviour.
* See [tips and tricks](../tips.md)help you get the most out of your Threshold installation.
