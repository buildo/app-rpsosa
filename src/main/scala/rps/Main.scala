package rps

import wiro.server.akkaHttp.ToHttpResponse
import wiro.server.akkaHttp._
import wiro.server.akkaHttp.FailSupport._

import akka.http.scaladsl.model.{
  HttpResponse,
  StatusCodes,
  ContentType,
  HttpEntity
}
import wiro.Config
import scala.concurrent.ExecutionContext._

import akka.http.scaladsl.model.MediaTypes

import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport._
import io.circe.generic.auto._
import io.buildo.enumero.circe._

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object RPSServer extends App with RouterDerivationModule {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  implicit def throwableResponse: ToHttpResponse[Throwable] = null

  val gameApiImpl = new GameApiImpl()(ec)

  val gameRouter = deriveRouter[GameApi](gameApiImpl)

  val rpcServer = new HttpRPCServer(
    config = Config("localhost", 8080),
    routers = List(gameRouter)
  )
}
