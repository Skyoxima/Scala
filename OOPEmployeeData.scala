//~ A simple Scala program to implement a basic Employees record at a company 
import scala.collection.immutable.HashMap;
import java.{util => ju}

class Employee(empID: String) {
  private var empDatabase: HashMap[String, List[String]] = HashMap(
    "1xAA" -> List("Samarth Tumdi", "Junior Web Developer", "1,000,000"),
    "1xAB" -> List("Skyoxima Altarys", "Senior Machine Learning Engineer", "10,000,000"),
    "1xAC" -> List("Nemo Altarys", "Web Development Intern", "20,000"),
    "1xAD" -> List("Amongus Sus", "Menace", "-99,999"));
  private var empName: String = empDatabase(empID)(0);
  private var empDesignation: String = empDatabase(empID)(1);
  private var empSalary: String = empDatabase(empID)(2);
  
  def showEmployee(): Unit = {
    println(s"Employee ID: $empID");
    println(s"Employee Name: $empName");
    println(s"Employee Designation: $empDesignation");
    println(s"Employee Salary: $empSalary");
  }
}

object OOPEmployeeData {
  def main(args: Array[String]): Unit = {
    // println(args)
    print("Enter Employee ID: ");
    var emp: Employee = null;               // parenthesis are optional
    var cycle: Boolean = true;
    var empName: String = scala.io.StdIn.readLine();
    try {
      emp = new Employee(empName);
      emp.showEmployee();
      return;
    } catch {
      case no: ju.NoSuchElementException => {
        println("\u001b[38;5;197mInvalid ID!\u001b[0m");
        print("Try Again? (Y/N): ")
        if(scala.io.StdIn.readLine() == "Y") { OOPEmployeeData.main(null); }
      }
    }
  }
}