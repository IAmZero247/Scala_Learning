# Traits 
1.  Traits can have abstract members(both fields and methods) as well as concrete members.
    ```$xslt
        // abstract
        var name: String
        
        // concrete
        val maxUsage = 10     
        
        // abstract
        def lang(): Unit         
        
        // concrete 
        def read() = {
          print("Reading")
        }
    ```

2.  Traits are multiple inheritance friendly.
3.  If there are multiple implementors of a given member, the implementation in the super type that is furthest to the right (in the list of super types) wins.

    ```$xslt
    trait Language {
      def lang(): Unit
    }
    
    trait Functional extends Language {
      override def lang() {
        println("Functional")
      }
    }
    
    trait ObjectOriented extends Language {
      override def lang() {
        println("ObjectOriented")
      }
    }
    
    //Multiple Inheritance
    class Scala extends Functional with ObjectOriented
    new Scala().lang() // output --> ObjectOriented
    
    class Scala extends ObjectOriented with Functional
    new Scala().lang() // output --> Functional
    ```

## Traits va Abstract Class
1.  Traits doesn’t comes with constructor. That is the main difference between traits and abstract classes.

    ```$xslt
     abstract class Language(name: String)
    ```