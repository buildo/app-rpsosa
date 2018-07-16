package rps

import scala.concurrent.Future
import wiro.annotation._
import concurrent._
import concurrent.duration._

// API definition

@path("rps")
trait GameController {

  @command
  def play(
      userMove: Move
  ): Future[Either[Throwable, Unit]]

  @query
  def result(): Future[Either[Throwable, Match]]
}

class GameControllerImpl(gameService: GameService)(
    implicit ecd: ExecutionContext)
    extends GameController {

  override def play(
      userMove: Move
  ): Future[Either[Throwable, Unit]] =
    Future {
      Right(
        gameService.play(userMove)
      )
    }

  override def result(): Future[Either[Throwable, Match]] = Future {
    var lastGame = gameService.getLastGame()
    lastGame.toRight(new IllegalStateException)
  }

}
