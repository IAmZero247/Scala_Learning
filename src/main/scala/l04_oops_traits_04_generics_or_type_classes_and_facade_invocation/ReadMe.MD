
## Shoping Cart Trait For Donut
   
   ```$xslt
    trait DonutShoppingCartService {

     def add(donutName: String): Long
   
     ........Remaining abstract Methods........
    
    }

    //Below is Typed Version
    trait DonutShoppingCartService[A] {
    
     def add(donut: A): Long

     ........Remaining abstract Methods........
     def update(donut: A): Boolean
     def search(donut: A): A
     def delete(donut: A): Boolean
    }
    
    //Another Typed Trait
    trait DonutInventoryService[A] {
    
     def checkStockQuantity(donut: A): Int
    
    }

    //Another Typed Trait
    trait DonutDatabaseRepo[A] {
    
     def addOrUpdate(donut: A): Long
     def query(donut: A): A
     def delete(donut: A): Boolean

    }
   ```
2. Implementation of CassandraDonutDatabase

   ```$xslt
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
   ```
2. Implementation of ShoppingCart and InventoryService
   1. We are creating trait rather then class for purpose of mixing in future

   ```$xslt
   //ShoppingCart
   trait DonutShoppingCartImpl[A] extends DonutShoppingCartService[A] {
   
     val donutDatabase: DonutDatabaseRepo[A]
   
     override def add(donut: A): Long = {
       println(s"DonutShoppingCart-> add method -> donut: $donut")
       donutDatabase.addOrUpdate(donut)
       1
     }
      
     def update(donut: A): Boolean = {
       println(s"DonutShoppingCartDao-> update method -> donut: $donut")
       donutDatabase.addOrUpdate(donut)
       true
     } 
     def search(donut: A): A = {
       println(s"DonutShoppingCartDao-> search method -> donut: $donut")
       donutDatabase.query(donut)
     }
     def delete(donut: A): Boolean = {
       println(s"DonutShoppingCartDao-> delete method -> donut: $donut")
       donutDatabase.delete(donut)
     }
   
   }
   
   //Redefined
   trait DonutInventoryServiceImpl[A] {
   
    val donutDatabase: DonutDatabaseRepo[A] // dependency injection
   
    def checkStockQuantity(donut: A): Int = {
     println(s"DonutInventoryService-> checkStockQuantity method -> donut: $donut")
     donutDatabase.query(donut)
     1
    }
   
   }
   ```
3. Create a trait which will act as a facade and extends multiple traits   
   1.  We have injected an implementation of our storage layer
   ```$xslt
    trait DonutShoppingCartServicesCassandraFacade[A] extends DonutShoppingCartDaoImpl[A] with DonutInventoryServiceImpl[A] {
     override val donutDatabase: DonutDatabase[A] = new CassandraDonutStore[A]()  
    }

    class DonutShoppingCartServicesCassandraFacadeImpl[A] extends DonutShoppingCartServicesCassandraFacade[A] {
    
    }
   
    //Invocation
    val donutShoppingCart: DonutShoppingCartServicesCassandraFacade[String] = new DonutShoppingCartServicesCassandraFacadeImpl[String]()
    donutShoppingCart.add("Vanilla Donut")
    donutShoppingCart.update("Vanilla Donut")
    donutShoppingCart.search("Vanilla Donut")
    donutShoppingCart.delete("Vanilla Donut")
    donutShoppingCart.checkStockQuantity("Vanilla Donut")
    ```
 
4. Alternate for step 3 using this  [Trait Mixing]
   ```$xslt
     class DonutShoppingCartServicesCassandraFacade[A] {
       this: DonutShoppingCartImpl[A] with DonutInventoryServiceImpl[A] =>
       override val donutDatabase: DonutDatabaseRepo[A] = new CassandraDonutStore[A]()
       override def add(donut: A): Long = add(donut)
       override def update(donut: A): Boolean = update(donut)
       override def search(donut: A): A = search(donut)
       override def delete(donut: A): Boolean = delete(donut)
       override def checkStockQuantity(donut: A): Int = checkStockQuantity(donut)
     }
   
     //Invocation
      val donutShoppingCart: DonutShoppingCartServicesCassandraFacade[String] = new DonutShoppingCartServicesCassandraFacade[String] with DonutShoppingCartImpl[String] with DonutInventoryServiceImpl[String]
      donutShoppingCart.add("Vanilla Donut")
      donutShoppingCart.update("Vanilla Donut")
      donutShoppingCart.search("Vanilla Donut")
      donutShoppingCart.delete("Vanilla Donut")
      donutShoppingCart.checkStockQuantity("Vanilla Donut")
   ```

5. Console Output
   ```$xslt
   DonutShoppingCart-> add method -> donut: Vanilla Donut
   CassandraDonutDatabase-> addOrUpdate method -> donut: Vanilla Donut
   DonutShoppingCartDao-> update method -> donut: Vanilla Donut
   CassandraDonutDatabase-> addOrUpdate method -> donut: Vanilla Donut
   DonutShoppingCartDao-> search method -> donut: Vanilla Donut
   CassandraDonutDatabase-> query method -> donut: Vanilla Donut
   DonutShoppingCartDao-> delete method -> donut: Vanilla Donut
   CassandraDonutDatabase-> delete method -> donut: Vanilla Donut
   DonutInventoryService-> checkStockQuantity method -> donut: Vanilla Donut
   CassandraDonutDatabase-> query method -> donut: Vanilla Donut
   ```   
      