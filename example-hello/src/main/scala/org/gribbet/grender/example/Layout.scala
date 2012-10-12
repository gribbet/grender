package org.gribbet.grender.example

import org.gribbet.grender.core.renderer._
import org.gribbet.grender.core.dsl.Select

abstract class Layout(body: Renderer) extends Renderer with Grouper with Templater {
  val renderers = Seq(Select(".body", body))
}
