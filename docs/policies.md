Policies
========

You configure Threshold APIs by applying _policies_. These are rules or behaviours that apply to the requests or responses sent to your APIs.

The supported policies are:

* [Caching](#caching)
* [Rate limiting](#rate-limiting)
* [Authentication](#authentication)
* [IP restrictions](#ip-restrictions)
* [Invoke AWS Lambda function](#invoke-aws-lambda-function)

# Policies

This section describes the supported policies. See the [Configuration](configuration.md) section for details about where to configure policies.

## Caching

This policy caches API responses for a configurable period of time.

```
api("example") {
    version = "1.0"
    backend = "http://example.com"

    policies {
        cache duration 60.seconds
    }
}
```

## Rate limiting

This policy limits the number of requests to an API to a configurable number in a given time period.

```
api("example") {
    version = "2.0"
    backend = "http://example.com"

    policies {
        limit to 10 per minute
    }
}
```

## IP restrictions

This policy restricts the IP addresses allowed to access an API. You can restrict by allowing or blocking IPs.

```
api("example") {
    version = "2.0"
    backend = "http://example.com"

    policies {
        ipRestricted {
            allow ip "127.0.0.1"
            block ip "192.168.99.100"
        }
    }
}
```

## Authentication

This policy applies HTTP Basic Authentication to an API.

```
api("example") {
    version = "2.0"
    backend = "http://example.com"

    policies {
        basicAuth {
            username = "adalovelace"
            password = "counte$$"
        }
        basicAuth {
            username = "gracehopper"
            password = "c0b0l"
        }
    }
}
```

## Invoke AWS Lambda function

This policy invokes an AWS Lambda function, passing the incoming request, and returns the result of the Lambda function call in the response.

```
api("example") {
    version = "1.0"
    backend = ""
    
    policies {
        lambda function "helloLambda"
    }
}
```

### Lambda request format

The format of the request event sent to the Lambda function is as follows:

```
{
  "httpMethod": "GET",
  "headers": {
    "X-My-Request-Header": "foo"
  },
  "body": "Request body"
}
```

### Lambda response format

The required response format to be returned by the Lambda function is as follows:

```
{
  "statusCode": 200,
  "headers": {
    "X-My-Response-Header": "bar"
  },
  "body": "Response body"
}
```

> For a sample Lambda function, see the `components/apiman-lambda-plugin/examples/hello-lambda.js` file.

## More examples

See the [examples](examples) directory for more.
