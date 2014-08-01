package com.sample
package snippet

import scala.xml._

import net.liftweb.common._
import net.liftweb.util._
import net.liftweb.http._
import Helpers._

import util.{BootstrapUtils, JsUtils}

class SampleComet {
    private def sampleComet =
      S.session.flatMap(_.findComet("SampleComet", Full("sampleComet")))

    private def callComet = () => {
      SampleActor ! DoStuff(sampleComet)

      JsUtils.append("to-replace", BootstrapUtils.bgInfo("ajax call finished"))
    }
        
    def render = "#btn [onclick]" #> SHtml.ajaxInvoke(callComet)
}

import net.liftweb.actor._

case class DoStuff(cometRef: Box[LiftCometActor])

object SampleActor extends LiftActor {
    protected def messageHandler = {
        case DoStuff(cometRef) =>
            cometRef.foreach { ref =>
                for { i <- 0 to 10 } {
                    Thread.sleep(1000)
                    ref ! comet.Progress(i * 10)
                }

                ref ! comet.UpdateClient(
                    "to-replace",
                    BootstrapUtils.bgSuccess("Work done !"))
            }
    }
}