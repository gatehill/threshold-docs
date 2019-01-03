Getting started
===============

There are lots of ways to run Threshold. See instructions for:

* [Kubernetes](kubernetes/tutorial.md)
* [Docker Compose](docker/docker-compose.md)
* [Docker](docker/docker.md)

---

## Simple local example

In this guide, we will assume you just want to kick the tires, so we're going to run Threshold as a standalone Docker container. This will allow you to get familiar with the Gateway and explore some simple policies.

> Explore the example policies [on GitHub](https://github.com/thresholdcloud/documentation/tree/master/examples/src).

#### Step 1: API and policies

First, we need an API and some policies. Let's clone the documentation Git repository and set the working directory:

    git clone https://github.com/thresholdcloud/documentation.git
    cd threshold-docs

> You can explore the example policies under the `examples/src` directory.

For this example, the file in the `simple` directory defines an API named `example`.

This API uses as its backend the website example.com; the example we're using adds a simple policy to this API.

This policy adds simple caching behaviour to HTTP responses, meaning that after the first successful response, a cached HTTP body will be returned for subsequent requests for 60 seconds.

#### Step 2: Running

Let's start the gateway, pointing to the `simple` policy in the `examples/src/simple` directory.

    docker run -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway

Note that we're mapping the local policies directory to the `/opt/kamara/apis` location within the running container. This is the default location that Threshold looks for policy files.

In the logs of the running container you'll see the gateway start, read the policy and get ready to serve traffic.

Good job! We now have an API Gateway running at [http://localhost:8080](http://localhost:8080), complete with a sample caching policy.

#### Step 3: Testing

Now we're going to test our API, 

    curl -v http://localhost:8080/apis/example/1.0/

The first time we run this, we will receive an HTTP response from the backend - in this case, the website `example.com`. Because our example here adds a caching policy, if you run this command again you will receive a cached copy of the page for 60 seconds.

## What's next?

* Install Threshold [on a Kubernetes cluster](./kubernetes/install.md)
* Learn about all the [policies](./policies.md) you can apply to your APIs to control their behaviour.
* See [tips and tricks](./tips.md) to help you get the most out of your Threshold installation.
