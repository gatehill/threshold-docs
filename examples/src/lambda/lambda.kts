import kamara.dsl.*

apis {
  api("example") {
    version = "1.0"
    backend = ""

    policies {
      lambda function "helloLambda"
    }
  }
}
