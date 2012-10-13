package org.gribbet.grender.core.renderer

import xml.NodeSeq


abstract class Renderer {
  def render(nodes: NodeSeq): NodeSeq = nodes

  lazy val rendered = render(NodeSeq.Empty)
}






















