# Typed Class Ex 
# With the notation [D <: Donut], we are restricting only Donut types
1. Donut Classes

   ```$xslt
    abstract class Donut(name: String) {
       def printName: Unit
    }
     
    case class VanillaDonut(name: String) extends Donut(name) {
      override def printName: Unit = println(name)
    }
   
    case class GlazedDonut(name: String) extends Donut(name) {
      override def printName: Unit = println(name)
    }
    
    //Invocation
    val vanillaDonut: Donut = VanillaDonut("Vanilla Donut")
    
    val glazedDonut: Donut = GlazedDonut("Glazed Donut")
   ```
 
2. Type Class For Shopping Cart to hold Donuts [Holds All Subclasses]
   ```$xslt
   case class ShoppingCart[D <: Donut](donuts: Seq[D]){
   def printCartItems: Unit = donuts.foreach(_.printName)
   }
   
   //Invocation 
   val shoppingCart: ShoppingCart[Donut] = new ShoppingCart(Seq[Donut](vanillaDonut, glazedDonut))
   shoppingCart.printCartItems
   ```   