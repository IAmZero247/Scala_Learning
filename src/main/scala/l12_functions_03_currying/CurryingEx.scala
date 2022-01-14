package l12_functions_03_currying

object CurryingEx {
  def add(x: Int, y: Int ,z:Int): Int  = x + y +z;
  val sum

  def addcurried1(x:Int)(y:Int)(z:Int):Int =x+y;

  def addcurried2(x:Int) (y:Int)  = (z:Int)=> x+y+z


  def main(args: Array[String]): Unit = {
    println(add(20, 19, 21))
    println(addcurried1(20)(19)(21))
    println(addcurried2(20)(19)(21))
  }

}
