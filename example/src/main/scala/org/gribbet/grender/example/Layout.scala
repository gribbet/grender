package org.gribbet.grender.example

import org.gribbet.grender.core.renderer._
import org.gribbet.grender.core.dsl.Select

abstract class Layout extends Renderer with Renderers with Templater {
  val body: Renderer
  val template = "layout"
  val renderers = Seq(Select(".body", body))
}
