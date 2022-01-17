#  Singleton 

1. Scala does not have a static keyword! Instead, you can simply encapsulate a global field using the val keyword inside a Singleton Object.

2. A singleton object is created by using object keyword. 
    
    ```$xslt
    Syntax: 
     
    
        object Name{
        // code...
        }
    ```
   
#  Important Points
1. The method in the singleton object is globally accessible.
1. You are not allowed to create an instance of singleton object.
1. You are not allowed to pass parameter in the primary constructor of singleton object.
1. In Scala, a singleton object can extend class and traits.
1. In Scala, a main method is always present in singleton object.
1. The method in the singleton object is accessed with the name of the object(just like calling static method in Java), so there is no need to create an object to access this method.    