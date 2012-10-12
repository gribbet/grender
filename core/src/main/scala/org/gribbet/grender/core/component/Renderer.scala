package org.gribbet.grender.core.component

import xml.{NodeSeq, Text, Elem, Node}
import org.gribbet.grender.selector.{Selector, SelectorTransformer}
import org.gribbet.grender.core.resource.ProvideXml
import org.gribbet.grender.core.xml.NodeWrapper.wrapNode


trait Renderer {
  def render(nodes: NodeSeq): NodeSeq = nodes.map(_.withoutChildNamespace) // Silly Scala XML behavior adds namespaces everywhere

  final def render(): NodeSeq = render(NodeSeq.Empty)
}

trait Parent extends Renderer {
  val children: Seq[Renderer]

  abstract override def render(nodes: NodeSeq) =
    super.render(children.foldLeft(nodes) {
      (nodes, child) => child.render(nodes)
    })
}

object Parent {
  def apply(_children: Renderer*) = new Renderer with Parent {
    val children = _children
  }
}

trait Select extends Renderer {
  val selector: String

  abstract override def render(nodes: NodeSeq) =
    super.render(Selector(selector)(nodes))
}

object Select {
  def apply(_selector: String) = new Renderer with Select {
    val selector = _selector
  }
}

trait Transform extends Renderer {
  val selector: String
  val renderer: Renderer

  abstract override def render(nodes: NodeSeq) =
    super.render(SelectorTransformer(selector, renderer.render)(nodes))
}

object Transform {
  def apply(_selector: String, _renderer: Renderer) = new Renderer with Transform {
    val selector = _selector
    val renderer = _renderer
  }
}

trait Template extends Renderer {
  abstract override def render(nodes: NodeSeq) =
    super.render(ProvideXml(this).getOrElse(nodes))
}

trait Render extends Renderer {
  val nodes: NodeSeq

  abstract override def render(ignore: NodeSeq) = nodes
}

object Render {
  def apply(_nodes: NodeSeq) = new Renderer with Render {
    val nodes = _nodes
  }

  def apply(render: String): Render = Render(Text(render))

  def apply(render: Any): Render = Render(render.toString)
}

trait Contain extends Renderer {
  val renderer: Renderer

  abstract override def render(nodes: NodeSeq) =
    super.render(nodes.flatMap(node => node.withChildren(renderer.render(node.child))))
}

object Contain {
  def apply(children: Renderer*) = new Renderer with Contain {
    val renderer = Parent(children: _*)
  }
}

object Value {
  def apply(nodes: NodeSeq) = new Renderer with Contain {
    val renderer = Render(nodes)
  }

  def apply(render: String): Contain = Value(Text(render))

  def apply(render: Any): Contain = Value(render.toString)
}

trait Repeat extends Renderer {
  val renderers: Seq[Renderer]

  abstract override def render(nodes: NodeSeq) =
    super.render(renderers.flatMap(_.render(nodes)))
}

object Repeat {
  def apply(_renderers: Renderer*) = new Renderer with Repeat {
    val renderers = _renderers
  }
}
