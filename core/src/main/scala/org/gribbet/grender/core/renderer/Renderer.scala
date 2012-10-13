package org.gribbet.grender.core.renderer

import xml.NodeSeq
import org.gribbet.grender.core.xml.NodeWrapper.wrapNode


trait Renderer {
  def render(nodes: NodeSeq): NodeSeq = nodes

  lazy val rendered = render(NodeSeq.Empty)
}






















