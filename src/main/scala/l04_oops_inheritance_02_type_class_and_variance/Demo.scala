package l04_oops_inheritance_02_type_class_and_variance
abstract class Donut(name: String) {
  def printName: Unit
}

case class VanillaDonut(name: String) extends Donut(name) {
  override def printName: Unit = println(name)
}

case class GlazedDonut(name: String) extends Donut(name) {
  override def printName: Unit = println(name)
}

case class ShoppingCartHoldAllDonutTypes[D <: Donut](donuts: Seq[D]){
  def printCartItems: Unit = donuts.foreach(_.printName)
}

class ShoppingCartCovarient[+D <: Donut](donuts: Seq[D]) {
  def printCartItems: Unit = donuts.foreach(_.printName)
}

class ShoppingCartContravarient[-D <: Donut](donuts: Seq[D]) {
  def printCartItems: Unit = donuts.foreach(_.printName)
}



object Demo {

  def main(args: Array[String]): Unit = {
    val vanillaDonut1: VanillaDonut = VanillaDonut("Vanilla Donut1")
    val glazedDonut1:  GlazedDonut = GlazedDonut("Glazed Donut1")
    val vanillaDonut2: Donut = VanillaDonut("Vanilla Donut2")
    val glazedDonut2:  Donut = GlazedDonut("Glazed Donut2")
    val shoppingCart1: ShoppingCartHoldAllDonutTypes[Donut] = new ShoppingCartHoldAllDonutTypes[Donut](Seq[Donut](vanillaDonut1, glazedDonut1, vanillaDonut2, glazedDonut2))

    val shoppingCart2: ShoppingCartHoldAllDonutTypes[VanillaDonut] = new ShoppingCartHoldAllDonutTypes[VanillaDonut](Seq[VanillaDonut](vanillaDonut1))

    shoppingCart1.printCartItems
    shoppingCart2.printCartItems
    /*
     Covariance - If i add glazedDonut in seq , I will get CTE
     The Shopping cart should be type of Donut but must hold only VanillaDonut.
     */
    println("########### Covariance ###########")
    val shoppingCartForVanillaDonut : ShoppingCartCovarient[Donut] =new ShoppingCartCovarient[VanillaDonut](Seq(vanillaDonut1))
    shoppingCartForVanillaDonut.printCartItems
    /*
     Contra variance - If i add glazedDonut in seq , I will get CTE
     The Shopping cart should be type of VanillaDonut but must hold  VanillaDonut and Donut types.
     */
    println("########### Contravarient ###########")
    val shoppingCartForContravarient: ShoppingCartContravarient[VanillaDonut] = new ShoppingCartContravarient[Donut](Seq(vanillaDonut1,glazedDonut1, vanillaDonut2, glazedDonut2 ))
    shoppingCartForContravarient.printCartItems

  }

}
