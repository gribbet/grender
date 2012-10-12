package org.gribbet.grender.example

import org.gribbet.grender.core.component._
import xml.{NodeSeq, Node, Text}


class HelloWorld extends Renderer with Parent with Template {
  val children = Seq(
    Select(".message",
      Contain(Value("Hello World!"))))
}