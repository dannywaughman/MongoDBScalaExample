package tour
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import tour.Runner._
import tour.Helpers._
import org.mongodb.scala.model.Updates._

class Customer {

  def create(): Unit = {
    println("Select the id of the customer you want to add: ")
    val id = scala.io.StdIn.readLine
    println("Select the name of the customer you want to add: ")
    val name = scala.io.StdIn.readLine

    val person: Document = Document("_id" -> id, "name" -> name)

    val insertObservable = customers.insertOne(person)
    insertObservable.subscribe(new Observer[Completed] {

      override def onNext(result: Completed): Unit = println("Inserted")

      override def onError(e: Throwable): Unit = println("Failed")

      override def onComplete(): Unit = println("Completed")
    })
    Thread.sleep(1000)
  }

  def read(): Unit = {
    customers.find().printResults()
  }

  def update(): Unit = {
    println("Select the current id of the customer you want to update: ")
    val id = scala.io.StdIn.readLine()

    println("Select new name: ")
    val newName = scala.io.StdIn.readLine()

    customers.updateOne(equal("_id", id), set("name", newName)).printHeadResult("Update Result: ")
  }

  def delete(): Unit = {
    println("Select id of customer to delete: ")
    val id = scala.io.StdIn.readLine()
    customers.deleteOne(equal("_id", id)).printHeadResult("Delete Result: ")
  }


}
