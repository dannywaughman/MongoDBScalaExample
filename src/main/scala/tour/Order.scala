package tour

import com.mongodb.client.model.Projections
import org.mongodb.scala.{Completed, Document, Observer}
import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.model.Updates.set
import tour.Runner._
import tour.Helpers._

class Order {

  // I want this to take in item name and price from items collection
  def create(): Unit = {
    println("Select the id of the order you want to add: ")
    val id = scala.io.StdIn.readLine
    println("Select the name of the item you want to add to order: ")
    val name = scala.io.StdIn.readLine
    println("Select the price of this item: ")
    val price = scala.io.StdIn.readLine
    println("Enter the id of the item to add to order: ")
    val itemId = scala.io.StdIn.readLine

    val order: Document = Document("_id" -> id, "Items" -> Document("name" -> name,"price" -> price))

    val insertObservable = orders.insertOne(order)
    insertObservable.subscribe(new Observer[Completed] {

      override def onNext(result: Completed): Unit = println("Inserted")

      override def onError(e: Throwable): Unit = println("Failed")

      override def onComplete(): Unit = println("Completed")
    })
    Thread.sleep(1000)
  }

  def read(): Unit = {
    orders.find().printResults()
  }

  def update(): Unit = {
    println("Select the current id of the order you want to update: ")
    val id = scala.io.StdIn.readLine()

    println("Select new name: ")
    val newName = scala.io.StdIn.readLine()

    orders.updateOne(equal("_id", id), set("name", newName)).printHeadResult("Update Result: ")
  }

  def delete(): Unit = {
    println("Select id of order to delete: ")
    val id = scala.io.StdIn.readLine()
    orders.deleteOne(equal("_id", id)).printHeadResult("Delete Result: ")
  }

}
