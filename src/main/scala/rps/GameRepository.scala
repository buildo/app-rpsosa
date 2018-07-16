package rps

import Move._
import Result._
import Match._
import scala.collection.concurrent.TrieMap

trait GameRepository {

  def saveGameOutcome(
      theMatch: Match
  ): Unit;

  def loadGameOutcome(): Option[Match];
}

class GameRepositoryImpl() extends GameRepository {

  private val memory = TrieMap.empty[String, Match]

  override def saveGameOutcome(
      theMatch: Match
  ): Unit = {
    memory.put("lastMatch", theMatch)
  }

  override def loadGameOutcome(): Option[Match] = {
    memory.get("lastMatch")
  }
}
