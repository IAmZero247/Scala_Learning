#  Self typed annotation 

   ```$xslt
    trait A {
      val l = "A"
    }
    
    trait B {
      this: A =>
      val c = "B"
      val lc = l + c
    }
    
   trait C {
     this: B =>
     val t = "C"
     //val lct = l + c + t // compilation error(cannot access l)
     val lct = lc+t
   }

    //Invocation 
    val obj = new C with A and with B
    println(obj.c)
    println(obj.lc)
    println(obj.t)
   ```
## Self typed annotation vs Inheritance

 *We achieve the same functionality via inheritance.But there are some problems with using inheritance*
 
1. Subclassing will leaks the functionality of super class
2. Inheritance breaks encapsulations (Its often said that :))

   ```$xslt
    trait A {
      val l = "AAA"
    }
    
    trait B extends A {
      val c = "B"
      val lc = l + c
    }
    
    trait C extends B {
      val t = "C"
      val lct = l + c + t // no compilation error
    }
   ```
   *In here by extending B trait from C, C can access Lambda trait members (A, Self typed annotation prevents that.).*
   *Thats why we say’s inheritance leaks the encapsulation.*