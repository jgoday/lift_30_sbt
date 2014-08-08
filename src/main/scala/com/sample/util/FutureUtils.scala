package com.sample
package util

import scala.xml.{NodeSeq, Text}

import net.liftweb.actor._
import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.util._
import net.liftweb.http.js._
import net.liftweb.util.Helpers._

// Based on https://fmpwizard.telegr.am/blog/async-snippets-in-lift

class FutureToJsCmd(id: String, la: LAFuture[NodeSeq], waitMessage: Option[NodeSeq]) extends JsCmd {
  import util.JsUtils._

  val timeout : Int = 2000

  def getFuture: JsCmd =
    if (la.isSatisfied) replace(id, la.get)
    else waitMessage.map( m => setHtml(id, m) ).getOrElse(JsCmds.Noop) & update

  private def update = {
    val funcName: String = S.request.flatMap(_._params.toList.headOption.map(_._1)).openOr("")
    val retry = s"""setTimeout(
      function() {
        liftAjax.lift_ajaxHandler('$funcName=true', null, null, null)
      }, 3000)"""
    JE.JsRaw(retry).cmd
  }

  override def toJsCmd = getFuture.toJsCmd
}

object FutureUtils {
  val waitMessage = Some(
    BootstrapUtils.textMutted("Waiting for the future to finish"))

  implicit def canBindFuture: CanBind[LAFuture[NodeSeq]] =
    new CanBind[LAFuture[NodeSeq]] {
      import util.JsUtils._

      def apply(future: => LAFuture[NodeSeq])(ns: NodeSeq): Seq[NodeSeq] = {
        
        val id = nextFuncName

        <span/> % ("id" -> id) ++ onLoad {
          SHtml.ajaxInvoke( () =>
            new FutureToJsCmd(
              id,
              future,
              waitMessage) ).exp.cmd
        }
      }
    }
}