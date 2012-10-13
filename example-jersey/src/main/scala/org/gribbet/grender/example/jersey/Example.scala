package org.gribbet.grender.example.jersey

import javax.ws.rs.{Produces, Path, GET}
import org.gribbet.grender.core.dsl.Replace
import javax.ws.rs.core.MediaType
import org.gribbet.grender.core.renderer.{Replacer, Renderer}

@Path("/")
class Example {
  @GET
  @Produces(Array(MediaType.APPLICATION_XHTML_XML))
  def example = new Page()
}

