package org.gribbet.grender.example.jersey.renderer

import org.gribbet.grender.core.renderer.{Renderers, Templater, Renderer}
import org.gribbet.grender.core.dsl.{RemoveClass, AddClass, Select, Group}

class Layout(body: Renderer) extends Renderer with Renderers with Templater {
  val template = "layout"
  val renderers = Seq(
    Select(".body", body),
    Select(".navigation", Group(
      Select(".home", new NavigationClass(classOf[HomeBody])),
      Select(".contacts", new NavigationClass(classOf[ContactsBody]))
    ))
  )

  class NavigationClass(activeBody: Class[_ <: Renderer]) extends Renderer with Renderers {
    val renderers: Seq[Renderer] = Seq(
      if (body.getClass().equals(activeBody)) AddClass("active") else RemoveClass("active"))
  }

}