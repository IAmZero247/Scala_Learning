# Explicit Return Type


1. Style 1 - Use val/def as needed 
   
   ```$xslt
   def m1 : (Int, Int , Int ,String) => String = (i1,i2,i3,s) => {
   val sum = i1+i2+i3;
   f"$s=[$sum]";    #PS -> never use explicit return keyword
   }
   
   has three parts 1st : 2nd = 3rd
   1. def/val followed by method_name
   2. input and output type -> (Int, Int, Int, String) => String
   3. parms and body -> (i1,i2,i3,s) => {...}
   ``` 
2. Style 2 - Use val/def as needed  
   ```$xslt
   def m1(i1:Int, i2:Int , i3:Int ,s:String): String =  {
   val sum = i1+i2+i3;
   return f"$s=[$sum]";   #PS -> return keyword is optional
   }   
   ``` 
# Implicit Return Type 

1. Style 1 - Use val/def as needed  
   ```$xslt
   def m2 =(i1:Int, i2:Int , i3:Int ,s:String) =>  {
   val sum = i1+i2+i3;
   f"$s=[$sum]";   #PS -> never use explicit return keyword
   }   
   
   has three parts 1st = 2nd => 3rd
   1. def/val followed by method_name
   2. params and type -> (i1:Int, i2:Int , i3:Int ,s:String)
   3. body ->  {...}
   ```   

2. Style 2 - Use val/def as needed  
   ```$xslt
   def m2(i1:Int, i2:Int , i3:Int ,s:String)=  {
   val sum = i1+i2+i3;
   f"$s=[$sum]";   #PS -> never use explicit return keyword
   }   
   ```  