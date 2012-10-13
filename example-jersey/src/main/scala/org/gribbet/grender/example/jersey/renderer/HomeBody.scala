package org.gribbet.grender.example.jersey.renderer

import org.gribbet.grender.core.renderer.{Templater, Renderer, Selector}


class HomeBody extends Renderer with Selector with Templater {
  val template = "home"
  val selector = ".body"
}
