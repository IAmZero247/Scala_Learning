#  Covariance

### What if my Type class expects only one child class out of 2 ?

### ShoppingCart of type VanillaDonut? You should get a compiler error for a ShoppingCart of having a sequence holding type VanillaDonut:

### We've enabled covariance of type Donuts using the notation [+D <: Donut]

     ```
     class ShoppingCart[+D <: Donut](donuts: Seq[D]) {
      def printCartItems: Unit = donuts.foreach(_.printName)
     }

     val shoppingCart: ShoppingCart[Donut] = new ShoppingCart[VanillaDonut](Seq(vanillaDonut))
     shoppingCart2.printCartItems

     ```