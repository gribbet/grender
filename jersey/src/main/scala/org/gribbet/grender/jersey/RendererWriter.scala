package org.gribbet.grender.jersey

import javax.ws.rs.ext.{MessageBodyWriter, Provider}
import java.lang.reflect.Type
import java.lang.annotation.Annotation
import javax.ws.rs.core.{MultivaluedMap, MediaType}
import java.io.OutputStream
import org.gribbet.grender.core.renderer.Renderer
import com.sun.jersey.core.util.ReaderWriter
import xml.Utility


@Provider
class RendererWriter extends MessageBodyWriter[Renderer] {
  final val default =
    <html xmlns="http://www.w3.org/1999/xhtml">
      <body>No content</body>
    </html>

  def isWriteable(`type`: Class[_],
                  genericType: Type,
                  annotations: Array[Annotation],
                  mediaType: MediaType) =
    classOf[Renderer].isAssignableFrom(`type`) && mediaType.equals(MediaType.APPLICATION_XHTML_XML_TYPE)

  def getSize(renderer: Renderer,
              `type`: Class[_],
              genericType: Type,
              annotations: Array[Annotation],
              mediaType: MediaType) = -1

  def writeTo(renderer: Renderer,
              `type`: Class[_], genericType: Type,
              annotations: Array[Annotation],
              mediaType: MediaType,
              httpHeaders: MultivaluedMap[String, AnyRef],
              entityStream: OutputStream) = {
    val header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
    val docType = "<!DOCTYPE html>"
    ReaderWriter.writeToAsString(
      header + docType + Utility.toXML(
        if (renderer.rendered.size > 0) renderer.rendered.head else default,
        preserveWhitespace = false,
        minimizeTags = true,
        stripComments = true),
      entityStream, mediaType)
  }
}
