package rps


/*

Scala has a strange view of Enumerations, that is
a little bit too much for the average use-case.

The "agile-version" of enumerations are called
"sealed trait extended by case objects".

Here we define a RPSMoves ADT that will contain
useful definitions and methods to craft RPS Moves.

*/

sealed abstract class RPSMove(val value : String)
object RPSMoves {

    case object Rock extends RPSMove("0")
    case object Paper extends RPSMove("1")
    case object Scissors extends RPSMove("2")

    def show(m: RPSMove) = m match {
        case Rock => "💎"
        case Paper => "📄"
        case Scissors => "✂️"
    }

    // I need to find a way to obtain this set automagically
    val setOfMoves: Set[RPSMove] = Set(Rock, Paper, Scissors)

    def factoryMove(aMoveString: String): Option[RPSMove] = {
        setOfMoves.filter(_.value == aMoveString).headOption
    }
}
