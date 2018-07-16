package rps

import Move._
import Result._
import Match._
import scala.collection.concurrent.TrieMap

trait GameRepository {

  def saveGameOutcome(
      theId: String,
      theMatch: Match
  ): Unit;

  def loadGameOutcome(theId: String): Option[Match];
}

class GameRepositoryImpl() extends GameRepository {

  private val memory = TrieMap.empty[String, Match]

  override def saveGameOutcome(
      theId: String,
      theMatch: Match
  ): Unit = {
    memory.put(theId, theMatch)
  }

  override def loadGameOutcome(theId: String): Option[Match] = {
    memory.get(theId)
  }
}
