# Constructor 
  
   ```$xslt
    class Calc (val aHasDefault:Int = 10 , b:Double , sHasDefault:String = "default"){
    }
   ```

# Auxillary Constructor

   ```$xslt
       class Calc (val aHasDefault:Int = 10 , b:Double , sHasDefault:String = "default"){
         
          def this(){
            this(99,88.88,"Hello Scala")
            println("I came into Auxiliary constructor with 0 paramters")
          }

          def this(a:Int){
            this(a,88.88,"Hello Scala")
            println("I came into Auxiliary constructor with 1 paramters that has a:Int")
          }

       }
   ```
