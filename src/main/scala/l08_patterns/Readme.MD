# Patterns 
1. Pattern matching is a way of checking the given sequence of tokens

1. It is similar to the switch statement of Java

1.  “match” keyword is used instead of switch statement.

1. Each case statement includes a pattern and one or more expression which get evaluated if the specified pattern gets matched. 

1. To separate the pattern from the expressions, arrow symbol(=>) is used.

   ```$xslt
    def test(x:Int): Any = x match {
            
          // if value of x is 0,
          // this case will be executed
          case 0 => 100
            
          // if value of x is 1, 
          // this case will be executed
          case 1 => "Are you learning Scala?"
            
          // if x doesnt match any sequence,
          // then this case will be executed
          case _ => "Good Luck!!"
      }
   ```