import kamara.dsl.*

apis {
  api("example") {
    version = "1.0"
    backend = "http://example.com"

    policies {
      cache duration 60.seconds
    }
  }
}
