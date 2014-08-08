package com.sample
package util

import scala.xml.{Node, NodeSeq}

import net.liftweb.util._
import net.liftweb.common._
import Helpers._
import net.liftweb.http.{S, SHtml}
import net.liftweb.http.js._

object JsUtils {
  implicit class StringAsJsObject(str: String) {
    type EventHandler = () => JsCmd

    def onClick(handler: EventHandler) =
      (str + " [onclick]") #> SHtml.ajaxInvoke(handler)
  }

  def replace(id: String, content: NodeSeq): JsCmd =
    JsCmds.Replace(id, content)

  def setHtml(id: String, content: NodeSeq): JsCmd =
    JsCmds.SetHtml(id, content)

  def append(id: String, content: NodeSeq): JsCmd =
    jquery.JqJsCmds.AppendHtml(id, content)

  def onLoad(cmd: JsCmd): Node =
    JsCmds.Script(JsCmds.OnLoad(cmd))
}