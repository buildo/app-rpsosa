package rps

import RPSMoves._



object Game {
  def play(): Unit = {

    /* Ask for user input */
    val userMoveString = readLine(s"""
    |What's your move?"
    |0: ${RPSMoves.show(Rock)}
    |1: ${RPSMoves.show(Paper)}
    |2: ${RPSMoves.show(Scissors)}
    |
    |> """.stripMargin)

    val userMove = RPSMoves.factoryMove(userMoveString)


    /*
      RPSMoves.factoryMove(string) returns an instance of an Option,
      where the instance is either:

      - An instance of the Scala Some class
      - An instance of the Scala None class

      Because Some and None are both children of Option,
      my function signature just declares that I am returning an
      Option that contains some type (such as the RPSMove type shown below).
      */

    userMove match {
      case None => println(s"Mmm looks like your move was not legal... 🤔")
      case Some(userMove) => {

        val computerMove = generateCPUMove()

        println(s"Your move was:    ${RPSMoves.show(userMove)}")
        println(s"The CPU move was: ${RPSMoves.show(computerMove)}")

        /* Compute the outcome */
        computeGameOutcome(userMove, computerMove)
      }
    }
  }

    private def generateCPUMove(): RPSMove = {
      import scala.util.Random
      Random.shuffle(Set(Rock, Paper, Scissors)).head
    }

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
      case (Rock, Scissors) | (Paper, Rock) | (Scissors, Paper) => println("You Win! 😤") // I used pipe to match multiple conditions
      case _ => println("You Lose! 🤩") // _ stands for the default case
    }

  }
}



