package rps

import RPSMove._
import io.buildo.enumero.{CaseEnumIndex, CaseEnumSerialization}




object Game {
  def play(userMoveString: String): Option[RPSResponse] = {
    /* Ask for user input */
    val userMove = CaseEnumSerialization[RPSMove].caseFromString(userMoveString)

    userMove match {
      case None => None
      case Some(userMove) => {

        val computerMove = generateCPUMove()
        val outcome = computeGameOutcome(userMove, computerMove)

        Some(RPSResponse(CaseEnumSerialization[RPSMove].caseToString(userMove), CaseEnumSerialization[RPSMove].caseToString(computerMove), outcome))
      }
    }
  }

    private def generateCPUMove(): RPSMove = {
      import scala.util.Random
      /* Apparently there is no way of obtaining 
      the set of all enumerators from a CaseEnumIndex
      so I am going to recreate everything here.*/
      Random.shuffle(Set(Rock, Paper, Scissors)).head 
    }

  private def computeGameOutcome(userMove: RPSMove, cpuMove: RPSMove): String = {

    /*  Here I used pattern matching.
        All cases are prioritized by their ordering:
        e.g.
        1. case ("0") => action a
        2. case ("0") => action b

        1 and 2 matches, but action a is executed.
        */
    (userMove, cpuMove) match {
      case (x,y) if (x == y) => "Draw"
      case (Rock, Scissors) | (Paper, Rock) | (Scissors, Paper) => "Win"
      case default => "Lose"
    }

  }
}



