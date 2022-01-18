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
         val p1 =new Parking[Motorcycle](new Motorcycle())
      ```
   1. To park car jeep or coupe
      ```$xslt
         val p2 =new Parking[Car](new Car())
         val p3 = new Parking[Car](new Jeep())
      ```
        
   1. So, what happens when we try to park a Car in a “only Motorcycle” Parking lot? - CTE
      ```$xslt
       //new Parking[Motorcycle](new Car())
      ```
        
        
3. `class ParkInPair[A](val place1: A, val place2: A) `
   
   **The compiler will evaluate the type of both parameters,**
   **if they were the same type,it would be easy, however since they are not,**
   **it searches for the nearest common supertype.**
   
   
   ```$xslt
    val p4 = new ParkInPair(new Car(), new Motorcycle())
    
    What is the type of above ?
    ANS - Vehicle      
    val p4: ParkInPair[Vehicle] = new ParkInPair(new Car(), new Motorcycle())               
   ``` 
## Upper type bounds   

1. To Park Only Vehicles 
   
   `class ParkingOnlyVehicles[A <: Vehicle](val place: A)`
   
   **ParkingOnlyVehicles[A <: Vehicle] means that the A type must be type or subtype of Vehicle**
   
   ```$xslt
      val p5: ParkingOnlyVehicles[Vehicle] =new ParkingOnlyVehicles[Vehicle](new Car())
      val p6: ParkingOnlyVehicles[Car]     =new ParkingOnlyVehicles[Car](new Car())
      val p7: ParkingOnlyVehicles[Jeep]    =new ParkingOnlyVehicles[Jeep](new Jeep())
      val p8: ParkingOnlyVehicles[Motorcycle]    =new ParkingOnlyVehicles[Motorcycle](new Motorcycle())
   
      new Parking[Vegetable](new Vegetable())
      //new ParkingOnlyVehicles[Vegetable](new Vegetable()) //CTE/RTE
   ```
## Lower type bounds

1. To Park Only Cars   

    `class ParkingOnlyCars[A >: Jeep](val place: A)`   
    
    **ParkingOnlyCars[A >: Jeep] means that A must be Jeep or higher from Jeep, being Jeep the frontier (bound).**
    
    ```$xslt
        val p9 : ParkingOnlyCars[Jeep]    = new ParkingOnlyCars[Jeep]( new Jeep())
        val p10: ParkingOnlyCars[Car]     = new ParkingOnlyCars[Car]( new Car())
        val p11: ParkingOnlyCars[Vehicle] = new ParkingOnlyCars[Vehicle](new Car())
        //new ParkingOnlyCars[MiniJeep](new MiniJeep()) //CTE/RTE
    ```

## Upper and Lower Bounds   
   
1.  `class ParkingNew[A >: Bicycle <: Vehicle](val plaza: A)`
    
    **ParkingNew[A >: Bicycle <: Vehicle] mean A must be subtypes of Vehicles, above Tricycle[Vehicles , Bicycle]. A cant be Car or MotorCycle**
    
    ```$xslt
         val p12 :ParkingNew[Bicycle] = new ParkingNew[Bicycle](new Bicycle())
         val p13 :ParkingNew[Vehicle] = new ParkingNew[Vehicle](new Car())
         val p14 :ParkingNew[Vehicle] = new ParkingNew[Vehicle](new Coupe())
         
         val p15  = new ParkingNew[Bicycle](new Tricycle()) //Being Tricycle a subtype of Bicycle, the example has searched for a supertype
         which matches with the frontiers and it has found it. Because of Liskov there where you can use a Bicycle,
         you should be able to use a Tricycle as well.
         val p15 :ParkingNew[Bicycle] = new ParkingNew[Bicycle](new Tricycle())
    ```

### If you are using covarient A  Like +A
    **Covariant type A occurs in contravariant position in type A of value element**
    ```$xslt
      class Parking[+A] {
       def parkIt(element: A): Parking[A] = new Parking(element)  <-- Covariant type A occurs in contravariant position
                                                                      in type A of value element
      }
      
      To resolve above CTE -> We could use the covariant A type to generate the limit of the lower type bound from B and 
      let B be the one who types everything. Tada!!
      
      class Parking[+A] {
        def parkIt[B >: A](element: B): Parking[B] = new Parking(element)
      }
    ```  
    
### Another use for scala type bounds is Use-site variance

   ```$xslt
      class Parking[A](val place: A){
        def dosomething123(p1: Parking[_ <: Jeep]) {}
        def dosomethingABC(p1: Parking[Vehicle]) {}
      }

      dosomething123(new Parking(new Jeep))
      //dosomething123(new Parking(new Car)) //CTE



      1. var p1 = new Parking(new Car)     //p1 is Parking[Car] , not Parking[Vehicle] 
         dosomethingABC(p1)
       ***********************************************
          <console>:12: error: type mismatch;
           found : Parking[Car]
           required: Parking[Vehicle]
           Note: Car <: Vehicle, but class Parking is invariant in type A.
           You may wish to define A as +A instead. (SLS 4.5)
           dosomethingABC(p1)
                       ^ 
       ***********************************************
      
      2.dosomething(new Parking(new Car)) /*The type inference will look for a
        matching type: it will rise the type of Car to Vehicle, creating a Parking[Vehicle]. 
        Making everything work again.
       */
   ```    