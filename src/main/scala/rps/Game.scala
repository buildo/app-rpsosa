package rps

import RPSMoves._
import io.buildo.enumero.{CaseEnumIndex}



object Game {
  def play(): Unit = {

    /* Ask for user input */
    val userMoveString = readLine(s"""
    |What's your move?"
    |0: Rock
    |1: Paper
    |2: Scissors
    |
    |> """.stripMargin)

    val userMove = CaseEnumIndex[RPSMoves].caseFromIndex(userMoveString)

    userMove match {
      case None => println(s"Mmm looks like your move was not legal... 🤔")
      case Some(userMove) => {

        val computerMove = generateCPUMove()
        println(s"Your move was:    ${CaseEnumIndex[RPSMoves].caseToIndex(userMove)}")
        println(s"The CPU move was: ${CaseEnumIndex[RPSMoves].caseToIndex(computerMove)}")

        /* Compute the outcome */
        computeGameOutcome(userMove, computerMove)
      }
    }
  }

    private def generateCPUMove(): RPSMoves = {
      import scala.util.Random
      /* Apparently there is no way of obtaining 
      the set of all enumerators from a CaseEnumIndex
      so I am going to recreate everything here.*/
      Random.shuffle(Set(Rock, Paper, Scissors)).head 
    }

  private def computeGameOutcome(userMove: RPSMoves, cpuMove: RPSMoves): Unit = {

    /*  Here I used pattern matching.
        All cases are prioritized by their ordering:
        e.g.
        1. case ("0") => action a
        2. case ("0") => action b

        1 and 2 matches, but action a is executed.
        */
    (userMove, cpuMove) match {
      case (x,y) if (x == y) => println("It's a draw! 🧐") // I used a "guard"
      case (Rock, Scissors) | (Paper, Rock) | (Scissors, Paper) => println("You Win! 😤") // I used pipe to match multiple conditions
      case _ => println("You Lose! 🤩") // _ stands for the default case
    }

  }
}



