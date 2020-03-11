package tour
import Domain.{Customer, Item, Order}
import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}
import tour.Controller._

object Main extends App {

//val codecRegistry =
  val mongoClient: MongoClient = MongoClient()
  val database: MongoDatabase = mongoClient.getDatabase("myfirstdb")
  val customers: MongoCollection[Document] = database.getCollection("Customers")
  val customer = new Customer
  val items: MongoCollection[Document] = database.getCollection("Items")
  val item = new Item
  val orders: MongoCollection[Document] = database.getCollection("Orders")
  val order = new Order

  var running = true

    while (running) {

      println()
      println("What would you like to do?")
      println("CUSTOMERS - create, view, update & delete customers")
      println("ITEMS - create, view, update & delete items")
      println("ORDERS - create, view, update & delete orders")
      println("Type 'exit' to exit the program")
      println()
      val select = scala.io.StdIn.readLine.toLowerCase()

      select match {
        case "customers" => customerController()
        case "items" => itemController()
        case "orders" => orderController()
        case "exit" => running = false
        case _ => println("Enter a valid option please")
      }

    }

}
