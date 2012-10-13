package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{ClassAdder, Renderer}

case class AddClass(className: String) extends Renderer with ClassAdder