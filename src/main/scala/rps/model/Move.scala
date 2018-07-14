package rps

import io.buildo.enumero.annotations.enum

/*
Scala has a strange view of Enumerations, that is
a little bit too much for the average use-case.

The "agile-version" of enumerations are called
"sealed trait extended by case objects".

The buildo versions of the enumerations are called:
```enumero```
 */
@enum trait Move {
  object Rock
  object Paper
  object Scissors
}
