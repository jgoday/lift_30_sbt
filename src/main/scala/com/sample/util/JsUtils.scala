package com.sample
package util

import net.liftweb.util._
import net.liftweb.common._
import Helpers._
import net.liftweb.http.{S, SHtml}
import net.liftweb.http.js._

object JsUtils {
  implicit class StringAsJsObject(str: String) {
    type EventHandler = (String) => JsCmd

    def onClick(handler: EventHandler) =
      (str + " [onclick]") #> SHtml.onEvent(handler)
  }
}