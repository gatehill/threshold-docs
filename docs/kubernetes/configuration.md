## Annotations

You can these annotations to your Service:

| Annotation                        | Meaning                                      | Type               | Example                   |
|-----------------------------------|----------------------------------------------|--------------------|---------------------------|
| threshold.gatehill.io/name           | API name (default: service name)             | string (optional)  | example                   |
| threshold.gatehill.io/version        | API version                                  | string (required)  | "1.0"                     |
| threshold.gatehill.io/policies       | Policies to apply                            | string (required)  | cache duration 60.seconds | 
| threshold.gatehill.io/service-port   | Service port to expose (default: first port) | string (optional)  | "80"                        | 
| threshold.gatehill.io/backend-prefix | Prefix to prepend to backend path            | string (optional)  | /my/api                   | 

> Note: the policies annotation can be a multiline string, e.g.

```
threshold.gatehill.io/policies: |
  cache duration 60.seconds
  limit to 10 per minute
```
