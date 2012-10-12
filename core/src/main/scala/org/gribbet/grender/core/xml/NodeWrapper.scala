package org.gribbet.grender.core.xml

import xml.{NodeSeq, Elem, Node}

object NodeWrapper {
  implicit def wrapNode(node: Node) = new NodeWrapper(node)
}

class NodeWrapper(val node: Node) {
  def withChildren(children: NodeSeq) = node match {
    case Elem(prefix, label, attributes, scope, _*) => Elem(prefix, label, attributes, scope, children: _*)
    case _ => node
  }
}
