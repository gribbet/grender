package org.gribbet.grender.example.jersey.renderer

import org.gribbet.grender.core.renderer.{Renderers, Templater, Renderer}
import org.gribbet.grender.core.dsl.Group
import org.gribbet.grender.core.dsl.AddClass
import org.gribbet.grender.core.dsl.Select
import org.gribbet.grender.core.dsl.RemoveClass

abstract class Layout extends Renderer with Renderers with Templater {
  val body: Renderer
  val template = "layout"
  lazy val renderers = Seq(
    Select(".body", body),
    Select(".navigation", Group(
      Select(".home", new NavigationTab(classOf[HomeTab])),
      Select(".contacts", new NavigationTab(classOf[ContactsTab]))
    ))
  )

  class NavigationTab(tabClass: Class[_]) extends Renderer with Renderers {
    lazy val renderers = Seq(
      if (tabClass.isAssignableFrom(Layout.this.getClass))
        AddClass("active")
      else
        RemoveClass("active"))
  }

}

trait HomeTab extends Renderer

trait ContactsTab extends Renderer