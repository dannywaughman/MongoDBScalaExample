package tour
import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}
import tour.Controller._

object Runner extends App {

    val mongoClient: MongoClient = MongoClient()
    val database: MongoDatabase = mongoClient.getDatabase("myfirstdb")
    val customers: MongoCollection[Document] = database.getCollection("Customers")
    val customer = new Customer
    val items: MongoCollection[Document] = database.getCollection("Items")
    val item = new Item
    var running = true

    while (running) {

      println("What would you like to do?")
      println("CUSTOMERS - create, view, update & delete customers")
      println("ITEMS - create, view, update & delete items")
      println("Type 'exit' to exit the program")
      println()
      val select = scala.io.StdIn.readLine.toLowerCase()

      select match {
        case "customers" => customerController()
        case "items" => itemController()
        case "exit" => running = false

      }

    }

}
