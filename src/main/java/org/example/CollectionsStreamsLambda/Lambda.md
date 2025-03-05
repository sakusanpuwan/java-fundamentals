## Lambda Expressions
Lambda expressions are a feature introduced in Java 8 that allows you to write concise and expressive code by defining anonymous functions. Lambda expressions are used to implement functional interfaces, which are interfaces with a single abstract method (SAM). Lambda expressions provide a way to pass behavior as an argument to a method, making your code more flexible and modular.

### Supplier
does not take in an argument and returns any type of value
```java
public interface Supplier<T> {
    T get(); // Abstract method with no parameter returning a value of generic type
}


Supplier<String> stringSupplier = () -> "Hello, World!";
System.out.println(stringSupplier.get()); // Outputs: Hello, World!
```
where T is the generic type parameter.

### Consumer
takes in an argument of any type and returns void
```java
public interface Consumer<T> {
    void accept(T t); // Abstract method with 1 parameter returning void
}


Consumer<String> consumer = (String s) -> {
    System.out.println(s);
    System.out.println("Another line");
    };
        
        ;
System.out.println(consumer.accept("Hello")); // Outputs: Hello!
```
### Predicate
takes in an argument of any type and returns a boolean
```java
public interface Predicate<T> {
    boolean test(T t); // Abstract method with 1 parameter returning a boolean
}

Predicate<String> isEmpty = s -> s.isEmpty();
System.out.println(isEmpty.test("")); // Outputs: true
```

### Function
takes in an argument of one type and returns a value of another type
```java
public interface Function<T, R> {
    R apply(T t); // Abstract method with 1 parameter returning a value of generic type
}

Function<User, String> getName = user -> user.getName();
```

where T is the input type and R is the output type.

### Runnable
does not take in an argument and returns void
```java
public interface Runnable {
    void run(); // Abstract method with no parameter returning void
}

Runnable runnable = () -> System.out.println("Hello, World!");
runnable.run(); // Outputs: Hello, World!
``` 

### Example
```java
List<String> strings = new ArrayList<>(List.of("A", "B", "C", "D", "E"));

Predicate<String> filter = string -> string.startsWith("A");
strings.removeIf(filter);
strings.removeIf(string -> string.startsWith("A")); // Inline

Consumer<String> action = string -> System.out.println(string);
strings.forEach(action);
strings.forEach(string -> System.out.println(string)); // Inline

```

### Comparator
```java 
Comparator<Product> byWeight = (product1, product2) -> product1.getWeight() - product2.getWeight();
List<Product> products = new ArrayList<>(List.of(new Product("A", 10), new Product("B", 20), new Product("C", 30)));
products.sort(byWeight);
```