package pack06_patterns

case class Car(name:String, cost:Int)
object PatternDemo2 {

  def main(args: Array[String]): Unit = {
    val mercedes = Car("Mercedes", 500000)
    val bmw = Car("BMW",700000)
    val jaguar = new Car("Jaguar", 1000000)

    for (car <- List(mercedes,bmw,jaguar)){
      car match{
        case Car("Mercedes" , 500000) => println("Car is Mercedes")
        case Car("BMW",700000) => println("Car is Bmw")
        case Car(a,b) => println("Car is " + a)
      }
    }
  }

}
