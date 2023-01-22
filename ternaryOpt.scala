
//~ A simple Scala program to demonstrate ternary conditional operation and function call in Scala 
object ternaryOpt {
  def main(args: Array[String]): Unit = {
    var result = checkIt(-5)
    println(s"For -5 : $result")

    result = checkIt(4)
    println(s"For 4 : $result")
  }
  // similar to Python's ternary operation only the condition being at first rather than in the middle
  def checkIt(a: Int) = if (a >= 0) "Positive" else "Negative"
}
