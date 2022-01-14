package pack02_singleton

object Demo {
  def main(args: Array[String]): Unit = {

    //val demoObjectB1 = new SingletonObjectSample //1st Note: IF you uncomment it, it will give error, as can not create object from a object

    println(SingletonObjectSample.x, SingletonObjectSample.y) //2nd Note: Access variable as objectName.variableName
    val a = SingletonObjectSample.addValue() //3rd Note: Access method/function as objectName.method
    println(a)
  }
}
