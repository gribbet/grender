package org.gribbet.grender.core.renderer

import xml.NodeSeq
import org.gribbet.grender.core.xml.NodeWrapper.wrapNode


trait Renderer {
  def render(nodes: NodeSeq): NodeSeq = nodes.map(_.withoutChildNamespace) // Silly Scala XML behavior adds namespaces everywhere

  final def render(): NodeSeq = render(NodeSeq.Empty)
}






















