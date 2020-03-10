package tour
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import tour.Runner._
import tour.Helpers._

object Names {


  def create(): Unit = {
    println("Select the id of the person you want to add: ")
    val id = scala.io.StdIn.readLine
    println("Select the name of the person you want to add: ")
    val name = scala.io.StdIn.readLine

    val person: Document = Document("_id" -> id, "name" -> name)

    val insertObservable = collection.insertOne(person)
    insertObservable.subscribe(new Observer[Completed] {

      override def onNext(result: Completed): Unit = println("Inserted")

      override def onError(e: Throwable): Unit = println("Failed")

      override def onComplete(): Unit = println("Completed")
    })
    Thread.sleep(1000)
  }

  def read(): Unit = {
    collection.find().printResults()
  }

  def update(): Unit = {
    println("Coming soon!")
  }

  def delete(): Unit = {
    println("Select id of person to delete: ")
    val id = scala.io.StdIn.readLine()
    collection.deleteOne(equal("_id", id)).printHeadResult("Delete Result: ")
  }


}
