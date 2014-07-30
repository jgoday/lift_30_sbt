package com.sample
package snippet

import java.util.Date
import scala.xml.{NodeSeq, Text}

import net.liftweb.util._
import net.liftweb.common._
import Helpers._
import net.liftweb.http.{S, SHtml, Templates}
import net.liftweb.http.js._

import util.{TemplateUtils, JsUtils}

class SampleJs {

  private def jsFunction =
    (_: String) =>
      JsCmds.SetHtml("time", Text((new java.util.Date).toString))

  private def renderTemplate(templateName: String) =
    (_: String) =>
      JsCmds.Replace("to-replace",
        TemplateUtils.template(templateName))

  def updateTime = "#btn [onClick]" #> SHtml.onEvent(jsFunction)

  def loadTemplate = {
    import JsUtils._

    val templateName = S.attr("template").openOr("not-found")
    // "#btn2 [onClick]" #> SHtml.onEvent(renderTemplate(templateName))
    "#btn2".onClick(renderTemplate((templateName)))
  }
}