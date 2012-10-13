package org.gribbet.grender.example.jersey.renderer

import org.gribbet.grender.core.renderer.{Grouper, Templater, Renderer}
import org.gribbet.grender.core.dsl.{Value, Select}

class Layout(body: Renderer) extends Renderer with Grouper with Templater {
  val renderers = Seq(Select(".body", body))
}