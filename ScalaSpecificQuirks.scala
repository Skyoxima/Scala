//~ Scala program of all the Scala-specific (not in Java) features/quirks
class ScalaQuirks {
  def anonymousFunction(num1: Int, num2: Int): Unit = {
    var twoDigitSum = (a: Int, b: Int) => a + b;    // very similar to JavaScript's Arrow Function
    var anotherTwoDigitSum = (_: Int) + ( _: Int);
    println(s"By \"Arrow\" notation, $num1 + $num2 = ${twoDigitSum(num1, num2)}");
    println(s"By \"_\" notation, $num1 + $num2 = ${anotherTwoDigitSum(num1, num2)}");
  }
  
  // Similar to Python's Argument Spread
  def argsSpread(args: Int*): Int = {
    var sum = 0;
    for (a <- args) {
      sum += a;
    }
    sum;
  }
  
  // Any higher order function(hof) will take in a function as a parameter and syntax here signifies 
  def hOFInt(func: Int => Int, num: Int): Int = {
    func(num);
  }

  // https://www.geeksforgeeks.org/what-is-currying-function-in-javascript/ JS yes, still helpful in understanding currying here
  // I can see currying being useful in higher order "lambda"/anon functions?
  def curryingBasedAddition(a: Int)(b: Int): Int = {
    a + b;
  }
}

object ScalaSpecificQuirks {
  def fourthPower(i: Int): Int = {
    i * i * i * i;
  }

  def main(args: Array[String]): Unit = {
    var sq = new ScalaQuirks();
    println("\u001b[38;5;225m====== Anonymous Function ======\u001b[0m");
    print("Enter 2 numbers(Integers) to find their sum: ")
    val n1: Int = scala.io.StdIn.readInt(); 
    val n2: Int = scala.io.StdIn.readInt(); 
    sq.anonymousFunction(n1, n2);
    println("\u001b[38;5;225m====== Argument Spread ======\u001b[0m");
    println("1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = " + sq.argsSpread(1, 2, 3, 4, 5, 6, 7, 8, 9));
    println("\u001b[38;5;225m====== Higher Order Function ======\u001b[0m");
    println(s"20 x 20 = ${sq.hOFInt((a) => a * a, 20)}");
    println(s"20 x 20 x 20 = ${sq.hOFInt((a) => a * a * a, 20)}");
    println(s"20 x 20 x 20 x 20 = ${sq.hOFInt(fourthPower, 20)}");
    println("\u001b[38;5;225m====== Currying ======\u001b[0m");
    println(s"Full Call: 10 + 20 = ${sq.curryingBasedAddition(10)(20)}");
    var halfAdd = sq.curryingBasedAddition(10)_;
    var sum = halfAdd(20);
    println(s"After 2 half calls: 10 + 20 = $sum");
  }
}