# Option Return Type

 ```$xslt
    def dailyCouponCode(): Option[String] = {
      // look up in database if we will provide our customers with a coupon today
      val couponFromDb = "COUPON_1234"
      Option(couponFromDb).filter(_.nonEmpty)
    }
 ```

1. Invocation - GetOrElse
  ```$xslt
   val todayCoupon: Option[String] = dailyCouponCode()
   println(s"Today's coupon code = ${todayCoupon.getOrElse("No Coupon's Today")}")
  ```
2. Invocation -  pattern matching
   ```$xslt
   dailyCouponCode() match {
     case Some(couponCode) => println(s"Today's coupon code = $couponCode")
     case None => println(s"Sorry there is no coupon code today!")
   }
   ```
3. Invocation - map 
   ```$xslt
   dailyCouponCode().map(couponCode => println(s"Today's coupon code = $couponCode"))
   ```   