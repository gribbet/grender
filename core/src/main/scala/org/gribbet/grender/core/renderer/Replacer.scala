package org.gribbet.grender.core.renderer

import xml.NodeSeq

trait Replacer extends Renderer {
  val nodes: NodeSeq

  abstract override def render(ignore: NodeSeq) = nodes
}


