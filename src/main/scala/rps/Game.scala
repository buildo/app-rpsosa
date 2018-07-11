package rps

import RPSMoves._

object Game {
  def play(): Unit = {

    /* Ask for user input */
    val userMoveString = readLine(s"""
    |What's your move?"
    |0: ${ROCK.toString}
    |1: ${PAPER.toString}
    |2: ${SCISSORS.toString}
    |
    |> """.stripMargin)

    val userMove = RPSMoves.factoryMove(userMoveString)

    if (userMove == None) {
      println(s"Mmm looks like your move was not legal... 🤔")
    } else {

    val computerMoveString = generateCPUMove()
    val computerMove = RPSMoves.factoryMove(computerMoveString)

    println(s"Your move was:    ${userMove.get.toString}")
    println(s"The CPU move was: ${computerMove.get.toString}")

    /* Compute the outcome */
    computeGameOutcome(userMove.get, computerMove.get)
    }
  }

  private def generateCPUMove(): String =
    scala.util.Random.nextInt(3).toString()

  private def computeGameOutcome(userMove: RPSMove, cpuMove: RPSMove): Unit = {

    /*  Here I used pattern matching.
        All cases are prioritized by their ordering:
        e.g.
        1. case ("0") => action a
        2. case ("0") => action b

        1 and 2 matches, but action a is executed.
        */
    (userMove, cpuMove) match {
      case (x,y) if (x == y) => println("It's a draw! 🧐") // I used a "guard"
      case (ROCK, SCISSORS) | (PAPER, ROCK) | (SCISSORS, PAPER) => println("You Win! 😤") // I used pipe to match multiple conditions
      case _ => println("You Lose! 🤩") // _ stands for the default case
    }

  }
}



