package com.sample
package snippet

import scala.xml.{Elem, NodeSeq, Text}
import net.liftweb.actor._
import net.liftweb.common._
import net.liftweb.util.Helpers._

import util.FutureUtils._

class SampleFuture {

  def render = {
    val future: LAFuture[NodeSeq] = LAFuture(() => {
      Thread.sleep(5000)
      Text("future finished after 5000 ms")
    })

    "#future-result *" #> future &
    "#non-future *" #> "Non future value"
  }
}
