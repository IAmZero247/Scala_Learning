# Functions
1. Functions are majorly defined by using a def or a val, def‘s evaluate each time while val‘s evaluate once


   ```$xslt
   val dummyFunctionVal : Int => Int = {
     println(new Date())
     num => num
   }
   
   def dummyFunctionDef(number : Int) : Int = {
     println(new Date())
     number
   }
   
   println(dummyFunctionVal(10)) // prints out the date and then the result :10
   println(dummyFunctionVal(10)) // doesn't print out the date and just returns 10
   
   println(dummyFunctionDef(10)) // prints out the date and then the result :10
   println(dummyFunctionDef(10)) // prints out the date and then the result :10
   ```
1. When we define a function with def, we call it a “method”. These need to be defined within an object or class. 
   They also have an implicit reference to the class instance in which we defined it. They are technically not values and do not have a type.
   ```$xslt
   def getNameLengthDef(name : String) : Int = name.length
   def multiplyByTwoDef(number : Int) : Int = number * 2
   
   getNameLengthDef.andThen(multiplyByTwoDef) // doesn't compile
   ```
1. When we define a function with val, we call it a “function value”. These are specialized forms of the built-in 
   Scala class FunctionN, where N can range from 0 to 22.
   These functions have some extra methods defined on them, such as andThen and compose 
   
   ```$xslt
   val getNameLengthVal : String =>  Int = name => name.length
   val multiplyByTwoVal : Int => Int = num => num * 2
   
   getNameLengthVal.andThen(multiplyByTwoVal) // compiles
   ```  
1. Here’s an example of converting a method to a function value:
   ```$xslt
    val getNameLengthDefFnValue = getNameLengthDef _
    val multiplyByTwoDefFnValue = multiplyByTwoDef _ 
    
    getNameLengthDefFnValue.andThen(multiplyByTwoDefFnValue) // comp  
   ```
    