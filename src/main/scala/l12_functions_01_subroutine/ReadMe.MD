# Subroutine 

1. In Scala, a user can create function with or without = (equal) operator.

2. If the user uses it, the function will return the desired value.
   ```$xslt
     def myfun1normal( a:Int, b: String):String ={
         println(b+ a)
         return b+a+"!.";
       }
   ```
3 .If he doesn’t use it, the function will not return any value and will work like a subroutine.
   
   ```$xslt
      /*
       Below fun always return Unit
       */
      def myfun2subroutine( a:Int, b: String) {
        println(b+ a)
        return  b+a+"!.";  //-this return wont work. subroutine.
      }
   ```