package l02_oops_01_primary_and_auxillary_constructor

object Demo {
  def main(args: Array[String]): Unit = {
    val demoObject1 = new Calc(5,7.2,"Hello World!")  //Object: Instance of class -> Calls Constructor
    val demoObject2 = new Calc(6,8.3,"Hello World Again!")  //Object: Instance of class -> Calls Constructor

    //    demoObject1.x =3   // Can not change(only retrieve) the content of x as it was defined as val in the class and hence it only has getter method
    demoObject1.y = 7.22222 // can retrieve  and change the content of y as it was defined as var inthe class and hence it has getter and setter method

    println(demoObject1.x, demoObject1.y,demoObject1.z)
    var result = demoObject1.addNumber()
    println(s"result = ${result}")

    println(demoObject2.x, demoObject2.y,demoObject2.z)
    result = demoObject2.addNumber()
    println(s"result = ${result}")


    val demoPriConstructor1 = new Calc(b=25.55)
    val demoPriConstructor2 = new Calc(b=12.22 ,sHasDefault = "Hello")
    val demoPriConstructor3 = new Calc(sHasDefault = "Hello", aHasDefault = 5, b = 6.6)

    val demoAuxConstructor1 = new Calc(5,7.2,"Hello World!")
    val demoAuxConstructor2 = new Calc()
    val demoAuxConstructor3 = new Calc(7)
    val demoAuxConstructor4 = new Calc(7,2.2)
    val demoAuxConstructor5 = new Calc("Hello Java")

    val demoAuxConstructor6 = new Calc(aHasDefault=5,b=7.2,sHasDefault="Hello World!")

  }

}
