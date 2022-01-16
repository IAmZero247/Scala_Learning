#  Option In Function Parameters
 
1. Inside our function, we will test for a valid couponCode using pattern matching. 
   ```$xslt
   def calculateItemCost(itemName: String, quantity: Int, couponCode: Option[String]): Double = {
     couponCode match {
       case Some(coupon) =>
       val discount = 0.1 // Let's simulate a 10% discount
       val totalCost = 2.50 * quantity * (1 - discount)
       totalCost
   
       case None => 2.50 * quantity
     }
   }
   ```
2. Default Value For Option Parameter   
   ```$xslt
      def calculateItemCost(itemName: String, quantity: Int, couponCode: Option[String] = None): Double = {
        couponCode match {
          case Some(coupon) =>
          val discount = 0.1 // Let's simulate a 10% discount
          val totalCost = 2.50 * quantity * (1 - discount)
          totalCost
      
          case _ => 2.50 * quantity
        }
      }
   
      //Invocation 
      calculateItemCost("Glazed Donut", 5)
      calculateItemCost("Glazed Donut", 5, "MY COUPON")
   ```
3. How to use the map function to extract a valid Option value
   ```$xslt
    val coupon1: Option[String] = Some("My Coupon123")
    coupon1.map(d => println(s"val = $d"))
    
    val coupon2: Option[String] = None
    coupon2.map(d => println(s"val = $d"))
   ```   