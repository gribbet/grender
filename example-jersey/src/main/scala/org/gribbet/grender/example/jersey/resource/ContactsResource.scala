package org.gribbet.grender.example.jersey.resource

import javax.ws.rs._
import scala.Array
import core.{Response, MediaType}
import org.gribbet.grender.example.jersey.renderer._
import org.gribbet.grender.example.jersey.service.Contacts

@Path("/contacts")
class ContactsResource {
  @GET
  @Produces(Array(MediaType.APPLICATION_XHTML_XML))
  def contacts = new ListContacts()

  @GET
  @Path("{id}")
  @Produces(Array(MediaType.APPLICATION_XHTML_XML))
  def contact(@PathParam("id") id: Int): Response =
    Contacts.find(id).map(contact =>
      Response.ok(new ViewContact(contact))
    ).getOrElse(
      Response.status(Response.Status.NOT_FOUND)).build()
}
