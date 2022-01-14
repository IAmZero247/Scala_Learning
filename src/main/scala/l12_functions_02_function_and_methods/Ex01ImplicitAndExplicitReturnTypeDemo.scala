package l12_functions_02_function_and_methods

import java.util.Date

object Ex01ImplicitAndExplicitReturnTypeDemo {

  //   input paramater -> int1 int2 int3, name
  //   output parameter -> string
  //   simply add month + date +year and return name=number


  //Traditional Explicit Return Type
  def m1traditional_ert(mm:Int, dd:Int, yyyy:Int , name:String): String = {
    println(new Date())
    val sum = mm+dd+yyyy
    return f"$name=[${sum}]"
  }
  //Traditional Implicit Return Type
  def m1traditional_irt(mm:Int, dd:Int, yyyy:Int , name:String) = {
    println(new Date())
    val sum = mm+dd+yyyy
    f"$name=[${sum}]"
  }
  //Modern Explicit Return Type
  def m2modern_ert :(Int, Int, Int, String)=>String = (i1,i2,i3,s1) =>{
    println(new Date())
    val sum = i1+i2+i3;
    f"$s1=[${sum}]";
  }



  //Modern Implicit Return Type
  def m2modern_irt = (i1:Int, i2:Int, i3:Int, s1:String)  => {
    println(new Date())
    val sum = i1+i2+i3;
    f"$s1=[${sum}]"
  }

  def main(args: Array[String]): Unit = {
    println(m1traditional_ert(10,10, 2000, "ze ro"))
    println(m1traditional_irt(10,10, 2001, "ze ro"))
    println(m2modern_ert(10,10, 2000, "ze ro"))
    println(m2modern_irt(10,10, 2000, "ze ro"))

  }
}
