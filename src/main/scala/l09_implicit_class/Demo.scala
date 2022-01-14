package l09_implicit_class




object Demo {

  implicit  class StringHelper(s:String){
    def getFirstChar():String={
      return s.substring(0,1)
    }
    def getCharAtPos(i:Int):String={
      return s.substring(i,i+1)
    }
  }

  def main(args: Array[String]): Unit = {
    val str = "HelloWorld"
    println(str.getFirstChar())
    println(str.getCharAtPos(5))
  }

}
