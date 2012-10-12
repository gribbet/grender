package org.gribbet.grender.core.renderer

import xml.NodeSeq


trait Grouper extends Renderer {
  val renderers: Seq[Renderer]

  abstract override def render(nodes: NodeSeq) =
    super.render(renderers.foldLeft(nodes) {
      (nodes, renderer) => renderer.render(nodes)
    })
}



