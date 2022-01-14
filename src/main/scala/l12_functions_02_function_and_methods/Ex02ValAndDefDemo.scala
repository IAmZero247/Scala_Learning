package l12_functions_02_function_and_methods

import java.util.Date


/*
 andThen is function decompostion in scala.
 covered latter
 */

object Ex02ValAndDefDemo {

  val dummyFunctionVal : Int => Int = {
    println(new Date())
    num => num
  }

  def dummyFunctionDef(number : Int) : Int = {
    println(new Date())
    number
  }

  def getNameLengthDefM(name : String) : Int = name.length
  def multiplyByTwoDefM(number : Int) : Int = number * 2
  val getNameLengthValf1 : String =>  Int = name => name.length
  val multiplyByTwoValf1 : Int => Int = num => num * 2


  def main(args: Array[String]): Unit = {
    println(dummyFunctionVal(10)) // prints out the date and then the result :10
    println(dummyFunctionVal(10)) // doesn't print out the date and just returns 10

    println(dummyFunctionDef(10)) // prints out the date and then the result :10
    println(dummyFunctionDef(10)) // prints out the date and then the result :10


    //val doubleLengthOfString1 = getNameLengthDefM.andThen(multiplyByTwoDefM) //CTE
    val doubleLengthOfString2 = getNameLengthValf1.andThen(multiplyByTwoValf1)


    println(doubleLengthOfString2("spiderman"))
    val getNameLengthDefFnValuef2 = getNameLengthDefM _
    val multiplyByTwoDefFnValuef2 = multiplyByTwoDefM _

    val doubleLengthOfString3 = getNameLengthDefFnValuef2.andThen(multiplyByTwoDefFnValuef2)
    println(doubleLengthOfString2("batman"))
  }

}
