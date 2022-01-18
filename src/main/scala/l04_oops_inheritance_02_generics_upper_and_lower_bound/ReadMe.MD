# Generic Type


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
        
        
3. `class ParkInPair[A](val place1: A, val place2: A) `
   
   **The compiler will evaluate the type of both parameters,**
   **if they were the same type,it would be easy, however since they are not,**
   **it searches for the nearest common supertype.**
   
   
   ```$xslt
    val p4: ParkInPair[Vehicle] = new ParkInPair(new Car, new Motorcycle)
    
    What is the type of above ?
    ANS - Vehicle      
                    
   ``` 
## Upper type bounds   

1. To Park Only Vehicles 
   
   `class ParkingOnlyVehicles[A <: Vehicle](val place: A)`
   
   **ParkingOnlyVehicles[A <: Vehicle] means that the A type must be type or subtype of Vehicle**
   
   ```$xslt
       new ParkingOnlyVehicles[Vehicle](new Car())
       new ParkingOnlyVehicles[Car](new Car())
       new ParkingOnlyVehicles[Jeep](new Jeep())
       new ParkingOnlyVehicles[Motorcycle](new Motorcycle())
   
       new Parking[Vegetable](new Vegetable)
       //new ParkingOnlyVehicles[Vegetable](new Vegetable) //CTE/RTE
   ```
2. To Park Only Car 
    
    `class ParkingOnlyCars[A >: Jeep](val place: A)`   
    
    **ParkingOnlyCars[A >: Jeep] means that A must be Jeep or higher from Jeep, being Jeep the frontier (bound).**
    
    ```$xslt
        new ParkingOnlyCars[Jeep]( new Jeep)
        new ParkingOnlyCars[Car]( new Car)
        new ParkingOnlyCars[Vehicle](new Car)
        //new ParkingOnlyCars[MiniJeep](new MiniJeep) //CTE/RTE
    ```
3.  `class ParkingNew[A >: Bicycle <: Vehicle](val plaza: A)`
    
    **ParkingNew[A >: Bicycle <: Vehicle] mean A must be subtypes of Vehicles, above Tricycle[Vehicles , Bicycle]. A cant be Car or MotorCycle**
    
    ```$xslt
         new ParkingNew[Bicycle](new Bicycle)
         new ParkingNew[Vehicle](new Car)
         new ParkingNew[Vehicle](new Coupe)
    
         
         new ParkingNew[Bicycle](new Tricycle) //Being Tricycle a subtype of Bicycle, the example has searched for a supertype
         which matches with the frontiers and it has found it. Because of Liskov there where you can use a Bicycle, you should be able to use a Tricycle as well.
    ```