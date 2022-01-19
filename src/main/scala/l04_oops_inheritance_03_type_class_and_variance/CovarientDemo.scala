package l04_oops_inheritance_02_type_class_and_variance

abstract class DonutCovarient(name: String, price:Int) {
  def printName(): Unit
  def getPrice():Int
  def details(): String
}

case class VanillaDonutCovarient(name: String, price:Int) extends DonutCovarient(name, price) {
  override def printName(): Unit = print(f"$name,price=$price")
  override def details(): String = f"$name,price=$price"
  override def getPrice():Int = price
}

case class GlazedDonutCovarient(name: String, price:Int) extends DonutCovarient(name, price) {
  override def printName(): Unit = print(f"$name,price=$price")
  override def details(): String = f"$name,price=$price"
  override def getPrice():Int = price
}

//class ShoppingCart[D <: DonutCovarient](donuts: Seq[D]) {
//  def printCartItems: Unit = donuts.foreach(_.printName)
//}

case class ItemCovarient[+D <: DonutCovarient]( val item:D, qty:Int){
  def printDetails: Unit = println(f"item=${item.details()},qty=$qty")
}

//[D <:  DonutCovarient]
class ShoppingCartCovarient[+D <:  DonutCovarient](donuts: Seq[ItemCovarient[D]]) {
  val li=donuts
  def getTotalPrice() ={
    var total:Int=0;
    li.foreach(
      //Ideal case - I need a pattern match here to get subtype
      i => {total =  total +(i.item.getPrice()*i.qty)}
    )
    total;
  }
}
/*
 * //Covariance in Short
 * class Animal[+T](val animial:T)
 *
 * Above we declared covarient variance
 *
 * class Cat
 * class Kitten extends Cat
 * class AnimalHome(val cat:Animal[Cat])
 *
 * val cat = new Cat
 * val kitten = new Kitten
 * val catAsAnimal:Animal[Cat] = new Animal[Cat](cat)
 * val kittenAsAnimal:Animal[Kitten] = new Animal[Kitten](kitten)
 *
 * val catHome = new AnimalHome(catAsAnimal)
 * val kittenHome = new AnimalHome(kittenAsAnimal) //Complies properly cz of +T
 */
object CovarientDemo {


  def main(args: Array[String]): Unit = {
    val vanillaDonutType: VanillaDonutCovarient = VanillaDonutCovarient("Amazing Vanilla Donut", 10)
    val glazedDonutType:  GlazedDonutCovarient = GlazedDonutCovarient("Amazing Glazed Donut", 20)
    val donutType1: DonutCovarient = VanillaDonutCovarient("Vanilla Donut" ,15)
    val donutType2: DonutCovarient = GlazedDonutCovarient("Glazed Donut", 25)




    val it1:ItemCovarient[VanillaDonutCovarient]=  ItemCovarient(vanillaDonutType , 2)
    //it1.printDetails
    val it2:ItemCovarient[GlazedDonutCovarient] = ItemCovarient[GlazedDonutCovarient](glazedDonutType ,4)
    //it2.printDetails
    val it3:ItemCovarient[DonutCovarient] = ItemCovarient[DonutCovarient](donutType1,3)
    //it3.printDetails
    val it4:ItemCovarient[DonutCovarient] = ItemCovarient[DonutCovarient](donutType2, 6)
    //it4.printDetails

    /*
     ShoppingCartCovarient should work for all types of sub types of DonutCovarient
       All below combination should work
       DonutCovarient = DonutCovarient
       DonutCovarient = VanillaDonutCovarient
       VanillaDonutCovarient =  VanillaDonutCovarient
     */
    val seq1: Seq[ItemCovarient[DonutCovarient]]= Seq(it1,it2,it3,it4)
    val shoppingCart1: ShoppingCartCovarient[DonutCovarient] = new ShoppingCartCovarient(seq1)

    println(shoppingCart1.getTotalPrice())
    val seq2: Seq[ItemCovarient[VanillaDonutCovarient]]= Seq(it1)
    val shoppingCart2: ShoppingCartCovarient[VanillaDonutCovarient]= new ShoppingCartCovarient[VanillaDonutCovarient](seq2)
    println(shoppingCart2.getTotalPrice())
    val seq3: Seq[ItemCovarient[GlazedDonutCovarient]]= Seq(it2)
    //The Shopping cart should be type of DonutCovarient but must hold only GlazedDonutCovarient in seq
    // if i try to add VanillaDonutCovarient i should get CTE.
    //This is cz of  + D ----> covariance
    val shoppingCart3 : ShoppingCartCovarient[DonutCovarient]= new ShoppingCartCovarient[GlazedDonutCovarient](seq3)
    println(shoppingCart3.getTotalPrice())

  }

}
