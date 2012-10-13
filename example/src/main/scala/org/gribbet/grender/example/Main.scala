package org.gribbet.grender.example

import org.gribbet.grender.core.renderer._
import org.gribbet.grender.core.dsl.{Group, Repeat, Value, Select}
import xml.PrettyPrinter

object Main extends App {
  val prettyPrinter = new PrettyPrinter(100, 4)

  helloWorldExample
  addressBookExample
  layoutExample

  def helloWorldExample() {
    Console.println("Hello World example: ")
    Console.println(prettyPrinter.formatNodes(new Renderer with Renderers with Templater {
      val template = "hello-world"
      val renderers = Seq(Select(".message", Value("Hello World!")))
    }.rendered))
  }

  def addressBookExample() {
    Console.println("Address Book example: ")
    Console.println(prettyPrinter.formatNodes(new Renderer with Renderers with Templater {
      val template = "address-book"
      val renderers = Seq(
        Select(".address-book tbody tr",
          Repeat(Contacts.list.map(contact =>
            Group(
              Select(".name", Value(contact.name)),
              Select(".address", Value(contact.address)),
              Select(".city", Value(contact.city)),
              Select(".state", Value(contact.state)),
              Select(".zip", Value(contact.zip))
            )): _*)))
    }.rendered))
  }

  def layoutExample {
    Console.println("Layout example: ")

    abstract class Layout extends Renderer with Renderers with Templater {
      val body: Renderer
      val template = "layout"
      lazy val renderers = Seq(Select(".body", body))
    }

    Console.println(prettyPrinter.formatNodes(new Layout {
      val body = new Renderer with Selector with Templater {
        val template = "body"
        val selector = ".body"
      }
    }.rendered))
  }
}

