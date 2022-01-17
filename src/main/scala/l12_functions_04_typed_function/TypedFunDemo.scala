package l12_functions_04_typed_function

object TypedFunDemo {
  def applyDiscount(couponCode: String) {
    println(s"Lookup percentage discount in database for $couponCode")
  }

  def applyDiscount(percentageDiscount: Double) {
    println(s"$percentageDiscount discount will be applied")
  }

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
  def main(args: Array[String]): Unit = {
    applyDiscount[String]("COUPON_123")
    applyDiscount[Double](10)
  }

}
