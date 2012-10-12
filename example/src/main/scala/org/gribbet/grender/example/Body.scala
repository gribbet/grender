package org.gribbet.grender.example

import org.gribbet.grender.core.renderer.Selector
import org.gribbet.grender.core.renderer.{Selector, Templater, Renderer}

class Body extends Renderer with Selector with Templater {
  val selector = ".body"
}
