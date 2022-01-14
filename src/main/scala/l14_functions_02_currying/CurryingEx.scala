package l14_functions_02_currying

object CurryingEx {
  def add(x: Int, y: Int): Int  = x + y;

  def addcurried1(x:Int)(y:Int):Int =x+y;

  def addcurried2(x:Int) = (y:Int) => x+y


  def main(args: Array[String]): Unit = {
    println(add(20, 19))
    println(addcurried1(20)(19))
    println(addcurried2(20)(19))
  }

}
