package org.gribbet.grender.example.jersey.renderer

import org.gribbet.grender.core.renderer.{Templater, Renderers, Renderer, Selector}
import org.gribbet.grender.core.dsl._
import org.gribbet.grender.example.jersey.service.ContactService

class ContactsBody extends Renderer with Renderers with Body {
  val template = "contacts"
  val renderers = Seq(
    Select(".contacts tbody tr",
      Repeat(ContactService.list.map(contact =>
        Group(
          Select(".name", Value(contact.name)),
          Select(".address", Value(contact.address)),
          Select(".city", Value(contact.city)),
          Select(".state", Value(contact.state)),
          Select(".zip", Value(contact.zip)),
          Select(".action .view", SetAttribute("href", "/contacts/" + contact.id))
        )): _*)))

}