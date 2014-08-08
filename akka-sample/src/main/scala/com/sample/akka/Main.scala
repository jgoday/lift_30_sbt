package com.sample
package akka

import _root_.akka.actor._

object Main {
  def main(args: Array[String]) {
    val system = ActorSystem("Ping")
    val a = system.actorOf(Props[PingActor], "ping")
    system.actorOf(Props(classOf[Terminator], a), "terminator")
  }

  class Terminator(ref: ActorRef) extends Actor with ActorLogging {
    context watch ref

    def receive = {
      case Terminated(_) =>
        log.info("{} has terminated, shuting down system", ref.path)
        context.system.shutdown()
    }
  }
}