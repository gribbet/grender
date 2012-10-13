package org.gribbet.grender.core.renderer


trait ClassesModifier extends AttributeModifier {
  val key = "class"

  def modify(classes: Set[String]): Set[String]

  def modify(value: String): String = modify(value.trim.split(" ").toSet).fold("")(_ + " " + _).trim
}


