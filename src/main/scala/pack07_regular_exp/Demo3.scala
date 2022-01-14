package pack07_regular_exp
import scala.util.matching.Regex


object Demo3 {
  def main(args: Array[String]): Unit = {
    val Pat = """(-)?(\d+)(\.\d*)?""".r
    //val Pat = "(-)?(\\d+)(\\.\\d*)?.r"

    /*
     # -> (-) is optional -> sign
     # -> (\d+) is mandatory  -> integer part
     # -> (\.\d*) is optional -> decimal part
     */
    val stringToFind = "-1.5 divide by .5 is 3 is wrong"

    //val  Decimal(sign, integerpart, decimalpart) = "-1.23"


    for (Pat(sign, integerPart, decimalPart) <- Pat.findAllIn(stringToFind)) {
      println("Sign is " + sign + ", Integer Part is " + integerPart + ", Decimal Part is " + decimalPart)
    }


  }
}
