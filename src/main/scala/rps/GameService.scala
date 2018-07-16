package rps

import Move._
import Result._
import io.buildo.enumero.{CaseEnumIndex, CaseEnumSerialization}
import wiro.annotation._

trait GameService {

  def play(
      userMove: Move
  ): Unit;

  def getLastGame(): Option[Match];
}

class GameServiceImpl(gameRepository: GameRepository) extends GameService {

  override def play(
      userMove: Move
  ): Unit = {
    val computerMove = generateCPUMove()
    val outcome = computeGameOutcome(userMove, computerMove)
    val matchToBeSaved = Match(userMove, computerMove, outcome)
    gameRepository.saveGameOutcome(matchToBeSaved)
  }

  override def getLastGame(): Option[Match] = {
    gameRepository.loadGameOutcome()
  }

  private def generateCPUMove(): Move = {
    import scala.util.Random
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
