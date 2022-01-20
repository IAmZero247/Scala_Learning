package l04_oops_inheritance_03_type_class_and_variance


abstract class Donut(name: String) {
  def getName: String
}


case class VanillaDonut(name: String, price:Int) extends Donut(name) {
  override def getName: String = name
}

case class GlazedDonut(name: String, price:Int) extends Donut(name) {
  override def getName: String = name
}

class ShoppingCart[-D <: Donut](donuts: Seq[D]) {
  def printCartItems: Unit = donuts.foreach(
    i=> println(i)
  )
}


object ContraVarientDemo {
  def main(args: Array[String]): Unit = {
    val vanillaDonut: VanillaDonut = VanillaDonut("Vanilla Donut Amazing" , 2)
    vanillaDonut.getName

    val glazedDonut: Donut = GlazedDonut("Glazed Donut" ,4 )
    glazedDonut.getName


    /*
     Contra variance - If i add glazedDonut of Type GlazedDonut  in seq , I will get CTE
     The Shopping cart should be type of VanillaDonut but must hold  VanillaDonut and Donut types.
     */
    val shoppingCart: ShoppingCart[VanillaDonut] = new ShoppingCart[Donut](Seq(glazedDonut ,vanillaDonut))
    shoppingCart.printCartItems
    //Note -> the shopping cart is holding wrong donut glazedDonut.
  }
}
