package org.gribbet.grender.example.jersey.renderer

import org.gribbet.grender.core.renderer.{Renderer, Selector, Templater}

trait Body extends Renderer with Selector with Templater {
  val selector = ".body"
}
