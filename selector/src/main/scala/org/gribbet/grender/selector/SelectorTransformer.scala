package org.gribbet.grender.selector

import xml.{Elem, Node, NodeSeq}

case class SelectorTransformer(selector: String, transformer: NodeSeq => NodeSeq) {
  def apply(node: NodeSeq): NodeSeq =
    (new org.fusesource.scalate.scuery.Transformer() {
      $(selector)(transformer)
    })(node).head
}