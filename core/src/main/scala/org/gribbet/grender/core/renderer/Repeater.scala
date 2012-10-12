package org.gribbet.grender.core.renderer

import xml.NodeSeq


trait Repeater extends Renderer {
  val renderers: Seq[Renderer]

  abstract override def render(nodes: NodeSeq) =
    super.render(renderers.flatMap(_.render(nodes)))
}


