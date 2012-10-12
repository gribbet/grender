package org.gribbet.grender.example

import org.gribbet.grender.core.component.{Select, Template, Renderer}

class Body extends Renderer with Select with Template  {
  val selector = ".body"
}
