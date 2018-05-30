import kamara.dsl.*

apis {
  api("example") {
    version = "1.0"
    backend = "http://example.com"

    policies {
      script file "/opt/kamara/apis/response.js"
    }
  }
}
