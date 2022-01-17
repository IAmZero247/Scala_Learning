# Inheritance
1. Only the primary constructor can pass parameters to the base constructor
2. Extend normal , abstract or trait.
3. Can extend only one class.

###  Note: Like Java, In Scala, an abstract class can also contain a constructor and a constructor of an abstract class is called when an instance of a inherited class is created.

## Implementation Demo 
1. Base Class
  ```$xslt
    abstract class Donut(name: String) {
       def printName: Unit
    }

  ```
2. Subclass 
  ```$xslt
  class VanillaDonut(name: String) extends Donut(name) {
  
     override def printName: Unit = println(name)
  
   }
  
  object VanillaDonut {
  
     def apply(name: String): Donut = {
       new VanillaDonut(name)
     }
  }

  #########################################################
  class GlazedDonut(name: String) extends Donut(name) {
  
     override def printName: Unit = println(name)
  
  }
  
  object GlazedDonut {
  
     def apply(name: String): Donut = {
       new GlazedDonut(name)
     }
  
  }
  ```
3. Invocation 
  ```$xslt
  val vanillaDonut: Donut = VanillaDonut("Vanilla Donut")
  vanillaDonut.printName
  
  val glazedDonut: Donut = GlazedDonut("Glazed Donut")
  glazedDonut.printName

  ```