package rps

object Game {
  def play(): Unit = {

    /* Ask for user input */
    val userMove = readLine(s"""
    |What's your move?"
    |0: ${returnMoveIcon("0")}
    |1: ${returnMoveIcon("1")}
    |2: ${returnMoveIcon("2")}
    |
    |> """.stripMargin)

    val computerMove = generateCPUMove();

    println(s"Your move was:    ${returnMoveIcon(userMove)}")
    println(s"The CPU move was: ${returnMoveIcon(computerMove)}")

    /* Compute the outcome */
    computeGameOutcome(userMove, computerMove)
  }

  private def generateCPUMove(): String =
    scala.util.Random.nextInt(3).toString()

  private def computeGameOutcome(userMove: String, cpuMove: String): Unit = {

    /*  Here I used pattern matching.
        All cases are prioritized by their ordering:
        e.g.
        1. case ("0") => action a
        2. case ("0") => action b

        1 and 2 matches, but action a is executed.
        */
    (userMove, cpuMove) match {
      case (x,y) if (x == y) => println("It's a draw! 🧐") // I used a "guard"
      case ("1","0") | ("2","1") | ("0","2") => println("You Win! 😤") // I used pipe to match multiple conditions
      case _ => println("You Lose! 🤩") // _ stands for the default case
    }

  }

  private def returnMoveIcon(move: String): String = {

    move match {
      case "0" => "💎"
      case "1" => "📄"
      case "2" => "✂️"
      case _ => "💩"
    }
  }

}
