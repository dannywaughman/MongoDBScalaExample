package tour
import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}
import tour.Names._

object Runner extends App {

  val mongoClient: MongoClient = MongoClient()
  val database: MongoDatabase = mongoClient.getDatabase("myfirstdb")
  val collection: MongoCollection[Document] = database.getCollection("People")

  var running = true

  while (running) {

    println()
    println("What would you like to do?")
    println("ADD - Add someone to the database")
    println("READ - Read the people in the database")
    println("UPDATE - Update an existing person in the database")
    println("DELETE - Delete someone from the database")
    println("Type 'exit' to exit the program")
    val input = scala.io.StdIn.readLine.toLowerCase()

    input match {
      case "add" => create()
      case "read" => read()
      case "update" => update()
      case "delete" => delete()
      case "exit" => running = false
    }
  }

}
