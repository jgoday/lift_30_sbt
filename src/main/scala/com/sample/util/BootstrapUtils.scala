package com.sample
package util

import scala.xml.{NodeSeq}

object BootstrapUtils {
  def textMutted(msg: String): NodeSeq = <p class="text-mutted">{msg}</p>
  def textPrimary(msg: String): NodeSeq = <p class="text-primary">{msg}</p>
  def textSuccess(msg: String): NodeSeq = <p class="text-success">{msg}</p>
  def textInfo(msg: String): NodeSeq = <p class="text-info">{msg}</p>
  def textWarning(msg: String): NodeSeq = <p class="ẗext-warning">{msg}</p>
  def textDanger(msg: String): NodeSeq = <p class="ẗext-danger">{msg}</p>

  def bgMutted(msg: String): NodeSeq = <p class="bg-mutted">{msg}</p>
  def bgPrimary(msg: String): NodeSeq = <p class="bg-primary">{msg}</p>
  def bgSuccess(msg: String): NodeSeq = <p class="bg-success">{msg}</p>
  def bgInfo(msg: String): NodeSeq = <p class="bg-info">{msg}</p>
  def bgWarning(msg: String): NodeSeq = <p class="bg-warning">{msg}</p>
  def bgDanger(msg: String): NodeSeq = <p class="bg-danger">{msg}</p>
}