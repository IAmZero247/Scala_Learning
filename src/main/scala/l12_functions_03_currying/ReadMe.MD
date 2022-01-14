# Currying

1. Currying in Scala is simply a technique or a process of transforming a function.
   ```$xslt
     def m1(mm: Int,dd: Int ,yyyy:Int , name:String): String  = f"$name=[$mm/$dd/$yyyy]"
     def m1curried(mm:Int)(dd:Int)(yyyy:Int)(name:String):String = f"$name=[$mm/$dd/$yyyy]";
     
   
   
     def m2:(Int, Int , Int ,String )=> String = (mm,dd,yyyy,name) => f"$name=[$mm/$dd/$yyyy]"
     def m2curried: Int => Int => Int => String => String = mm=>dd=>yyyy=>name => f"$name=[$mm/$dd/$yyyy]"
     
     PS -> 1st : 2nd = 3rd
     1st -> name   [m2curried]
     2nd -> input and output type  [Int => Int => Int => String => String ]
     3rd -> params and body  [mm=>dd=>yyyy=>name => {...}] 
     

   ```