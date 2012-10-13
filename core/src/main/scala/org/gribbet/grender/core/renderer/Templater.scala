package org.gribbet.grender.core.renderer

import xml.NodeSeq
import org.gribbet.grender.core.resource.ProvideXml


trait Templater extends Renderer {
  val template: String

  abstract override def render(nodes: NodeSeq) =
    super.render(ProvideXml(template).getOrElse(nodes))
}
