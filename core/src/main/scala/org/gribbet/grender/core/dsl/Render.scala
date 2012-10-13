package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.Renderer
import xml.NodeSeq

case class Render(renderer: NodeSeq => NodeSeq) extends Renderer {
  override def render(nodes: NodeSeq) = renderer(nodes)
}