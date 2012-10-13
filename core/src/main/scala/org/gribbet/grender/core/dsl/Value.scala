package org.gribbet.grender.core.dsl

import xml.{Text, NodeSeq}
import org.gribbet.grender.core.renderer.{Renderer, Wrapper, Replacer}


case class Value(nodes: NodeSeq) extends Renderer with Wrapper {
  val renderer = Replace(nodes)
}

object Value {
  def apply(render: String): Renderer = Value(Text(render))

  def apply(render: Any): Renderer = Value(render.toString)
}
