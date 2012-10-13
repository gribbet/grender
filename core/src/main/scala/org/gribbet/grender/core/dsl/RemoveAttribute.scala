package org.gribbet.grender.core.dsl

import org.gribbet.grender.core.renderer.{AttributeRemover, Renderer}

case class RemoveAttribute(key: String) extends Renderer with AttributeRemover