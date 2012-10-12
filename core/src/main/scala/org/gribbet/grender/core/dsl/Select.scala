package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{SelectorTransformer, Renderer}
import org.fusesource.scalate.scuery.Transform


object Select {
  def apply(_selector: String, _renderer: Renderer) = new Renderer with SelectorTransformer {
    val selector = _selector
    val renderer = _renderer
  }
}
