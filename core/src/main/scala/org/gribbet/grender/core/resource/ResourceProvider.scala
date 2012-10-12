package org.gribbet.grender.core.resource

import java.net.URL
import org.gribbet.grender.core.component.Renderer

trait ResourceProvider {
  protected def resources(component: Renderer, extension: String): Seq[URL] =
    resources(component.getClass.asInstanceOf[Class[Renderer]], extension)
  private def resources(theClass: Class[_], extension: String): Seq[URL] =
    Seq(classResource(theClass, extension)).flatten ++
      Option(theClass.getSuperclass).map(resources(_, extension)).getOrElse(Seq())
  private def classResource(theClass: Class[_], extension: String): Option[URL] =
    Option(getClass.getResource("/" + theClass.getName.replace(".", "/") + "." + extension))
}