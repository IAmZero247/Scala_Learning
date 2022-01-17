package l02_oops_06_implicit_class_and_extension_methods

case class Donut(name: String, price: Double, productCode: Option[Long] = None)

object DonutImplicits {
  //implicit class to augment or extend the Donut object with a uuid field
  //The vanilla donut object now has access the uuid method - also known as the extension method.
  implicit class AugmentedDonut(donut: Donut) {
    def uuid: String = s"${donut.name} - ${donut.productCode.getOrElse(12345)}"
  }
}

object DemoExtendingCaseClassDonut {



  def main(args: Array[String]): Unit = {
    val vanillaDonut: Donut = Donut("Vanilla", 1.50)
    import DonutImplicits._
    println(s"Vanilla donut uuid = ${vanillaDonut.uuid}")
  }
}
