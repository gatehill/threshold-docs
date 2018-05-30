Threshold Configuration
=======================

You configure Threshold APIs by applying [Policies](policies.md). These include things like caching, rate limiting, authentication, IP restrictions and much more.

Threshold uses a simple, but powerful, DSL to configure APIs and their policies. See _Example policies_ for sample configurations.

# Overview

The Threshold DSL (Domain Specific Language) is structured as follows:

```
apis {

  // the name of the API
  api("example") {
  
    // the version of the API
    version = "1.0"
    
    // the URL of the backend service to invoke
    backend = "http://example.com"

    policies {
      // add policies here
    }
  }
}
```

The API name and version form part of the URL on which the gateway publishes your API. See [API URLs](#api-urls) for more details.

# Policies

Continue to the [Policies](policies.md) section to see the policies you can apply to your APIs.

# API URLs

When you configure an API in Threshold, it is published at a URL like this:

    http://<gateway server>/apis/<api name>/<api version>/

Anything after the API version will be passed to the backend. For example:

If your API was published at:

    http://localhost:8080/apis/example/1.0

...and you made a request for:

    http://localhost:8080/apis/example/1.0/foo/bar

...then the gateway would make a request to your backend service as follows:

    http://example.com/foo/bar
