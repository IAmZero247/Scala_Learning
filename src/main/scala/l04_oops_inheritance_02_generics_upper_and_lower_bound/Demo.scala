package l04_oops_inheritance_02_generics_upper_and_lower_bound

trait Vehicle
class Car extends Vehicle
class Jeep extends Car
class MiniJeep extends Jeep
class Coupe extends Car
class Motorcycle extends Vehicle
class Bicycle extends Vehicle
class Tricycle extends Bicycle
class Vegetable
class Parking[A](val place: A)
class ParkInPair[A](val place1: A, val place2: A)
class ParkingOnlyVehicles[A <: Vehicle](val place: A)
//ParkingOnlyVehicles[A <: Vehicle] means that the A type must be type or subtype of Vehicle
class ParkingOnlyCars[A >: Jeep](val place: A)
//ParkingOnlyCars[A >: Jeep] means that A must be Jeep or higher from Jeep, being Jeep the frontier (bound).
class ParkingNew[A >: Bicycle <: Vehicle](val plaza: A)
//ParkingNew[A >: Bicycle <: Vehicle] mean A must be subtypes of Vehicles, above Tricycle[Vehicles , Bicycle]. A cant be Car or MotorCycle
object Demo {
  def main(args: Array[String]): Unit = {
    //1. to park motorcycle
    val p1 =new Parking[Motorcycle](new Motorcycle)
    //2. to park car jeep or coupe
    val p2 =new Parking[Car](new Car)
    val p3 = new Parking[Car](new Jeep)
    //3. So, what happens when we try to park a Car in a “only Motorcycle” Parking lot?
    //CTE
    //new Parking[Motorcycle](new Car)
    //4 WHAT IS THE TYPE OF BELOW ?
    /*
    The compiler will evaluate the type of both parameters, if they were the same type,
    it would be easy, however since they are not, it searches for the nearest common supertype.
     ANS - VEHICLE
     */
    val p4: ParkInPair[Vehicle] = new ParkInPair(new Car, new Motorcycle)
    //Upper type bounds
    val p5: ParkingOnlyVehicles[Vehicle] =new ParkingOnlyVehicles[Vehicle](new Car())
    val p6: ParkingOnlyVehicles[Car]     =new ParkingOnlyVehicles[Car](new Car())
    val p7: ParkingOnlyVehicles[Jeep]    =new ParkingOnlyVehicles[Jeep](new Jeep())
    val p8: ParkingOnlyVehicles[Motorcycle]    =new ParkingOnlyVehicles[Motorcycle](new Motorcycle())

    new Parking[Vegetable](new Vegetable)
    //new ParkingOnlyVehicles[Vegetable](new Vegetable) //Run Time Error

   //Lower Type Bound
    val p9 : ParkingOnlyCars[Jeep]    = new ParkingOnlyCars[Jeep]( new Jeep)
    val p10: ParkingOnlyCars[Car]     = new ParkingOnlyCars[Car]( new Car)
    val p11: ParkingOnlyCars[Vehicle] = new ParkingOnlyCars[Vehicle](new Car)
    //new ParkingOnlyCars[MiniJeep](new MiniJeep)

    //Combination
    val p12 :ParkingNew[Bicycle] = new ParkingNew[Bicycle](new Bicycle)
    val p13 :ParkingNew[Vehicle] = new ParkingNew[Vehicle](new Car)
    val p14 :ParkingNew[Vehicle] = new ParkingNew[Vehicle](new Coupe)
    val p15  = new ParkingNew[Bicycle](new Tricycle)
    //val p15 :ParkingNew[Bicycle] = new ParkingNew[Bicycle](new Tricycle)
  }
}
