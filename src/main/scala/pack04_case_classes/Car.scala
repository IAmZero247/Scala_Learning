package pack04_case_classes

case class Car(name: String, model: String) {
  val carName = name
  val carModel = model

  def printDetails(): Unit ={
    println(s"Car Name is: ${carName} or ${name} and Car Model is: ${carModel}")
  }
}