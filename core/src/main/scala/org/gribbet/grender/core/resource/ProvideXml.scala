package org.gribbet.grender.core.resource

import xml.{Node, Utility, XML}

object ProvideXml {
  def apply(template: String): Option[Node] =
    Option(getClass.getClassLoader.getResource(template + ".xml")).map(url => Utility.trim(XML.load(url)))
}