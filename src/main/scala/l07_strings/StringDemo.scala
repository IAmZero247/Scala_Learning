package l07_strings

object StringDemo {
  def main(args: Array[String]): Unit = {
    // String Formatting
    var nameOfCar = "Mercedes"
    var costOfCar = 500000
    var milageOfCar = 8.5

    printf("Name of Car is %s and cost of Car is %d and milage of Car is %f", nameOfCar, costOfCar, milageOfCar)

    // Multi Line Strings - Note: Use 3 double inverted commas """ string """. Also use | symbol and stripMargin function for orientation
    println("")

    var multiLineStringA =
      """Hello
        |World
        |How
        |are
        |you
      """.stripMargin
    println(multiLineStringA)
    var multiLineStringB =
      """Hello
        $World
        $How
        $are
        $you
      """.stripMargin('$')
    println(multiLineStringB)

    // String Interpolation - Scala 2.10 onwards
    //    1. 's' String Interpolator
    var name = "PM Modi"
    println("Hello " + name + ", How are you?")  // using + to concat
    println(s"Hello $name, How are you?")         // using s interpolator. Widely used

    //    2. 'f' Interpolator
    name = "PM Modi"
    var salary = 20000.2
    println(f"Name is $name%s and salary is $salary%8.2f and designation is PM")

    // 3. raw Interpolator - Same as s interpolator but does not perform escaping. escaping - \n \t
    println(s"Hello World!\nHow are you?")
    println(raw"Hello World!\nHow are you?")

    // read through all methods of string in java - https://www.javatpoint.com/java-string
    // practice from - https://data-flair.training/blogs/scala-string-method/
  }
}
