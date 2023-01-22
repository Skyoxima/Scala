
//~ A simple Scala program to check if a number is prime or not
//!
/* The return value of a function in Scala works like this:
  The value of the last expression is returned from a function
  So here in isPrime, the if-else is the only and last expression in the function and the value it arrives to (in each case) is what is returned
*/
// There is a concept of sieve of eratosthenes which is ancient but interesting way of finding out prime numbers
//!

object checkPrime {
  def main(args: Array[String]): Unit = {
    print("Enter to check till which number: ")
    var a = scala.io.StdIn.readInt()
    var prime: Boolean = false;
    for (i <-1 to a){
      prime = isPrime(i)
      if (prime)
        println(s"$i is Prime")
      else 
        println(s"$i is not Prime")
    }

    
  }

  def isPrime(num: Int): Boolean = {
    if(num <= 1)
      false
    else if(num == 2)
      true
    else
      !(2 until num).exists(x => num % x == 0)    // Similar to JavaScript's 'some' and Python's 'in'  
  }
}
