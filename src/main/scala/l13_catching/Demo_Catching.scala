package l13_catching
import scala.util.control.Exception.catching

object Demo_Catching {
  def main(args: Array[String]): Unit = {

    val catchExceptions = catching(classOf[ArithmeticException],classOf[ArrayIndexOutOfBoundsException]).withApply(e => println("Arithmetic Exception has occured " + e))
    //val catchExceptions = catching(classOf[ArithmeticException],classOf[ArrayIndexOutOfBoundsException]).withApply(e => errorHandlingFunction(e))


    val a = catchExceptions(10/0)

    if (a.!=()){
      println(a)
    }
  }

  def errorHandlingFunction(exception: Throwable) = {
    exception.printStackTrace()
    println(exception.getLocalizedMessage)
  }
}
