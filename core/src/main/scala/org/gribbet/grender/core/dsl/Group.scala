package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{Renderer, Grouper}

object Group {
  def apply(_renderers: Renderer*) = new Renderer with Grouper {
    val renderers = _renderers
  }
}
