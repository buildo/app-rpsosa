package rps

import Move._
import Result._
import io.buildo.enumero.{CaseEnumIndex, CaseEnumSerialization}

object Game {
  def play(userMove: Move): Response = {
    /* Ask for user input */
    val computerMove = generateCPUMove()
    val outcome = computeGameOutcome(userMove, computerMove)

    Response(
      userMove,
      computerMove,
      outcome
    )
  }

  private def generateCPUMove(): Move = {
    import scala.util.Random
    /* Apparently there is no way of obtaining
      the set of all enumerators from a CaseEnumIndex
      so I am going to recreate everything here.*/
    Random.shuffle(Move.values).head
  }

  private def computeGameOutcome(userMove: Move, cpuMove: Move): Result = {

    /*  Here I used pattern matching.
        All cases are prioritized by their ordering:
        e.g.
        1. case ("0") => action a
        2. case ("0") => action b

        1 and 2 matches, but action a is executed.
     */
    (userMove, cpuMove) match {
      case (x, y) if (x == y)                                   => Draw
      case (Rock, Scissors) | (Paper, Rock) | (Scissors, Paper) => Win
      case _                                                    => Lose
    }

  }
}
