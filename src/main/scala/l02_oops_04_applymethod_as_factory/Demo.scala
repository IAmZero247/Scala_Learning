package l02_oops_04_applymethod_as_factory
class Car(name: String, model: Option[String], price:Option[Int]=None){

  def print = println(s"Car name = $name, model = ${model.getOrElse(0)}")
}

class HondaCity(name: String, model:Option[String], price:Option[Int]=None ) extends Car(name,model,price)

class Toyota(name: String, model:Option[String], price:Option[Int]=None ) extends Car(name,model,price)

object Car {
  def apply(name: String, model:  Option[String], price:Option[Int]): Car = {
    name match {
      case "Honda City" => new HondaCity(name, model, price)
      case "Toyota Innova" => new Toyota(name, model, price)
      case _ => new Car(name, model)
    }
  }
}
object Demo {
  def main(args: Array[String]): Unit = {
    val car1 = Car("Honda City" , Option("City") , Option(1000000))
    println(s"The class type of car1 = ${car1.getClass}")
    car1.print

    val car2 = Car("Toyota Innova" , Option("Innova") , Option(2000000))
    println(s"The class type of car2 = ${car2.getClass}")
    car2.print

    val car3 = Car("Honda Jazz" , Option("Jazz") , None)
    println(s"The class type of car3 = ${car3.getClass}")
    car3.print
  }
}
