package l12_functions_04_option_type

object OptionsDemo {
  def calculateItemCost1(itemName: String, quantity: Int, couponCode: Option[String]): Double = {
    couponCode match {
      case Some(coupon) =>
        val discount = 0.1 // Let's simulate a 10% discount
        val totalCost = 2.50 * quantity * (1 - discount)
        totalCost

      case None => 2.50 * quantity
    }
  }

  def calculateItemCost2(itemName: String, quantity: Int, couponCode: Option[String] = None): Double = {
    couponCode match {
      case Some(coupon) =>
        val discount = 0.1 // Let's simulate a 10% discount
        val totalCost = 2.50 * quantity * (1 - discount)
        totalCost

      case _ => 2.50 * quantity
    }
  }
  def dailyCouponCode(): Option[String] = {
    // look up in database if we will provide our customers with a coupon today
    val couponFromDb = "COUPON_1234"
    Option(couponFromDb).filter(_.nonEmpty)
  }
  def main(args: Array[String]): Unit = {
    println(calculateItemCost2("Glazed Donut", 5))
    println(calculateItemCost2("Glazed Donut", 5, Option("MY COUPON")))
    println(calculateItemCost2("Glazed Donut", 5, dailyCouponCode()))

  }

}
