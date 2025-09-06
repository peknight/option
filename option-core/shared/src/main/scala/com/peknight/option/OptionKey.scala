package com.peknight.option

import cats.Show
import cats.syntax.eq.*
import spire.math.Interval

sealed trait OptionKey:
  def key: String
  def keyType: OptionKeyType
  def argumentStyle: ArgumentStyle
  def argumentLength: Interval[Int]
  def combinable: Boolean
end OptionKey
object OptionKey:
  case class LongOption(key: String, argumentStyle: ArgumentStyle, private val argLen: Interval[Int], private val canBeCombined: Boolean) extends OptionKey:
    def keyType: OptionKeyType = OptionKeyType.LongOption
    def argumentLength: Interval[Int] = argLen & Interval.atOrAbove(0)
    def combinable: Boolean = canBeCombined && argumentStyle === ArgumentStyle.NoArgument && argumentLength === Interval.point(0)
  end LongOption
  given showOptionKey: Show[OptionKey] =
    // TODO
    Show.fromToString[OptionKey]
end OptionKey
