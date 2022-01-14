package pack_10_try_catch_finally

import java.io.{FileNotFoundException, FileReader, IOException}

object DemoTryCatchFinally {
  def main(args: Array[String]): Unit = {
    try {
      val f = new FileReader("C:\\Users\\Sandeep\\Desktop\\ScalaLearning\\P02ClassesAndMethods\\src\\main\\scala\\pack_10_try_catch_finally\\input.txt")

      val a = 10/5
      println(a)

      val array1 = Array(10)
      println(array1(11))

    } catch {
      case e: FileNotFoundException => {
        println("File is not Found - Exception Received " + e)
        // instead of e, you can also write name, eg: ex, zzzz
        // in real world program, you will usually log this error in some error log file
      }
      case e: IOException => {
        println("Error While reading file - Exception Received")
      }
      case e: ArithmeticException => {
        println("Arithmetic Exception Received")
      }
      case _: Exception => {
        println("It will catch all unhandled exception")
      }

    } finally {
      println("It will always be executed irrespective of Exception or not")
    }
  }
}
