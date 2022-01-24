package l04_oops_traits_04_generics_or_type_classes_and_facade_invocation


trait DonutShoppingCartService[A] {
  def add(donut: A): Long
  def update(donut: A): Boolean
  def search(donut: A): A
  def delete(donut: A): Boolean
}
trait DonutInventoryService[A] {
  def checkStockQuantity(donut: A): Int
}
trait DonutDatabaseRepo[A] {
  def addOrUpdate(donut: A): Long
  def query(donut: A): A
  def delete(donut: A): Boolean
}
/*******************************Implementation-Repo******************************/

class CassandraDonutStore[A] extends DonutDatabaseRepo[A] {

  override def addOrUpdate(donut: A): Long = {
    println(s"CassandraDonutDatabase-> addOrUpdate method -> donut: $donut")
    1
  }
  override def query(donut: A): A = {
    println(s"CassandraDonutDatabase-> query method -> donut: $donut")
    donut
  }
  override def delete(donut: A): Boolean = {
    println(s"CassandraDonutDatabase-> delete method -> donut: $donut")
    true
  }
}
/********************************************************************************/
/*****************************Implementation-Service*****************************/
trait DonutShoppingCartImpl[A] extends DonutShoppingCartService[A] {

  val donutDatabase: DonutDatabaseRepo[A]

  override def add(donut: A): Long = {
    println(s"DonutShoppingCart-> add method -> donut: $donut")
    donutDatabase.addOrUpdate(donut)
    1
  }

  override def update(donut: A): Boolean = {
    println(s"DonutShoppingCartDao-> update method -> donut: $donut")
    donutDatabase.addOrUpdate(donut)
    true
  }
  override def search(donut: A): A = {
    println(s"DonutShoppingCartDao-> search method -> donut: $donut")
    donutDatabase.query(donut)
  }
  override def delete(donut: A): Boolean = {
    println(s"DonutShoppingCartDao-> delete method -> donut: $donut")
    donutDatabase.delete(donut)
  }

}
trait DonutInventoryServiceImpl[A] extends DonutInventoryService[A]{

  val donutDatabase: DonutDatabaseRepo[A] // dependency injection

  override def checkStockQuantity(donut: A): Int = {
    println(s"DonutInventoryService-> checkStockQuantity method -> donut: $donut")
    donutDatabase.query(donut)
    1
  }

}
/********************************************************************************/
/*****************************Facade With Casseandra*****************************/

/*
//First Way Of Facade
trait DonutShoppingCartServicesCassandraFacade[A] extends DonutShoppingCartImpl[A] with DonutInventoryServiceImpl[A] {
  override val donutDatabase: DonutDatabaseRepo[A] = new CassandraDonutStore[A]()
}

class DonutShoppingCartServicesCassandraFacadeImpl[A] extends DonutShoppingCartServicesCassandraFacade[A] {

}
*/
//Second Way Of Facade
class DonutShoppingCartServicesCassandraFacade[A] {
  this: DonutShoppingCartImpl[A] with DonutInventoryServiceImpl[A] =>
  override val donutDatabase: DonutDatabaseRepo[A] = new CassandraDonutStore[A]()
  override def add(donut: A): Long = add(donut)
  override def update(donut: A): Boolean = update(donut)
  override def search(donut: A): A = search(donut)
  override def delete(donut: A): Boolean = delete(donut)
  override def checkStockQuantity(donut: A): Int = checkStockQuantity(donut)
}
object Demo {

  def main(args: Array[String]): Unit = {
    /* //Invocation -1st Way of Facade
     *val donutShoppingCart: DonutShoppingCartServicesCassandraFacade[String] = new DonutShoppingCartServicesCassandraFacadeImpl[String]()
     */
    //Invocation - 2nd Way Of Facade
    val donutShoppingCart: DonutShoppingCartServicesCassandraFacade[String] = new DonutShoppingCartServicesCassandraFacade[String] with DonutShoppingCartImpl[String] with DonutInventoryServiceImpl[String]
    donutShoppingCart.add("Vanilla Donut")
    donutShoppingCart.update("Vanilla Donut")
    donutShoppingCart.search("Vanilla Donut")
    donutShoppingCart.delete("Vanilla Donut")
    donutShoppingCart.checkStockQuantity("Vanilla Donut")
  }

}
