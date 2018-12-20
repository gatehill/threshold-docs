# Threshold API Gateway

_API protection for Kubernetes services and Lambda functions._

With Threshold you can:

* Add caching, rate limiting, authentication, IP restrictions [and much more](docs/policies.md) in front of your APIs
* Runs in [Kubernetes](docs/kubernetes/tutorial.md), [Docker Compose](docs/docker/docker-compose.md) and plain [Docker](docs/docker/docker.md)
* Add policies to your APIs in seconds with the simple DSL, or annotate your Kubernetes services
* [Prometheus](https://prometheus.io) metrics right out of the box

> Visit the [Threshold website](https://www.threshold.cloud) for more information.

## Getting started

There are lots of ways to run Threshold. See instructions for:

* [Kubernetes](docs/kubernetes/tutorial.md)
* [Docker Compose](docs/docker/docker-compose.md)
* [Docker](docs/docker/docker.md)

If you just want to try out Threshold, see [these instructions](docs/getting-started.md) for running a standalone Docker container. 

---

## About

Visit the [Threshold website](https://www.threshold.cloud) for more information.

### How it works

Threshold is an _opinionated_ distribution of the [apiman](https://apiman.io) project, slimmed down and preconfigured with sensible defaults. It comes as a prepackaged Docker image, as well as configuration files for running on Kubernetes and other container environments.

### Roadmap

Plans for future features can be found in the [Roadmap](docs/roadmap.md).

### Thanks

Threshold uses the fantastic [apiman](https://apiman.io) project.
