package org.gribbet.grender.example.jersey.renderer

import org.gribbet.grender.core.renderer.{Renderers, Renderer}
import org.gribbet.grender.example.jersey.domain.Contact
import org.gribbet.grender.core.dsl.{Select, Value}


class ContactBody(val contact: Contact) extends Renderer with Renderers with Body {
  val template = "contact"
  val renderers = Seq(
    Select(".name", Value(contact.name)),
    Select(".address", Value(contact.address)),
    Select(".city", Value(contact.city)),
    Select(".state", Value(contact.state)),
    Select(".zip", Value(contact.zip))
  )
}