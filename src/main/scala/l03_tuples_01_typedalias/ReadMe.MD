#  TypeAlias On Tuples
1. case class
   ```$xslt
   case class Donut(name: String, price: Double, productCode: Option[Long] = None)
   
   //Invocation
   val vanillaDonut: Donut = Donut("Vanilla", 1.50)
   val glazedDonut: Donut = Donut("Glazed", 2.0)
   ```
2a. CartItem using TypedTuple2
    
   ```$xslt
   type CartItemWithTuple[Donut, Int] = Tuple2[Donut, Int]
   def printCartItem(i: CartItemWithTuple[Donut, Int]): Unit ={
       println(s"cartItem = $i")
       println(s"cartItem first value = ${i._1}")
       println(s"cartItem second value = ${i._2}")
   }
   
   //Invocation
   val cartItem1 = new CartItemWithTuple(vanillaDonut, 4)
   val cartItem2 = new CartItemWithTuple(glazedDonut, 2)
   printCartItem(cartItem1)
   printCartItem(cartItem2)
   ```  
2b. CartItem using case class
   ```$xslt
   case class ShoppingCartItemWithCase(donut: Donut, quantity: Int)
  
   val cartItem3: ShoppingCartItemWithCase = ShoppingCartItemWithCase(Donut("Glazed Donut", 2.50), 10)

   ```    
3. Alias type as part of function parameter 
   ```$xslt
   def calculateTotal1(shoppingCartItems: Seq[CartItem[Donut, Int]]): Double = {
     // calculate the total cost
     shoppingCartItems.foreach { cartItem =>
       println(s"CartItem donut = ${cartItem._1}, quantity = ${cartItem._2}")
     }
     10 // some random total cost
   }
   
   //Invocation 
   val shoppingCartItems: Seq[CartItemWithTuple[Donut, Int]] = Seq(cartItem1,cartItem2);
   print(calculateTotal1(shoppingCartItems))
   ```