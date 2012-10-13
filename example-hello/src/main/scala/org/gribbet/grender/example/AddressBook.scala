package org.gribbet.grender.example

import org.gribbet.grender.core.renderer._
import org.gribbet.grender.core.dsl.{Repeat, Value, Select, Group}
import org.gribbet.grender.core.renderer.Renderers
import org.gribbet.grender.core.renderer.SelectorTransformer


class AddressBook extends Renderer with Renderers with Templater {
  val template = "address-book"

  case class Contact(name: String, address: String, state: String, city: String, zip: String)

  val contacts = List(
    Contact(
      name = "Beth J. King",
      address = "2741 Middle Cape",
      city = "Imalone",
      state = "Illinois",
      zip = "61094-5876"),
    Contact(
      name = "Alfred P. Martin",
      address = "1715 Cozy Oak Maze",
      city = "Lucky Valley",
      state = "Louisiana",
      zip = "71586-3329"),
    Contact(
      name = "Bobbye L. Hickey",
      address = "3237 Heather By-pass",
      city = "Radium",
      state = "Wisconsin",
      zip = "54862-9272")
  )

  val renderers = Seq(
    Select(".address-book tbody tr",
      Repeat(contacts.map(contact =>
        Group(
          Select(".name", Value(contact.name)),
          Select(".address", Value(contact.address)),
          Select(".city", Value(contact.city)),
          Select(".state", Value(contact.state)),
          Select(".zip", Value(contact.zip))
        )): _*)))
}