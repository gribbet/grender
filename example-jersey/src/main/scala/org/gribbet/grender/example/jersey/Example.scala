package org.gribbet.grender.example.jersey

import javax.ws.rs.{Path, GET}

@Path("/")
class Example {
  
  @GET
  def example = {
    "test"
  }
}