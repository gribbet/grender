package org.gribbet.grender.example

case class Contact(name: String, address: String, state: String, city: String, zip: String)

object Contacts {
  private val contacts = List(
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
      zip = "54862-9272"))

  def list() = contacts.toSeq
}
