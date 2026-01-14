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

## Pass by Value vs Pass by Reference

In Java, all method arguments are passed by value. This means that when you pass a variable to a method, you are passing a copy of the variable's value, not the actual variable itself. This applies to both primitive data types (like int, char, etc.) and reference data types (like objects and arrays). However for objects and arrays, the "value" being passed is the reference (memory address) to the object, not the object itself.

```java
public class Main {
    static void modify(int a) {
        a = a + 10;
    }

    public static void main(String[] args) {
        int x = 5;
        modify(x);
        System.out.println(x); // Output: 5
    }
}
```

In this example, the value of `x` remains `5` after calling `modify(x)` because a copy of `x` is passed to the method. Modifying `a` inside the method does not affect `x`.

```java
class Wrapper {
    int value = 5;
}

public class Main {
    static void modify(Wrapper obj) {
        obj.value += 10;
    }

    public static void main(String[] args) {
        Wrapper w = new Wrapper();
        modify(w);
        System.out.println(w.value); // Output: 15
    }
}
```

In this example, the `modify` method receives a copy of the reference to the `Wrapper` object. When we modify the `value` field of the object inside the method, it affects the original object because both the original reference and the copied reference point to the same object in memory.
