//~ A simple Scala program to get introduced to preconditions in Scala
// Pre-conditions are used for "validation" with the two most used being assert and require
// assert is a "curative" method (different paradigm of validation) and throws Errors
// require is a "preventive" method and throws Exceptions, hence difference between assert and require take into account difference between Errors and Exception 

// https://www.baeldung.com/scala/assert-vs-require#:~:text=assert%20is%20commonly%20used%20to,the%20behavior%20of%20exception%20thrown.
// https://stackoverflow.com/questions/912334/differences-between-exception-and-error
class preconditionExamples {
  def application_verification(): String = {
    print("Enter applicant age: ");
    val age = scala.io.StdIn.readInt();
    try {
      require(age >= 21);         //! throws IllegalArgumentException! Exceptions can be handled hence it is suitable for checking arguments at runtime to be valid (compliant to the condition passed)
    } catch {
      case e: IllegalArgumentException => return "\u001b[38;5;197mUnderage Applicant! Application Rejected!\u001b[0m";
    }
    "\u001b[38;5;89mApplication Verified!\u001b[0m";
  }
  
  // private def cubeCalculation(n: Int): Int = n * n * n;     // faulty
  private def cubeCalculation(n: Int): Int = if(n >= 0) n * n * n else -(n * n * n); // corrected, after testing and assertion failing
  def getNumCubeModulus(n: Int): Int = {
    assert(cubeCalculation(-2) == 8);    //! asserts that the private function above is working correctly, only then the function is used for the argument passed otherwise the execution stops cause it throws an Error which is not the job of our program to handle (sort of like a punishment that assertion has failed and a fool was made)
    // Here I've created a function which should always have retuned me positive (absolute) values of cube of input (even if input is -ve) and if I only write n * n * n then it won't do, I have to handle the negative results of that expression. This can be checked with assert while testing the program
    // also asserts do increase computation time but for a program to be deployed, while compiling assertions can be disabled in the cmd command (if statements cannot be) and that is an advantage of using assertions than ifs
    val squaredNum = cubeCalculation(n);
    squaredNum;
}
}

object preconditions {
  def main(args: Array[String]): Unit = {
    var pE = new preconditionExamples();
    println("Demo of Require:");
    println(pE.application_verification());
    println("Demo of Assert:");
    print("Enter a number to find its absolute cube value: ")
    val num = scala.io.StdIn.readInt();
    println(s"Absolute Cube of $num is: ${pE.getNumCubeModulus(num)}");
  }
}