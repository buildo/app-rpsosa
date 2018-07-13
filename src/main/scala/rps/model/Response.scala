package rps

import Move._
import Result._
case class Response(userMove: Move, computerMove: Move, result: Result)
