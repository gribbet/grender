package org.gribbet.grender.example.jersey.service

import collection.mutable
import org.gribbet.grender.example.jersey.domain.Contact

object ContactService {
  val contacts = mutable.Map(
    1 -> Contact(
      id = 1,
      name = "Beth J. King",
      address = "2741 Middle Cape",
      city = "Imalone",
      state = "Illinois",
      zip = "61094-5876"),
    2 -> Contact(
      id = 2,
      name = "Alfred P. Martin",
      address = "1715 Cozy Oak Maze",
      city = "Lucky Valley",
      state = "Louisiana",
      zip = "71586-3329"),
    3 -> Contact(
      id = 3,
      name = "Bobbye L. Hickey",
      address = "3237 Heather By-pass",
      city = "Radium",
      state = "Wisconsin",
      zip = "54862-9272")
  )

  def list = contacts.values.toSeq

  def find(id: Int): Option[Contact] = contacts.get(id)
}
