package l10_ifelse_loops
import scala.util.control.Breaks._
import scala.util.control._

object DemoBWhileLoop {
  def main(args: Array[String]): Unit = {
    var x = 15


    while (x>10) {                      //x=1<10 true,2 ,3,4,5,6,7,8,9,10<10-false
      println("Value of x is " + x)
      x = x - 1                         //1->2->3...10
    }
    println(x);


    //x is 10 now
    x=10;

    breakable{
      do {
        if(x<0) {
          break
        }
        println("Value of x from do-while loop is " + x)
        x = x - 1                         //1->2->3...10
      } while (x<10)                     //x=2<10 true,3,4,5,6,7,8,9,10<10-false

    }


    // Diff between while and do-while loop
    // 1. While will check condition at the start, where as do while will check condition at end
    // 2. do-while will execute the code atleast once even if the condition is failing


  }
}
