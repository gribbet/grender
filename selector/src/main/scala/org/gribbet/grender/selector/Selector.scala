package org.gribbet.grender.selector

import xml.NodeSeq

case class Selector(selector: String) {
  def apply(nodes: NodeSeq): NodeSeq =
    org.fusesource.scalate.scuery.Selector(selector).filter(nodes)
}
