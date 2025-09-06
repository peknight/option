package com.peknight.option

import cats.Eq

enum ArgumentStyle:
  case EqualsSeparated, SpaceSeparated, NoArgument
end ArgumentStyle
object ArgumentStyle:
  given eqArgumentStyle: Eq[ArgumentStyle] = Eq.fromUniversalEquals[ArgumentStyle]
end ArgumentStyle
