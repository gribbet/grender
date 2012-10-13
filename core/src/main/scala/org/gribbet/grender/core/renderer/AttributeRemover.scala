package org.gribbet.grender.core.renderer

import xml.NodeSeq
import org.gribbet.grender.core.xml.NodeWrapper.wrapNode


trait AttributeRemover extends AttributeModifier {
  def modify(value: String) = ""
}


