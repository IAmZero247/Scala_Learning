package l04_oops_inheritance_01_basics

package l04_oops_inheritance_01_basics
abstract class Donut2(name: String) {
  def printName: Unit
}

case class VanillaDonut2(name: String) extends Donut2(name) {

  override def printName: Unit = println(name)

}


case class GlazedDonut2(name: String) extends Donut2(name) {

  override def printName: Unit = println(name)

}



object InheritanceDemo2 {
  def main(args: Array[String]): Unit = {
    val vanillaDonut: Donut2 = VanillaDonut2("Vanilla Donut")
    vanillaDonut.printName

    val glazedDonut: Donut2 = GlazedDonut2("Glazed Donut")
    glazedDonut.printName
  }
}
