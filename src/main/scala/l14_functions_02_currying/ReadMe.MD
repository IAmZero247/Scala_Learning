# Currying

1. Currying in Scala is simply a technique or a process of transforming a function.
   ```$xslt
   def function name(argument1) = (argument2) => operation
   
   
   
   
   def add(x: Int, y: Int): Int  = x + y;
   
   def addcurried1(x:Int)(y:Int):Int =x+y;
   
   def addcurried2(x:Int) = (y:Int) => x+y

   ```