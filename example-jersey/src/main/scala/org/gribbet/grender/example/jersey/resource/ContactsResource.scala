package org.gribbet.grender.example.jersey.resource

import javax.ws.rs._
import scala.Array
import core.{Response, MediaType}
import org.gribbet.grender.example.jersey.renderer.{ContactBody, ContactsBody, Layout}
import org.gribbet.grender.example.jersey.service.ContactService
import org.gribbet.grender.core.resource.ProvideXml

@Path("/contacts")
class ContactsResource {
  @GET
  @Produces(Array(MediaType.APPLICATION_XHTML_XML))
  def contacts = new Layout(new ContactsBody())

  @GET
  @Path("{id}")
  @Produces(Array(MediaType.APPLICATION_XHTML_XML))
  def contact(@PathParam("id") id: Int): Response =
    ContactService.find(id).map(contact =>
      Response.ok(new Layout(new ContactBody(contact)))
    ).getOrElse(
      Response.status(Response.Status.NOT_FOUND)).build()
}
