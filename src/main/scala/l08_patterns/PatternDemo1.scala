package l08_patterns
case class PatternDemo1() {

  def matchPattern1(x:Int) = x match {
  case 1 => "One"
  case 2 => "Two"
  case _ => "None of above"
  }

  def matchPattern2(x:Any) = x match {
  case 1 => "One"
  case 2 => "Two"
  case "Three" => 3
  case "Four" => 4
  case _ => "None of Above"
  }


}
object PatternDemo1 {

  def main(args: Array[String]): Unit = {
    var pd1 = PatternDemo1()
    println(pd1.matchPattern1(1))
    println(pd1.matchPattern1(2))
    println(pd1.matchPattern1(3))

    println(pd1.matchPattern2(1))
    println(pd1.matchPattern2(2))
    println(pd1.matchPattern2("Three"))
    println(pd1.matchPattern2("Four"))
    println(pd1.matchPattern2(5))


  }
}
