package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{SelectorTransformer, Renderer}

case class Select(selector: String, renderer: Renderer) extends Renderer with SelectorTransformer
