package Domain

import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.model.Updates.set
import org.mongodb.scala.{Completed, Document, Observer}
import tour.Helpers._
import tour.Main._

class Item {

  def create(): Unit = {
    println("Select the id of the item you want to add: ")
    val id = scala.io.StdIn.readLine
    println("Select the name of the item you want to add: ")
    val name = scala.io.StdIn.readLine
    println("Select the price of the item you want to add: ")
    val price = scala.io.StdIn.readLine

    val person: Document = Document("_id" -> id, "name" -> name, "price" -> price)

    val insertObservable = items.insertOne(person)
    insertObservable.subscribe(new Observer[Completed] {

      override def onNext(result: Completed): Unit = println("Inserted")

      override def onError(e: Throwable): Unit = println("Failed")

      override def onComplete(): Unit = println("Completed")
    })
    Thread.sleep(1000)
  }

  def read(): Unit = {
    items.find().printResults()
  }

  def update(): Unit = {
    println("Select the current id of the item you want to update: ")
    val id = scala.io.StdIn.readLine()

    println("Select new name: ")
    val newName = scala.io.StdIn.readLine()

    items.updateOne(equal("_id", id), set("name", newName)).printHeadResult("Update Result: ")
  }

  def delete(): Unit = {
    println("Select id of item to delete: ")
    val id = scala.io.StdIn.readLine()
    items.deleteOne(equal("_id", id)).printHeadResult("Delete Result: ")
  }


}
