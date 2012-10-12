package org.gribbet.grender.core.renderer

import xml.NodeSeq
import org.gribbet.grender.core.resource.ProvideXml


trait Templater extends Renderer {
  abstract override def render(nodes: NodeSeq) =
    super.render(ProvideXml(this).getOrElse(nodes))
}
