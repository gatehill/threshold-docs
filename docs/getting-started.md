Getting started
===============

There are many ways to run Threshold. See instructions for:

* [Kubernetes](install/kubernetes.md)
* [Docker Compose](install/docker-compose.md)
* [Docker](install/docker.md)

The following instructions are for running a standalone Docker container. 

    docker run -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway

# Tips

Enable verbose parsing for API configuration:

    docker run -e CLI_DEBUG="enabled" -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway

Enable development SSL mode (unsafe!):

    docker run -e DEV_SSL="enabled" -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway

# Viewing metrics

You can view the Prometheus metrics on port 9136.

To access them, publish port 9136 in your `docker run` command.

# Debugging

To run the gateway in debug mode:

    docker run -e JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,address=9999,server=y,suspend=y" -it -p 9999:9999 -p 8080:8080 -v $PWD/examples/src:/opt/kamara/apis threshold/gateway

Connect the debugger on port 9999.
