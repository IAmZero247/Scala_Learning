package l02_oops_01_primary_and_auxillary_constructor

class Calc (val aHasDefault:Int = 10 , b:Double , sHasDefault:String = "default"){
  val x = aHasDefault       //var(can change the value) and val (can not change the value):
  var y = b                 // retrieve(GET) and change(SET) the content of y because it is a var >>> INTERNALLY SCALA CREATES 2 METHODS - GETTER AND SETTER
  val z = sHasDefault       // ONLY retrieve(GET) the content of y because it is a val () >>> INTERNALLY SCALA CREATES ONLY 1 METHOD - GETTER

  def addNumber() = {
    x + y
  }

  def this(){
    this(99,88.88,"Hello Scala")
    println("I came into Auxiliary constructor with 0 paramters")
  }

  def this(a:Int){
    this(a,88.88,"Hello Scala")
    println("I came into Auxiliary constructor with 1 paramters that has a:Int")
  }

  def this(a:Int, b:Double){
    this(b=b,sHasDefault ="Hello Scala")
    println("I came into Auxiliary constructor with 2 paramters")
  }

  def this(c:String){
    this(6,66.66,c)
    println("I came into Auxiliary constructor with 1 paramter that was c:String")
  }

  println(s"x = ${x} and y = ${y} and z = ${z}")

}
