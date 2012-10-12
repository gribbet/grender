package org.gribbet.grender.example

import org.gribbet.grender.core.component._

case class Contact(name: String, address: String, state: String, city: String, zip: String)

class AddressBook extends Renderer with Parent with Template {
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
  val children = Seq(
    Select(".address-book tbody tr",
      Repeat(contacts.map(contact =>
        Parent(
          Select(".name", Contain(Value(contact.name))),
          Select(".address", Contain(Value(contact.address))),
          Select(".city", Contain(Value(contact.city))),
          Select(".state", Contain(Value(contact.state))),
          Select(".zip", Contain(Value(contact.zip)))
        )): _*)))
}