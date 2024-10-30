An exception is an unexpected event, which occurs during the execution of a program, that disrupts the expected flow of the program's instructions.

In Java, exceptions are objects that can be thrown by code that encounters an unexpected situation. An exception may also be caught by a surrounding block of code that “handles” the problem in an appropriate fashion.

Some examples of typical conditions where an exception occurs:
* User inputs invalid data
* File requested does not exist in specified file path
* When Java Virtual Machine (JVM) runs out of memory
* Network drops during communication 

Try-catch statement
```java
try {
    Code
} catch (exceptionType variable ) {
    Code
} catch (exceptionType variable) {
    Code
}  
```

```java
public class Main {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            int result = numbers[4]; // Trying to access an out-of-bounds index
            System.out.println("Result: " + result); // This line will not be executed
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Exception caught: ArrayIndexOutOfBoundsException");
        }
    }
} 
```

Exceptions throws an exception object so this could be used to throw exception ourselves and specify the expected exception type and handling message & code 
```java
public class Main {
    public static void main(String[] args) { 

        try {
            int result = divide(10, 0); // Division by zero
            System.out.println("Result: " + result); // This line will not be executed
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }
    } 
    
    public static int divide(int numerator, int denominator) throws Exception {
        if (denominator == 0) {
            throw new Exception("Cannot divide by zero");
        }
        return numerator / denominator;
    }
} 
```
Checked exceptions (Extend Exception) - compile-time exceptions as these exceptions are checked by the compiler during the compilation process to confirm whether the exception is handled by the programmer or not. If not, then the system displays a compilation error

* SQLException - occurs while executing queries on a database related to the SQL syntax

* IOException - occurs while using file I/O stream operations

* InvocationTargetException -

* ClassNotFoundException - JVM (Java Virtual Machine)  is not able to find the required class

Unchecked exception (Extend RuntimeException) – runtime exceptions that occur during the execution of the program

* NullPointerException - occurs when you try to access an object with the help of a reference variable whose current value is null or empty

* ArrayIndexOutofBound - occurs when you try to access an array with an invalid index value

* IllegalArgumentException - occurs whenever an inappropriate or incorrect argument is passed to a method

* IllegalStateException - occurs when the state of the environment does not match the operation being executed

* NumberFormatException - occurs when you pass a string to a method that cannot be converted to a number

* ArithmeticException - occurs when you perform an incorrect arithmetic operation 