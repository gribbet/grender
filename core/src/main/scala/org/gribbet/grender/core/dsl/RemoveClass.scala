package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{ClassRemover, Renderer}

case class RemoveClass(className: String) extends Renderer with ClassRemover