#  Companion Object and Companion Class 

1. Companion object is known as an object whose name is same as the name of the class. 

1. In other words, when an object and a class have the same name, then that object is known as
   the companion object and the class is known as companion class.   
   
1. A companion object is defined in the same source file in which the class is defined. 

1. A companion object is allowed to access both private methods and private fields of the class. 

1. Companion object to create instances for that particular class without having to make use of the new keyword.

   ```$xslt
    class Task(val description: String) {
      private var _status: String = "pending"
      def status():String = _status
    }
    
    object Task {
      def apply(description: String): Task = new Task(description)
    }
   
   
    Useage 
    val task = Task("do something")
    assert(task.description == "do something")
   ```