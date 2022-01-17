package l02_oops_03_companion
class Donut2(name: String, productCode: Long){

  def print = println(s"Donut name = $name, productCode = $productCode")

}
object Donut2 {

  def apply(name: String, productCode: Long): Donut2 = {
    new Donut2(name, productCode)
  }

}
object CompanionDemo2 {
  def main(args: Array[String]): Unit = {
    val glazedDonut = Donut2("Glazed Donut", 1111)
    val vanillaDonut = Donut2("Vanilla Donut", 2222)
    glazedDonut.print
    vanillaDonut.print
  }
}
