package rps;

object Game {
  def play(): Unit = {

    /* Ask for user input */
    val userMove = readLine(
      "What's your move?\n" +
        "0: " + returnMoveIcon("0") + "\n" +
        "1: " + returnMoveIcon("1") + "\n" +
        "2: " + returnMoveIcon("2") + "\n\n" +
        "> ")

    val computerMove = generateCPUMove();

    println("Your move was: " + returnMoveIcon(userMove))
    println("The CPU move was: " + returnMoveIcon(computerMove))

    /* Compute the outcome */
    computeGameOutcome(userMove, computerMove)
  }

  private def generateCPUMove(): String =
    scala.util.Random.nextInt(3).toString()

  private def computeGameOutcome(userMove: String, cpuMove: String): Unit = {
    if (userMove == cpuMove) {
      println("It's a draw! 🧐")
    } else if (userMove == "0" && cpuMove == "2" ||
               userMove == "2" && cpuMove == "1" ||
               userMove == "1" && cpuMove == "0") {
      println("You Win! 😤")
    } else {
      println("You Lose! 🤩")
    }

  }

  private def returnMoveIcon(move: String): String = {
    if (move == "0") {
      return "💎"
    } else if (move == "1") {
      return "📄"
    } else if (move == "2") {
      return "✂️"
    }
    return ""
  }

}
//
