# Dependency Injection 
https://coderwall.com/p/t_rapw/cake-pattern-in-scala-self-type-annotations-explicitly-typed-self-references-explained

1. Trait 
   ```$xslt
    trait FooAble {
      def foo():Any = ???
    }
    trait BazAble{
      def baz():Any = ???
    }
   ```
2. Implemtation And Invocation in Java Extend Way
   
   ```$xslt
     class BarUsingFooAbleJavaWay extends FooAble {
       override def foo() = "foo is implemented in java way"
       def bar() = "bar calls foo: " + foo()
     }
   
     //First Invocation 
     val barWithFoo = new BarUsingFooAbleJavaWay
     println(barWithFoo.bar())
   
     //Console
     bar calls foo: foo is implemented in java way
   ```  
3. Implementation And Invocation Abstract Class
    - Inheritance breaks encapsulations
    - Tight Implementation

   ```$xslt
     
     class MyFooAble() extends FooAble {
       override def foo() = "foo impl here done"
     }

     abstract class BarUsingFooAble {
       def bar() = "bar calls foo: " + foo.foo()
       def foo:FooAble //abstract
     }
   
     //Second Invocation 
     val fooable:FooAble = new MyFooAble()
     //val fooable = new FooAble {} /*Error No Implementation */
     val barWithFoo = new BarUsingFooAble{ //Abstact class got implemented here - Overriding
       def foo: FooAble = fooable
     }
     println(barWithFoo.bar())  
     //Console
     bar calls foo: foo impl here done  
   ```  

4. Implementation And Invocation Self and With [Explicitly typed self reference] [DI]  *Prefered*
   *The self type annotation is just declaring that this type needs to extend / implement the annotated type, but it doesn't extend it yet. It lets you "inject" the extension, thus supports dependency injection.*
   
   1. Make the implementation a Trait (in scala a trait only can be mixed)
   ```$xslt
      trait MyFooAbleImplInTrait extends FooAble {
       override def foo() = "foo impl with this and trait mixing"
      }
   ```
   2. Use this with Parent Trait as below
   ```$xslt
      class BarUsingFooAble {
        this: FooAble => //see note #1
        def bar() = "bar calls foo: " + foo() //see note #2
      }
   
      Third Invocation
      val barWithFoo = new BarUsingFooAble() with MyFooAbleImplInTrait{}
      println(barWithFoo.bar())
      //Console
      bar calls foo: foo impl with this and trait mixing
   ```  

5. Multiple Injections [Cake Pattern of DI]

   1. Make the implementation a Trait (in scala a trait only can be mixed)
      ```$xslt
         trait MyFooAbleImplInTrait extends FooAble {
           override def foo() = "foo implementaion"
         }
         trait MyBazAbleImplInTrait extends BazAble {
           override def baz():Any = "baz implemenation"
         }
        class BarUsingFooAbleAndBazAble {
          this: FooAble with BazAble =>
          def bar() = s"bar calls foo: ${foo()} and baz: ${baz()}"
        }
      
        Invocation
        val barWithFooAndBaz = new BarUsingFooAbleAndBazAble() with MyFooAbleImplInTrait with  MyBazAbleImplInTrait
        println(barWithFooAndBaz.bar())
        //Cosole
        bar calls foo: foo implementaion and baz: baz implemenation
      ``` 
6. Consturctor Injections For Above   

   ```$xslt
    class  BarUsingFooAbleConstructorInjection (dep:FooAble with BazAble) {
      def bar() = s"bar calls foo: ${dep.foo()} and baz: ${dep.baz()}"
    }
   
    Invocation 
    val barWithFooAndBaz = new BarUsingFooAbleConstructorInjection(new MyFooAbleImplInTrait with MyBazAbleImplInTrait)
    println(barWithFooAndBaz.bar())
    //Cosole
    bar calls foo: foo implementaion and baz: baz implemenation
   ```       