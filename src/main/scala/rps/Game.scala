package rps

import Move._
import Result._
import io.buildo.enumero.{CaseEnumIndex, CaseEnumSerialization}

import scala.concurrent.Future
import wiro.annotation._
import scala.concurrent.ExecutionContext._
import concurrent._
import concurrent.duration._
// API definition

@path("rps")
trait GameApi {
  @command
  def play(
      userMove: Move
  ): Future[Either[Throwable, Response]]
}

// API implementation
class GameApiImpl()(implicit ec: ExecutionContext) extends GameApi {

  override def play(
      userMove: Move
  ): Future[Either[Throwable, Response]] =
    Future {

      val computerMove = generateCPUMove()
      val outcome = computeGameOutcome(userMove, computerMove)

      Right(
        Response(
          userMove,
          computerMove,
          outcome
        ))
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
