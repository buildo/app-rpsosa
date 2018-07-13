package rps

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.stream.ActorMaterializer
import StatusCodes._

import scala.io.StdIn

import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport._
import io.circe.generic.auto._
import io.buildo.enumero.circe._

object WebServerRPS {
  def main(args: Array[String]) {

    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    implicit def myRejectionHandler =
      RejectionHandler
        .newBuilder()
        .handle {
          case MalformedRequestContentRejection(message, _) =>
            complete(
              HttpResponse(
                BadRequest,
                entity =
                  s"The request content for 'userMove' field was malformed:\nExpected a value between [ 'Rock' | 'Paper' | 'Scissors' ], but got '${message}'"
              ))
        }
        .result()

    val router =
      pathPrefix("rps") {
        path("play") {
          post {
            entity(as[Request]) { request => /// will unmarshal JSON to RPSRequest
              /* In case of failed unmarshalling the JSON request,
            https://doc.akka.io/docs/akka-http/current/routing-dsl/rejections.html#rejections */
              val result = Game.play(request.userMove)
              complete(result)
            }
          }
        }
      } ~ options(complete()) // accepts all OPTIONS

    val bindingFuture = Http().bindAndHandle(router, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
