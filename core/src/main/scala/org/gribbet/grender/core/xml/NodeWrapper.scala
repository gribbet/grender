package org.gribbet.grender.core.xml

import xml._
import NodeWrapper.wrapNode

object NodeWrapper {
  implicit def wrapNode(node: Node) = new NodeWrapper(node)
}

class NodeWrapper(val node: Node) {
  def withChildren(children: NodeSeq) = node match {
    case elem: Elem => elem.copy(child = children)
    case _ => node
  }

  private def ifElem(map: Elem => Elem) = node match {
    case elem: Elem => map(elem)
    case _ => node
  }

  def withoutNamespace: Node =
    ifElem((elem: Elem) => elem.copy(scope = TopScope, child = elem.child.map(_.withoutNamespace)))

  def withoutChildNamespace: Node =
    ifElem((elem: Elem) => elem.copy(child = elem.child.map(_.withoutNamespace)))

  def withAttribute(key: String, value: String): Node =
    ifElem((elem: Elem) => elem % new UnprefixedAttribute(key, Text(value), Null))

  def withoutAttribute(key: String): Node =
    ifElem((elem: Elem) => elem.copy(attributes = node.attributes.filter(_.key != key)))

  def attribute2(key: String): Option[String] =
    node.attribute(key).map(_.toString)
}
