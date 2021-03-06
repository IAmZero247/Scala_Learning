# Case Class 
1. A case class is similar to any other classes except that it also creates the Companion Object.
2.  `case class className(parameters)`

    ```$xslt
    case class Person (name:String, age:Int)

    ```
3. Scala Compiler affix a method with the name of the class having identical number of parameters as defined in the class definition,
   because of that you can create objects of the Case Class even in the absence of the keyword new.
   
   ```$xslt
   var p1 = Person("Azam", 20)
   ``` 
4. Scala compiler affixes val or var for all the parameters of constructor 
5. case class’s constructor parameters will turn out to be class members
6. The Scala compiler also appends a copy() method to case class that is utilized to create a duplicate of the same object with changing 
   some parameters or without altering them. 
   
   ```$xslt
   val p1 = Person("Nidhi", 23)
   val p2 = p1.copy()
   val p2 = p1.copy(age = 24)
             
   ```   
7. Scala Compiler adds toString method, equals method, hashcode method ,companion object with apply and unapply methods, for that reason you don’t 
   need new keyword to construct object of a Case class. 
   
# Case Object 
1. It is serializable.
2. It has a by default hashCode implementation.    