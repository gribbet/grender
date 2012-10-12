package org.gribbet.grender.example

import org.gribbet.grender.core.component._

abstract class Layout(body: Renderer) extends Renderer with Parent with Template {
  val children = Seq(Transform(".body", body))
}
