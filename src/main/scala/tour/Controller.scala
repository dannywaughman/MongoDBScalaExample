package tour

import tour.Main.{customer, running,item,order}

object Controller {

  def customerController():Unit = {
    var inCustomers = true
    while (inCustomers) {
      println()
      println("What would you like to do?")
      println("ADD - Add a customer to the database")
      println("READ - Read the customers in the database")
      println("UPDATE - Update an existing customer in the database")
      println("DELETE - Delete a customer from the database")
      println("Type 'back' to go back or 'exit' to exit the program")

      val input = scala.io.StdIn.readLine.toLowerCase()

      input match {
        case "add" => customer.create()
        case "read" => customer.read()
        case "update" => customer.update()
        case "delete" => customer.delete()
        case "back" => inCustomers = false
        case "exit" => running = false; inCustomers = false
        case _ => println("Enter a valid option please")
      }
    }
}
  def itemController():Unit = {
    var inItems = true
    while (inItems) {
      println()
      println("What would you like to do?")
      println("ADD - Add an item to the database")
      println("READ - Read the items in the database")
      println("UPDATE - Update an existing item in the database")
      println("DELETE - Delete an item from the database")
      println("Type 'back' to go back or 'exit' to exit the program")

      val input = scala.io.StdIn.readLine.toLowerCase()

      input match {
        case "add" => item.create()
        case "read" => item.read()
        case "update" => item.update()
        case "delete" => item.delete()
        case "back" => inItems = false
        case "exit" => running = false; inItems = false
        case _ => println("Enter a valid option please")
      }
    }
  }
  def orderController():Unit = {
    var inOrders = true
    while(inOrders) {
      println()
      println("What would you like to do?")
      println("ADD - Add an order to the database")
      println("READ - Read the orders in the database")
      println("UPDATE - Update an existing order in the database")
      println("DELETE - Delete an order from the database")
      println("Type 'back' to go back or 'exit' to exit the program")

      val input = scala.io.StdIn.readLine.toLowerCase()

      input match {
        case "add" => order.create()
        case "read" => order.read()
        case "update" => order.update()
        case "delete" => order.delete()
        case "back" => inOrders = false
        case "exit" => running = false; inOrders = false
        case _ => println("Enter a valid option please")
      }
    }
  }

}
