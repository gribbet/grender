package org.gribbet.grender.example.jersey.renderer

import org.gribbet.grender.core.renderer.{Templater, Selector, Renderer}

class Home extends Layout with HomeTab {
  val body = new Renderer with Selector with Templater {
    val template = "home"
    val selector = ".body"
  }
}