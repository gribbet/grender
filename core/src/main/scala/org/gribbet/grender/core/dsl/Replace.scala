package org.gribbet.grender.core.dsl

import xml.{Text, NodeSeq}
import org.gribbet.grender.core.renderer.{Replacer, Renderer}


object Replace {
  def apply(_nodes: NodeSeq) = new Renderer with Replacer {
    val nodes = _nodes
  }

  def apply(render: String): Renderer = Replace(Text(render))

  def apply(render: Any): Renderer = Replace(render.toString)
}
