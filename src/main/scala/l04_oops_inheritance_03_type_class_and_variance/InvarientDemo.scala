package l04_oops_inheritance_03_type_class_and_variance
abstract class DonutInv(name: String) {
  def printName: Unit
}

case class VanillaDonutInv(name: String) extends DonutInv(name) {
  override def printName: Unit = println(name)
}

case class GlazedDonutInv(name: String) extends DonutInv(name) {
  override def printName: Unit = println(name)
}

case class ShoppingCartInv[D <: DonutInv](donuts: Seq[D]){
   /*
   An invarient can hold all typed of subclasses.
   */
  def printCartItems: Unit = donuts.foreach(_.printName)
}






object Demo {

  def main(args: Array[String]): Unit = {
    val vanillaDonut1: VanillaDonutInv = VanillaDonutInv("Vanilla Donut1")
    val glazedDonut1:  GlazedDonutInv = GlazedDonutInv("Glazed Donut1")
    val vanillaDonut2: DonutInv = VanillaDonutInv("Vanilla Donut2")
    val glazedDonut2:  DonutInv = GlazedDonutInv("Glazed Donut2")
    val shoppingCartHoldAllBaseAndSubclass: ShoppingCartInv[DonutInv] = new ShoppingCartInv[DonutInv](Seq[DonutInv](vanillaDonut1, glazedDonut1, vanillaDonut2, glazedDonut2))

    val shoppingCartHoldVanillaDonutOnly: ShoppingCartInv[VanillaDonutInv] = new ShoppingCartInv[VanillaDonutInv](Seq[VanillaDonutInv](vanillaDonut1))

    shoppingCartHoldAllBaseAndSubclass.printCartItems
    shoppingCartHoldVanillaDonutOnly.printCartItems



  }

}
