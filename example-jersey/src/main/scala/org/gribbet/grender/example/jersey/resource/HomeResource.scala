package org.gribbet.grender.example.jersey.resource

import javax.ws.rs.{Produces, Path, GET}
import org.gribbet.grender.core.dsl.Replace
import javax.ws.rs.core.MediaType
import org.gribbet.grender.core.renderer.{Replacer, Renderer}
import org.gribbet.grender.example.jersey.renderer.{Layout, HomeBody}

@Path("/")
class HomeResource {
  @GET
  @Produces(Array(MediaType.APPLICATION_XHTML_XML))
  def home = new Layout(new HomeBody())
}

