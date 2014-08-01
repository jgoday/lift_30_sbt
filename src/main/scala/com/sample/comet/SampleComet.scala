package com.sample
package comet

import scala.xml.{NodeSeq, Text}

import net.liftweb.common._
import net.liftweb.util._
import net.liftweb.http._

import util.{JsUtils, BootstrapUtils}

case class UpdateClient(id: String, content: NodeSeq)
case class Progress(progress: Int)

class SampleComet extends CometActor with Logger {

  import BootstrapUtils._
  import JsUtils._

  def render= {
    "#result *" #> NodeSeq.Empty
  }

  override def lowPriority = {
    case UpdateClient(id, content) =>
      partialUpdate {
        setHtml(id, content)
      }

    case Progress(i) =>
      partialUpdate {
        setHtml("progress", textInfo(s"$i% progress completed"))
      }
  }
}