package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.Renderer
import org.gribbet.grender.core.xml.NodeWrapper._
import xml.NodeSeq

case class SetAttribute(key: String, value: String) extends Renderer {
  override def render(nodes: NodeSeq) = super.render(nodes.map(_.withAttribute(key, value)))
}