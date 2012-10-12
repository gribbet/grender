package org.gribbet.grender.core.renderer

import org.gribbet.grender.core.xml.NodeWrapper.wrapNode
import xml.NodeSeq

trait Wrapper extends Renderer {
  val renderer: Renderer

  abstract override def render(nodes: NodeSeq) =
    super.render(nodes.flatMap(node => node.withChildren(renderer.render(node.child))))
}


