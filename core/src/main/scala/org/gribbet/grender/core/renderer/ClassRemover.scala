package org.gribbet.grender.core.renderer

trait ClassRemover extends ClassesModifier {
  val className: String

  def modify(classes: Set[String]): Set[String] = classes - className
}


