package com.sample
package akka

import _root_.akka.actor._

class PingActor extends Actor with ActorLogging {
  def receive = {
    case Ping =>
      log.info("Receive ping message")
      sender() ! Pong("Pong!!")

    case Done =>
      context.stop(self)
  }
}

case object Ping
case object Done
case class Pong(msg: String)