
//~ A simple Scala program to accept 3 numbers and find the max. amongst them 
object maxOfThree {
  def main(args: Array[String]): Unit = {
    print("Enter value of A: ")
    // Scala's method to take input, similar to Java's Scanner
    var a = scala.io.StdIn.readInt()
    print("Enter value of B: ")
    var b = scala.io.StdIn.readInt()
    print("Enter value of C: ")
    var c = scala.io.StdIn.readInt()
    // Everything in Scala is an object so inbuilt functions are called upon objects
    var max = (a).max(b)
    max = (max).max(c)
    println(s"\nMax of Three is: $max")
  }
}
