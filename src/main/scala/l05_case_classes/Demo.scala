package l05_case_classes

object Demo {
  def main(args: Array[String]): Unit = {
    // 1. No need to write "new", since "apply" method is auto generated in case class
    val bmw = Car("BMW", "550")
    bmw.printDetails()
    //2. Constructor parameter is val by default.
     /*Therefore mutator method is not autogenerated and hence you can not change the name.
      However, if you change the constructor parameter to var, mutator method will be auto generated
      and you will be able to modify the value in variable
     */
    //bmw.name = "B.M.W"

    //3. Case class autogenerate unapply method , used for pattern matching
    bmw match {case Car(a,b) => println(a,b)}
    //4. Autogenerates copy method
    val mercedes = bmw.copy(name = "mercedes")
    mercedes.printDetails()

    //5. equals and hashcode method
    println(bmw == mercedes)

    //6. toString method is autoimplemented
    println(bmw)
  }
}