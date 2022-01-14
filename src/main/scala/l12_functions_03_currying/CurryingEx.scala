package l12_functions_03_currying

object CurryingEx {
  /*
   * use val(function) or def(method)
   */
  def m11(mm: Int,dd: Int ,yyyy:Int , name:String): String  = f"$name=[$mm/$dd/$yyyy]"
  def m1curried1(mm:Int)(dd:Int)(yyyy:Int)(name:String):String = f"$name=[$mm/$dd/$yyyy]";

  def m12(mm: Int,dd: Int ,yyyy:Int , name:String)  = f"$name=[$mm/$dd/$yyyy]"
  def m1curried2(mm:Int)(dd:Int)(yyyy:Int)(name:String) = f"$name=[$mm/$dd/$yyyy]";


  def m21:(Int, Int , Int ,String )=> String = (mm,dd,yyyy,name) => f"$name=[$mm/$dd/$yyyy]"
  def m2curried1: Int => Int => Int => String => String = mm=>dd=>yyyy=>name => f"$name=[$mm/$dd/$yyyy]"

  def m22 = (mm:Int, dd:Int , yyyy:Int ,name:String ) => f"$name=[$mm/$dd/$yyyy]"
  //def m2curried2 = What will be the curried equivalent ?????

  def main(args: Array[String]): Unit = {
    println(m11(20, 12, 1990, "ruby"))
    println(m1curried1(20) (12) (1990) ("zen"))
    println(m1curried2(20) (12) (1990) ("ken"))
    println(m21(20, 12, 1990, "jack"))
    println(m2curried1(20)(12)(1990)("rose"))
  }

}
