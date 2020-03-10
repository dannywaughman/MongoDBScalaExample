package tour
import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}

object Runner extends App {


    val mongoClient: MongoClient = MongoClient()
    val database: MongoDatabase = mongoClient.getDatabase("myfirstdb")
    val customers: MongoCollection[Document] = database.getCollection("Customers")
    val customer = new Customer
    var running = true

    while (running) {

      println()
      println("What would you like to do?")
      println("ADD - Add a customer to the database")
      println("READ - Read the customers in the database")
      println("UPDATE - Update an existing customer in the database")
      println("DELETE - Delete a customer from the database")
      println("Type 'exit' to exit the program")
      val input = scala.io.StdIn.readLine.toLowerCase()

      input match {
        case "add" => customer.create()
        case "read" => customer.read()
        case "update" => customer.update()
        case "delete" => customer.delete()
        case "exit" => running = false
      }
    }

}
