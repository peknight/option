package com.peknight.option

import com.peknight.codec.obj.Object

sealed trait Options derives CanEqual:
  
end Options
object Options:
  case object OptionNull extends Options
  case class OptionValue(value: String) extends Options
  case class OptionArray(value: Vector[Options]) extends Options
  case class OptionObject(value: Object[OptionKey, Options]) extends Options
end Options
