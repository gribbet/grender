package org.gribbet.grender.core.renderer

import org.gribbet.grender.css
import xml.NodeSeq

trait SelectorTransformer extends Renderer {
  val selector: String
  val renderer: Renderer

  abstract override def render(nodes: NodeSeq) =
    super.render(css.SelectorTransformer(selector, renderer.render)(nodes))
}
