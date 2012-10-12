package org.gribbet.grender.core.component

import xml.{NodeSeq, Text, Elem, Node}
import org.gribbet.grender.grender.selector.SelectorTransformer
import org.gribbet.grender.core.resource.ProvideXml
import org.gribbet.grender.core.xml.NodeWrapper.wrapNode


trait Renderer {
  def render(nodes: NodeSeq): NodeSeq = nodes

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

// TODO: Other type of selector?
trait Select extends Renderer {
  val selector: String

  abstract override def render(nodes: NodeSeq) =
    SelectorTransformer(selector, super.render)(nodes)
}

object Select {
  def apply(_selector: String, child: Renderer) = new Renderer with Parent with Select {
    val selector = _selector
    val children = Seq(child)
  }
}

trait Template extends Renderer {
  abstract override def render(nodes: NodeSeq) =
    super.render(ProvideXml(this).getOrElse(nodes))
}

trait Value extends Renderer {
  val value: NodeSeq

  abstract override def render(nodes: NodeSeq) = value
}

object Value {
  def apply(_value: NodeSeq) = new Renderer with Value {
    val value = _value
  }

  def apply(value: String): Value = Value(Text(value))
}

trait Contain extends Renderer {
  abstract override def render(nodes: NodeSeq) =
    nodes.flatMap(node => node.withChildren(super.render(node.child)))
}

object Contain {
  def apply(_children: Renderer*) = new Renderer with Parent with Contain {
    val children = _children
  }
}
