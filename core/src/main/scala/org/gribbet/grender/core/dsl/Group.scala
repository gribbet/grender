package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{Renderer, Renderers}

case class Group(renderers: Renderer*) extends Renderer with Renderers
