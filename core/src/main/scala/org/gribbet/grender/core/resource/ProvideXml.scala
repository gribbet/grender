package org.gribbet.grender.core.resource

import xml.{Node, NodeSeq, Utility, XML}
import org.gribbet.grender.core.component.Renderer

object ProvideXml extends ResourceProvider {
  def apply(component: Renderer): Option[Node] =
    resources(component, "xml").headOption.map(url => Utility.trim(XML.load(url)))
}