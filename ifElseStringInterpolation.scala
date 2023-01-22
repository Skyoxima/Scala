//~ A simple Scala program to demonstrate Scala's if-else block and String Interpolation feature
object ifElseStringInterpolation {
  //: Unit is the return type, Scala equivalent of void of other languages
  def main(args: Array[String]): Unit = {
    var number: Int = 21
    if (number % 2 == 0) {
      println(s"$number is Even")     // This is string interpolation, there are different types of it, using f and r as prefixes
    } else {
      println(s"$number is Odd")
    }
  }
}
