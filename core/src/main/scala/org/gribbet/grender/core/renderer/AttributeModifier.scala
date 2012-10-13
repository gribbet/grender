package org.gribbet.grender.core.renderer

import xml.NodeSeq
import org.gribbet.grender.core.xml.NodeWrapper.wrapNode


trait AttributeModifier extends Renderer {
  val key: String

  def modify(value: String): String

  abstract override def render(nodes: NodeSeq) =
    super.render(nodes.map(node => {
      modify(node.attribute2(key).getOrElse("")) match {
        case "" => node.withoutAttribute(key)
        case x => node.withAttribute(key, x)
      }
    }))
}


