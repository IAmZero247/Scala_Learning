package l14_functions_01_subroutine

object Subroutine_Ex {


  def myfun1normal( a:Int, b: String):String ={
    println(b+ a)
    return b+a+"!.";
  }
  /*
   Below fun always return Unit
   */
  def myfun2subroutine( a:Int, b: String) {
    println(b+ a)
    return  b+a+"!.";  //-this return wont work. subroutine.
  }

  def main(args: Array[String]): Unit = {
    val c1 = myfun1normal(2, "hello")
    println("c1 ->" + c1)
    val c2 = myfun2subroutine(2, "hello")
    println("c2 ->" + c2)
  }


}
