package com.sample
package util

import scala.xml.NodeSeq

import net.liftweb.http.Templates

object TemplateUtils {
  def template(name: String, default: NodeSeq = NodeSeq.Empty): NodeSeq = {
    println { name }
    Templates(name.split("/").toList).openOr(default)
  }
}