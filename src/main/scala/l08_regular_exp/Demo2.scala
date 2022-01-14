package l08_regular_exp
import scala.util.matching.Regex

object Demo2 {

  def main(args: Array[String]): Unit = {

    val stringToFind1: String = "Hello i am Able to do it, abl11 able able0 "
    val p1 = "abl[ae]\\d+".r
    val p2 = "abl[ae]\\d*".r
    val r1 =p1.findAllIn(stringToFind1).toArray
    val r2 =p2.findAllIn(stringToFind1).toArray
    r1.foreach(i=> println(i))
    println("*****")
    r2.foreach(i=> println(i))
    println("*****")
    val p3 = "[Aa]bl[ae]\\d*".r
    val r3 =p3.findAllIn(stringToFind1).toArray
    r3.foreach(i=> println(i))
    println("*****")
    val p4 = "(A|a)bl[ae]\\d*".r
    val r4 =p4.findAllIn(stringToFind1).toArray
    r4.foreach(i=> println(i))


    //Ex2
    val stringToFind2 = "-1.5 divide by 5 is 3 is wrong"
    //var p5 =  """(-)?(\d+)(\.\d*)?""".r
    val p5 = "(-)?[0-9](\\.[0-9]*)?".r
    val r5 = p5.findAllIn(stringToFind2).toArray
    r5.foreach(i=> println(i))



  }

}
