package l12_try_success_failure

import scala.util.Try
import scala.util.Success
import scala.util.Failure

object Demo_TrySuccessFailure {

  def main(args: Array[String]): Unit = {
    val a1 = Try (divide(10,2))

    a1 match {
      case Success(value) => println(value)
      case Failure(exception) => errorHandlingFunction(exception)
    }


    val a2 = Try(divide(10,0))

    a2 match {
      case Success(value) => println(value)
      case Failure(exception) => errorHandlingFunction(exception)
    }

  }

  def errorHandlingFunction(exception: Throwable) = {
    exception.printStackTrace()
    println(exception.getLocalizedMessage)
    /*
    if (exception.toString.equals("java.lang.ArithmeticException: / by zero")){
      println("hello, arithmetic exception had occured")
    }
    */
  }

  def divide(n1:Int, n2:Int): Int ={
  return n1/n2;
  }
}
