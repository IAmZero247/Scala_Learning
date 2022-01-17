# Typed Function (Method OverLoading in Java)

    ```$xslt
    def applyDiscount(couponCode: String) {
      println(s"Lookup percentage discount in database for $couponCode")
    }
    
    def applyDiscount(percentageDiscount: Double) {
      println(s"$percentageDiscount discount will be applied")
    }
    
    applyDiscount("COUPON_1234")
    applyDiscount(10)
    
    def applyDiscount[T](discount: T){
      discount match {
       case d:String =>
            println(s"Lookup percentage discount in database for $d")
       case d:Double =>
            println(s"$d discount will be applied")
       case _ => 
             println("Unsupported discount type")
      } 
    }
    
    
    applyDiscount[String]("COUPON_123")
    applyDiscount[Double](10)
    ```