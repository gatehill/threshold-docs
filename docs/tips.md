Tips and tricks
===============

A set of tips and tricks to help you get the most out of your Threshold installation.

## Verbose configuration parsing

You can enable verbose parsing for API configuration with:

    CLI_DEBUG="enabled"

Example:

    docker run -e CLI_DEBUG="enabled" -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway

## Development SSL mode

You can enable development SSL mode (which is unsafe for production-like workloads!) using:

    DEV_SSL="enabled"

Example:

    docker run -e DEV_SSL="enabled" -it -p 8080:8080 -v $PWD/examples/src/simple:/opt/kamara/apis threshold/gateway

## Debugging

You can attach a JVM debugger to Threshold.

To run the gateway in debug mode:

    docker run -e JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,address=9999,server=y,suspend=y" -it -p 9999:9999 -p 8080:8080 -v $PWD/examples/src:/opt/kamara/apis threshold/gateway

Connect the debugger on port 9999.
