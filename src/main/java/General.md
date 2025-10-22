## Command Line Arguments
Used to provide input at runtime without modifying the whole program.

```text
java Hello World
```

_Hello_ and _World_ are space separated command line arguments. The JVM will collect these words and pass these arguments 
to the main method as an array of strings called `args`. 

```java
public static void main(String[] args) {
    System.out.println(args[0]); //Hello
    System.out.println(args[1]); //World
}
```