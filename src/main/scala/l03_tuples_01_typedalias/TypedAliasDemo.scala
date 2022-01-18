package l03_tuples_01_typedalias
case class Donut(name: String, price: Double, productCode: Option[Long] = None)
/*
 *case class ShoppingCartItemWithCase(donut: Donut, quantity: Int)
 */

object TypedAliasDemo {

  type CartItemWithTuple[Donut, Int] = Tuple2[Donut, Int]

  def printCartItem(i: CartItemWithTuple[Donut, Int]): Unit ={
    println(s"cartItem = $i")
    println(s"cartItem first value = ${i._1}")
    println(s"cartItem second value = ${i._2}")
  }

  def calculateTotal1(shoppingCartItems: Seq[CartItemWithTuple[Donut, Int]]): Double = {
    // calculate the total cost
    var i:Double=0;

    shoppingCartItems.foreach { cartItem =>
      println(s"CartItem donut = ${cartItem._1}, quantity = ${cartItem._2}")
      i += cartItem._1.price*cartItem._2
    }
    i
  }
  /*
   *def calculateTotal2(shoppingCartItems: Seq[ShoppingCartItemWithCase]): Double = {
   *   var i:Double=0;
   *   // calculate the total cost
   *   shoppingCartItems.foreach { cartItem =>
   *     println(s"CartItem donut = ${cartItem.donut}, quantity = ${cartItem.quantity}")
   *     i += cartItem.donut.price*cartItem.quantity
   *   }
   *   i
   * }
   */
  def main(args: Array[String]): Unit = {
    val vanillaDonut: Donut = Donut("Vanilla", 1.50)
    val glazedDonut: Donut = Donut("Glazed", 2.0)
    val cartItem1 = new CartItemWithTuple(vanillaDonut, 4)
    val cartItem2 = new CartItemWithTuple(glazedDonut, 2)
    printCartItem(cartItem1)
    printCartItem(cartItem2)
    println("##################################")
    val shoppingCartItems: Seq[CartItemWithTuple[Donut, Int]] = Seq(cartItem1,cartItem2);
    print(calculateTotal1(shoppingCartItems))
  }
}
