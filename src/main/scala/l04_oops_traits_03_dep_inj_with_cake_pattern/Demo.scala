package l04_oops_traits_03_dep_inj_with_cake_pattern

trait FooAble {
  def foo():Any = ???
}
trait BazAble{
  def baz():Any = ???
}

trait MyFooAbleImplInTrait extends FooAble {
  override def foo() = "foo implementaion"
}
trait MyBazAbleImplInTrait extends BazAble {
  override def baz():Any = "baz implemenation"
}

class BarUsingFooAbleAndBazAble {
  this: FooAble with BazAble =>
  def bar() = s"bar calls foo: ${foo()} and baz: ${baz()}"
}

class  BarUsingFooAbleConstructorInjection (dep:FooAble with BazAble) {
  def bar() = s"bar calls foo: ${dep.foo()} and baz: ${dep.baz()}"
}

class BarUsingFooAble {
  this: FooAble => //see note #1
  def bar() = "bar calls foo: " + foo() //see note #2
}



object Demo {
  def main(args: Array[String]): Unit = {
    val barWithFoo = new BarUsingFooAble() with MyFooAbleImplInTrait
    println(barWithFoo.bar())
    val barWithFooAndBaz1 = new BarUsingFooAbleAndBazAble() with MyFooAbleImplInTrait with  MyBazAbleImplInTrait
    println(barWithFooAndBaz1.bar())
    val barWithFooAndBaz2 = new BarUsingFooAbleConstructorInjection(new MyFooAbleImplInTrait with MyBazAbleImplInTrait)
    println(barWithFooAndBaz2.bar())


  }
}
