package l04_oops_inheritance_01_basics
abstract class Donut1(name: String) {
  def printName: Unit
}

class VanillaDonut1(name: String) extends Donut1(name) {

  override def printName: Unit = println(name)

}

object VanillaDonut1 {

  def apply(name: String): Donut1 = {
    new VanillaDonut1(name)
  }
}

class GlazedDonut1(name: String) extends Donut1(name) {

  override def printName: Unit = println(name)

}

object GlazedDonut1 {

  def apply(name: String): Donut1 = {
    new GlazedDonut1(name)
  }

}

object InheritanceDemo1 {
  def main(args: Array[String]): Unit = {
    val vanillaDonut: Donut1 = VanillaDonut1("Vanilla Donut")
    vanillaDonut.printName

    val glazedDonut: Donut1 = GlazedDonut1("Glazed Donut")
    glazedDonut.printName
  }
}
