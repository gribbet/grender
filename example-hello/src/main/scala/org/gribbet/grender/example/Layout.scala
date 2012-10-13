package org.gribbet.grender.example

import org.gribbet.grender.core.renderer._
import org.gribbet.grender.core.dsl.Select

abstract class Layout(body: Renderer) extends Renderer with Renderers with Templater {
  val template = "layout"
  val renderers = Seq(Select(".body", body))
}
