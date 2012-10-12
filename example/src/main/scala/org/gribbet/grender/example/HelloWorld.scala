package org.gribbet.grender.example

import org.gribbet.grender.core.renderer._
import xml.{NodeSeq, Node, Text}
import org.gribbet.grender.core.dsl.{Value, Select}


class HelloWorld extends Renderer with Grouper with Templater {
  val renderers = Seq(Select(".message", Value("Hello World!")))
}