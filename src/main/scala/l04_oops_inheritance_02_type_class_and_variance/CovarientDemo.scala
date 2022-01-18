//package l04_oops_inheritance_02_type_class_and_variance
//
//abstract class DonutCovarient(name: String, price:Int) {
//  def printName: Unit
//}
//
//case class VanillaDonutCovarient(name: String, price:Int) extends DonutCovarient(name, price) {
//  override def printName: Unit = println(f"$name, $price")
//}
//
//case class GlazedDonutCovarient(name: String, price:Int) extends DonutCovarient(name, price) {
//  override def printName: Unit = println(f"$name, $price")
//}
//
//case class ItemCovarient( val item:DonutCovarient, qty:Int){
//  def printDetails: Unit = println(f"$item, $qty")
//}
//case class ShoppingCartCovarient[+D :< DonutCovarient](donuts: Seq(i)) {
//  def printCartItems: Unit = donuts.foreach(_.printDetails)
//}
//
//class Animal[T](val animial:T)
//
//class Dog
//class Puppy extends Dog
//
//class AnimalCarer(val dog:Animal[Dog])
//
//object CovarientDemo {
//  def main(args: Array[String]): Unit = {
//    val vanillaDonut1: VanillaDonutCovarient = VanillaDonutCovarient("Vanilla Donut1", 10)
//    val glazedDonut1:  GlazedDonutCovarient = GlazedDonutCovarient("Glazed Donut1", 20)
//    val vanillaDonut2: DonutCovarient = VanillaDonutCovarient("Vanilla Donut2" ,15)
//    val glazedDonut2:  DonutCovarient = GlazedDonutCovarient("Glazed Donut2", 25)
//
//    val it1:ItemCovarient = ItemCovarient(vanillaDonut1 , 2)
//    val it2:ItemCovarient[DonutCovarient] = ItemCovarient[GlazedDonutCovarient](glazedDonut1 ,2)
//    val it3:ItemCovarient[DonutCovarient] = ItemCovarient[DonutCovarient](vanillaDonut2,5)
//    val it4:ItemCovarient[DonutCovarient] = ItemCovarient[DonutCovarient](glazedDonut2, 5)
//
//
//    val seqObject:Seq[ ItemCovarient[DonutCovarient] ] = Seq[ItemCovarient](
//        it1,it2,it3,it4
//    )
//    val puppy = new Puppy
//    val dog = new Dog
//
//    val puppyAnimal:Animal[Puppy] = new Animal[Puppy](puppy)
//    val dogAnimal:Animal[Dog] = new Animal[Dog](dog)
//
//    val dogCarer = new AnimalCarer(dogAnimal)
//    val puppyCarer = new AnimalCarer(puppyAnimal)
//
//    println("Done.")
//
//    /*
//     Covariance - If i add glazedDonut in seq , I will get CTE
//     The Shopping cart should be type of Donut but must hold only VanillaDonut.
//     */
////    println("########### Covariance ###########")
////    val shoppingCartForVanillaDonut : ShoppingCartCovarient[Donut] =new ShoppingCartCovarient[VanillaDonut](Seq(vanillaDonut1))
////    shoppingCartForVanillaDonut.printCartItems
//  }
//
//}
