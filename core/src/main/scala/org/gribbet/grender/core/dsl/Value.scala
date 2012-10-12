package org.gribbet.grender.core.dsl

import xml.{Text, NodeSeq}
import org.gribbet.grender.core.renderer.{Renderer, Wrapper, Replacer}


object Value {
  def apply(nodes: NodeSeq) = new Renderer with Wrapper {
    val renderer = Replace(nodes)
  }

  def apply(render: String): Renderer = Value(Text(render))

  def apply(render: Any): Renderer = Value(render.toString)
}
