package l04_oops_inheritance_02_type_class_and_variance


abstract class DonutContra(name: String) {
  def printName: Unit
}

case class VanillaDonutContra(name: String) extends DonutContra(name) {
  override def printName: Unit = println(name)
}

case class GlazedDonutContra(name: String) extends DonutContra(name) {
  override def printName: Unit = println(name)
}

class ShoppingCartContra[-D <: DonutContra](donuts: Seq[D]) {
  def printCartItems: Unit = donuts.foreach(_.printName)
}

object ContraVarientDemo {
  def main(args: Array[String]): Unit = {
    val vanillaDonut1: VanillaDonutContra = VanillaDonutContra("Vanilla Donut1")
    val glazedDonut1:  GlazedDonutContra = GlazedDonutContra("Glazed Donut1")
    val vanillaDonut2: DonutContra = VanillaDonutContra("Vanilla Donut2")
    val glazedDonut2:  GlazedDonutContra = GlazedDonutContra("Glazed Donut2")

    /*
     Contra variance - If i add glazedDonut in seq , I will get CTE
     The Shopping cart should be type of VanillaDonut but must hold  VanillaDonut and Donut types.
     */
//    println("########### Contravarient ###########")
//    val shoppingCartForContravarient: ShoppingCartContravarient[VanillaDonut] = new ShoppingCartContravarient[Donut](Seq(vanillaDonut1,glazedDonut1, vanillaDonut2, glazedDonut2 ))
//    shoppingCartForContravarient.printCartItems
  }
}
