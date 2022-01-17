package l02_oops_02_singleton
//Think like a static fields and methods in java
object SingletonObjectSample {
  val x = 2
  val y = 5.5

  def addValue() =  x + y

  println(s"x = ${x} , y = ${y}")
}
