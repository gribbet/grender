package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{Renderer, Repeater}

object Repeat {
  def apply(_renderers: Renderer*) = new Renderer with Repeater {
    val renderers = _renderers
  }
  def apply(renderers: Seq[Renderer]): Renderer = Repeat(renderers: _*)
}
