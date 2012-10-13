package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{Renderer, Repeater}

case class Repeat(renderers: Renderer*) extends Renderer with Repeater
