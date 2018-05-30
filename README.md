# Threshold API Gateway

Cloud native API Gateway for Docker and Kubernetes.

* Add caching, rate limiting, authentication, IP restrictions [and much more](docs/policies.md) in front of your APIs
* Runs in Kubernetes, Docker Compose and plain Docker
* Add policies to your APIs in seconds with the simple DSL, or annotate your Kubernetes services
* [Prometheus](https://prometheus.io) metrics right out of the box

## Getting started

There are many ways to run Threshold. See instructions for:

* [Kubernetes](docs/install/kubernetes.md)
* [Docker Compose](docs/install/docker-compose.md)
* [Docker](docs/install/docker.md)

The following instructions are for running a standalone Docker container. 

**Step 1.** Start the gateway

We'll start our API Gateway with a single API, named `example`, and some test policies:

    docker run -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway

You now have an API Gateway running at [http://localhost:8080](http://localhost:8080), complete with a sample caching policy. 

**Step 2.** Test it

    curl -v http://localhost:8080/apis/example/1.0/

The first time you run this, you will receive an HTTP response from the backend - in this case, the website `example.com`. Because our example here adds a caching policy, if you run this command again you will receive a cached copy of the page for 60 seconds.

> Ready for more? See what else you can do in the [examples](examples) directory.

---

## Installation

For more detailed documentation, see the [install](docs/install) directory.

---

## About

### How it works

Threshold is an _opinionated_ distribution of the [apiman](https://apiman.io) project, slimmed down and preconfigured with sensible defaults. It comes as a prepackaged Docker image, as well as configuration files for running on Kubernetes and other container environments.

The Docker image includes the apiman Tomcat standalone distribution, custom plugins and configuration parser, based on the [apiman CLI](https://github.com/apiman/apiman-cli). This combination enables Threshold to parse and execute API policies written in its powerful DSL. 

### Roadmap

Plans for future features can be found in the [Roadmap](docs/roadmap.md).

### Thanks

Threshold uses the fantastic [apiman](https://apiman.io) project.
