package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{Templater, Renderer}

case class Template(template: String) extends Renderer with Templater