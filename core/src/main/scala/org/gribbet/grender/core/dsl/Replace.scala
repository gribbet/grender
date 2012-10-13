package org.gribbet.grender.core.dsl

import xml.{Text, NodeSeq}
import org.gribbet.grender.core.renderer.{Replacer, Renderer}


case class Replace(val nodes: NodeSeq) extends Renderer with Replacer

object Replace {
  def apply(replace: String): Renderer = Replace(Text(replace))

  def apply(replace: Any): Renderer = Replace(replace.toString)
}
