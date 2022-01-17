#  Inheritance with Case Class

Note -> We dont need to use create companion object when we use case class
##  Implementation Demo

1. Base Class
  ```$xslt
    abstract class Donut(name: String) {
       def printName: Unit
    }

  ```
2. Subclass 
  ```$xslt
   case class VanillaDonut(name: String) extends Donut(name) {
  
     override def printName: Unit = println(name)
  
   }
  
  

  #########################################################
  case class GlazedDonut(name: String) extends Donut(name) {
  
     override def printName: Unit = println(name)
  
  }
  
  ```

3. Invocation 
  ```$xslt
  val vanillaDonut: Donut = VanillaDonut("Vanilla Donut")
  vanillaDonut.printName
  
  val glazedDonut: Donut = GlazedDonut("Glazed Donut")
  glazedDonut.printName

  ```