package pack07_regular_exp
import scala.util.matching.Regex

object Demo1 {
  /*
  val pattern = new Regex(“Whatever you want to match”)
  OR
  val pattern = “whatevet you want to match”.r
  r – is a method/function that is defined in a Regex class and it
  does nothing but calls the constructor
  */


  /*
  1. ^ ---> It is used to match starting point of the line.
  2. $ ---> It is used to match terminating point of the line.
  3. . ---> It is used to match any one character excluding the newline.
  4. […] ---> It is used to match any one character within the brackets.
     [^…]---> It is used to match any one character which is not in the brackets.

     Ex- > [Rr]uby  >> Match "Ruby" or "ruby"
           rub[ye]  >> Match "ruby" or "rube"
           [aeiou]  >> Match any one lowercase vowel
           [0-9]    >> Match any digit; same as [0123456789]
           [a-z]    >> Match any lowercase ASCII letter
           [A-Z]    >> Match any uppercase ASCII letter
           [a-zA-Z0-9] >> Match any of the above
           [^aeiou] >> Match anything other than a lowercase vowel
           [^0-9]   >> Match anything other than a digit



  5. \\A ---> It is used to match starting point of the intact string.
     \\z ---> It is used to match terminating point of the intact string.
     \\Z ---> It is used to match end of the whole string excluding the new line, if it exists.






  6. re*       ---> It is utilized to match zero or more appearances of the foregoing expressions.
     re+       ---> It is used to match one or more of the foregoing expressions.
     re?       ---> It is used to match zero or one appearance of the foregoing expression.
     re{ n}    ---> It is used to matches precisely n number of appearances of the foregoing expression.
     re{ n, }  ---> It is used to match n or more appearances of the foregoing expression.
     re{ n, m} ---> It is used to match at least n and at most m appearances of the foregoing expression.

   7.  q|r ---> It is utilized to match either q or r.

   8.  (re)    ---> It is utilized to group the Regular expressions and recollects the text that are
                 matched.
       (?: re) ---> It also groups the regular expressions but does not recollects the matched text.
      (?> re)  --->It is utilized to match self-reliant pattern in absence of backtracking.

   9. \\w  ---> It is used to match characters of the word.  [A-Za-z0-9_]
      \\W  ---> It is used to match characters of the non-word.  [^A-Za-z0-9_]
      \\s  ---> It is utilized to match white spaces which are analogous to [\t\n\r\f].
      \\S  ---> It is used to match non-white spaces.  [^ \t\r\n\f]
      \\d  ---> It is used to match the digits i.e, [0-9].
      \\D  ---> It is used to match non-digits. [^0-9]
      \\G  ---> It is used to match the point where the endmost match overs.
      \\n  ---> It is used for back-reference to occupy group number n.
      \\b  ---> It is used to match the word frontiers when it is out of the brackets and matches the
                backspace when it is in the brackets.
      \\B  ---> It is used to match non-word frontiers.
      \\n, \\t, etc. It is used to match the newlines, tabs, etc.
      \\Q It is used to escape (quote) each of the characters till \\E.
      \\E It is used in ends quoting starting with \\Q



      Ex ruby?  >> Match "rub" or "ruby": the y is optional like rub ruby
         ruby*  >> Match "rub" plus 0 or more ys like rub ruby rubyy rubyyy
         ruby+  >> Match "rub" plus 1 or more ys like ruby rubyy etc
         \\d{3} Match exactly 3 digits
         \\d{3,} Match 3 or more digits
         \\d{3,5} Match 3, 4, or 5 digits

         \\D\\d+ No group: + repeats \\d
         (\\D\\d)+/ Grouped: + repeats \\D\d pair
         ([Rr]uby(, )?)+ Match "Ruby", "Ruby, ruby, ruby", etc.

   */
  def main(args: Array[String]): Unit = {
    val p1 = new Regex("Hello")
    var p2 = "hello".r
    val stringToFind1 = "Hello How are you? Hello  hello Hello hello to many times Again"
    val r1 = p1 findAllIn stringToFind1
    //finalAllIn return ->  scala.util.matching.Regex.MatchIterator = non-empty iterator
    println(r1.mkString(", "))
    val r2 = (p2 findAllIn stringToFind1).mkString(", ")
    println(r2)

    val r3 = p1 findFirstIn stringToFind1 // findFirstIn is the method which will only find the 1st instance of pattern
    println(r3) //returns instance of Some

    var stringToFind2 = "My name is Sam and age is 25 and i earn 2000"
    val p3 = "[0-9]+".r
    var r4 = (p3 findAllIn stringToFind2).mkString(", ")
    println(r4)
    val p4 = "[0-9]{3,}+".r
    var r5 = (p4 findAllIn stringToFind2).mkString(", ")
    println(r5)

    val r6 = (p3 findAllIn stringToFind2).toArray
    r6.foreach(i => println(i))

    val stringToFind3 = "Hello How are you? hello Again"
    val p5= "(H|h)ello".r
    val r7 = (p5 findAllIn stringToFind3).toArray
    println(r7)




    /*
    GetOrElse
    Using Regular expression with getOrElse Function
     */

    val p6 = "HelloAgain".r // Trying to search for Hellooooooo
    val stringToFind4= "Hello How are you? hello Again"
    val r8 = p6 findFirstIn stringToFind4 getOrElse("No Match Found") // it will go in else as
    println(r8)
    val p7 = "Hello".r
    val r9 = p7 findFirstIn stringToFind4 getOrElse("No Match Found") // it will get the value as
    println(r9)

    /*
    Using regular expression with forEach
     */
    val p8 = "(H|h)ello".r
    val stringToFind5 = "Hello How are you? hello Again"
    p8 findAllIn stringToFind5 foreach(d=>println(d))



  }

}
