package org.gribbet.grender.core.renderer

import xml.NodeSeq
import org.gribbet.grender.css

trait Selector extends Renderer {
  val selector: String

  abstract override def render(nodes: NodeSeq) =
    super.render(css.Selector(selector)(nodes))
}
