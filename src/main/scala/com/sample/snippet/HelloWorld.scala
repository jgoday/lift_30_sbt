package com.sample
package snippet

import java.util.Date

import net.liftweb.util._
import net.liftweb.common._
import Helpers._

import com.sample.lib.DependencyFactory

class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  // replace the contents of the element with id "time" with the date
  def howdy = "#time *" #> date.map(_.toString)
}

