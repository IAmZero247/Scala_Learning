package pack10_functions_1a

object fun001_subroutine_fun {

  /*
   * = : In Scala, a user can create function with or without = (equal) operator.
   *
   * If the user uses it, the function will return the desired value.
   * If he doesn’t use it, the function will not return any value and will work like a subroutine.
   */

  def myfun1normal( a:Int, b: String):String ={
    println(b+ a)
    return b+a+"!.";
  }

  def myfun2subroutine( a:Int, b: String) {
    println(b+ a)
    return b+a+"!.";  //-this return wont work. subroutine.
  }

  def main(args: Array[String]): Unit = {
    val c1 = myfun1normal(2, "hello")
    println("c1 ->" + c1)
    val c2 = myfun2subroutine(2, "hello")
    println("c2 ->" + c2)
  }


}
