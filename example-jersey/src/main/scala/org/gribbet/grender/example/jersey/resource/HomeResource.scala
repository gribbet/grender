package org.gribbet.grender.example.jersey.resource

import javax.ws.rs.{Produces, Path, GET}
import javax.ws.rs.core.MediaType
import org.gribbet.grender.core.renderer.{Templater, Selector, Renderer}
import org.gribbet.grender.example.jersey.renderer.{Layout, Home}

@Path("/")
class HomeResource {
  @GET
  @Produces(Array(MediaType.APPLICATION_XHTML_XML))
  def home = new Home()
}

