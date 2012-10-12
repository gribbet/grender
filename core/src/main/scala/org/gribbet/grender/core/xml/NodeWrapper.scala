package org.gribbet.grender.core.xml

import xml.{TopScope, NodeSeq, Elem, Node}
import NodeWrapper.wrapNode

object NodeWrapper {
  implicit def wrapNode(node: Node) = new NodeWrapper(node)
}

class NodeWrapper(val node: Node) {
  def withChildren(children: NodeSeq) = node match {
    case elem: Elem => elem.copy(child = children)
    case _ => node
  }

  def withoutNamespace: Node = node match {
    case elem: Elem => elem.copy(scope = TopScope, child = elem.child.map(_.withoutNamespace))
    case _ => node
  }

  def withoutChildNamespace: Node = node match {
    case elem: Elem => elem.copy(child = elem.child.map(_.withoutNamespace))
    case _ => node
  }
}
