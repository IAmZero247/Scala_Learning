package l02_oops_03_companion


class Donut1(name: String, productCode: Option[Long] = None){
  var ver= 10;

  def print = println(s"Donut name = $name, productCode = ${productCode.getOrElse(0)}, uuid = ${Donut1.uuid} ,ver = ${ver}")

}
object Donut1 {

  private val uuid = 1

  def apply(name: String, productCode: Option[Long]): Donut1 = {
    new Donut1(name, productCode)
  }

  def apply(name: String): Donut1 = {
    new Donut1(name)
  }
}
/************************************************************************/
class MyClass {
  var x = 5

  def getValue(): Unit ={
    println(s"Value of x is: ${x} and value of y is: ${MyClass.y}" )
  }
}

object MyClass {
  var y = 2.2

  def demo()= {
    val objectForCompanionDemoClass = new MyClass()
    println(s"Value of x when retrieved from companion object is ${objectForCompanionDemoClass.x}")
    println(s"Value of y when retrieved from companion object is ${y}")
    objectForCompanionDemoClass.getValue
  }
}
/*************************************************************************/
object CompanionDemo1{
  def main(args: Array[String]): Unit = {
    val glazedDonut = Donut1("Glazed Donut", Some(1111))
    val vanillaDonut = Donut1("Vanilla Donut")
    MyClass.demo()
  }
}