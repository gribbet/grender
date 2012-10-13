package org.gribbet.grender.example.jersey

import org.gribbet.grender.core.renderer.{Grouper, Templater, Renderer}
import org.gribbet.grender.core.dsl.{Value, Select}

class Page extends Renderer with Grouper with Templater {
  val renderers = Seq(Select(".message", Value("Hello World!")))
}