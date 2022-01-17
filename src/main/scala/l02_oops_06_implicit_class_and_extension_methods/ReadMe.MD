# Implicit classes 

1. An implicit class is a class marked with the implicit keyword.

2. They must be defined inside of another trait/class/object.
   ```
    object Helpers {
       implicit class RichInt(x: Int) // OK!
    }
   ```
   
3. They may only take one non-implicit argument in their constructor.  
   
   ```$xslt
   implicit class RichDate(date: java.util.Date)
   ```

4. There may not be any method, member or object in scope with the same name as the implicit class.

  ```$xslt
     object Bar
     implicit class Bar(x: Int) // BAD!
     
     val x = 5
     implicit class x(y: Int) // BAD!
     
     implicit case class Baz(x: Int) // BAD!
  ``` 

# Pointers 
1. It's a good practice to encapsulate Implicit Classes into an object which can later be injected or referenced.