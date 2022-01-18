# 


1. Class Definition
   ```$xslt
     trait Vehicle
     class Car extends Vehicle
     class Jeep extends Car
     class MiniJeep extends Jeep
     class Coupe extends Car
     class Motorcycle extends Vehicle
     class Bicycle extends Vehicle
     class Tricycle extends Bicycle
     class Vegetable
   ```
2. `class Parking[A](val place: A) `

   1. To park motorcycle
      ```$xslt
         val p1 =new Parking[Motorcycle](new Motorcycle)
      ```
   1. To park car jeep or coupe
      ```$xslt
         val p2 =new Parking[Car](new Car)
         val p3 = new Parking[Car](new Jeep)
      ```
        
   1. So, what happens when we try to park a Car in a “only Motorcycle” Parking lot? - CTE
      ```$xslt
       new Parking[Motorcycle](new Car)
      ```
        
        
3. `class ParkInPair[A](val place1: A, val place2: A)`
   ** The compiler will evaluate the type of both parameters,**
   **if they were the same type,it would be easy, however since they are not,**
   **it searches for the nearest common supertype.**
   
   
   ```$xslt
    val p4: ParkInPair[Vehicle] = new ParkInPair(new Car, new Motorcycle)
    
    What is the type of above ?
    ANS - Vehicle      
                    
   ```     