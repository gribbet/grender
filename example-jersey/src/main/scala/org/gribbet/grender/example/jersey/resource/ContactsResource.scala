package org.gribbet.grender.example.jersey.resource

import javax.ws.rs._
import scala.Array
import javax.ws.rs.core.MediaType
import org.gribbet.grender.example.jersey.renderer.{ContactBody, ContactsBody, Layout}
import org.gribbet.grender.example.jersey.service.ContactService

@Path("/contacts")
class ContactsResource {
  @GET
  @Produces(Array(MediaType.APPLICATION_XHTML_XML))
  def contacts = new Layout(new ContactsBody())

  @GET
  @Path("/{id}")
  @Produces(Array(MediaType.APPLICATION_XHTML_XML))
  def contact(@PathParam("id") id: Int) = new Layout(new ContactBody(id))

  @DELETE
  def delete(@FormParam("id") id: Int): Unit = ContactService.find(id).map(ContactService.delete(_))
}
