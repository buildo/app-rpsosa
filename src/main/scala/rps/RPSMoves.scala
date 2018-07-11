package rps


/*

Scala has a strange view of Enumerations, that is
a little bit too much for the average use-case.

The "agile-version" of enumerations are called
"sealed trait extended by case objects".

Here we define a RPSMoves ADT that will contain
useful definitions and methods to craft RPS Moves.

*/


object RPSMoves {

sealed abstract class RPSMove(
    val icon : String,
    val value : String) {

    override def toString = icon
  }

    case object ROCK extends RPSMove("💎", "0")
    case object PAPER extends RPSMove("📄", "1")
    case object SCISSORS extends RPSMove("✂️", "2")

    // I need to find a way to obtain this set automagically
    val setOfMoves: Set[RPSMove] = Set(ROCK, PAPER, SCISSORS)

    def factoryMove(aMoveString: String): Option[RPSMove] = {
        setOfMoves.filter(_.value == aMoveString).headOption
    }
}
