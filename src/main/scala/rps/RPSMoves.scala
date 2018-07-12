package rps
import io.buildo.enumero.annotations.indexedEnum


/*

Scala has a strange view of Enumerations, that is
a little bit too much for the average use-case.

The "agile-version" of enumerations are called
"sealed trait extended by case objects".

The buildo versions of the enumerations are called:
```enumero```
*/

/* 
I will use the @indexedEnum annotation, that
builds enumerations that follow the library's 
convention for ADT-based enums with an associated value.
*/
@indexedEnum trait RPSMoves {
    type Index = String
    object Rock { "0" }
    object Paper { "1" }
    object Scissors { "2" }
}
