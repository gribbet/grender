package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{Wrapper, Renderer}


object Contain {
  def apply(renderers: Renderer*) = new Renderer with Wrapper {
    val renderer = Group(renderers: _*)
  }
}
