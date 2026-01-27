# Generics

Allows you to write code that can operate on different data types while providing compile-time type safety.

- Type Safety: Errors are caught at compile time rather than runtime.
- Reusability: Write once, use with different types.
- Eliminates Casts: No need for explicit casting when retrieving elements.

```java
List<String> list = new ArrayList<>();
list.add("Hello");
// list.add(123); // Compile-time error

List<Object> list2 = new ArrayList<>();
list2.add("Hello");
list2.add(123); // No error, but requires casting when retrieving
```

**General Convention**

| Symbol | Stands for   | Common Usage                                       |
| ------ | ------------ | -------------------------------------------------- |
| `T`    | **Type**     | General types (e.g., `Iterable<T>`)                |
| `E`    | **Element**  | Collections/containers (e.g., `List<E>`, `Set<E>`) |
| `K`    | **Key**      | Maps/dictionaries (e.g., `Map<K, V>`)              |
| `V`    | **Value**    | Maps/dictionaries (e.g., `Map<K, V>`)              |
| `N`    | **Number**   | Numeric types                                      |
| `?`    | **Wildcard** | Unknown type (e.g., `List<?>`)                     |

**Generic classes**

```java
class Box<T> {
    private T value;
    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

```java
Box<Integer> intBox = new Box<>();
intBox.set(10);
System.out.println(intBox.get()); // 10
```

If <T> type parameter is declared at class level, it can be used in all methods of the class. If declared at method level, it can only be used within that method.

**Generic methods**

```java
public class Util {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
```

```java
String[] names = {"Alice", "Bob"};
Util.printArray(names);
```

You only need to declare <T> in method signature if the method is static or if the class is not generic.

**Wildcard**  
Is used to specify an unknown type. It is represented by the question mark (?) symbol.

| Feature          | `<T>` (Type Parameter)                    | `?` (Wildcard)                                  |
| ---------------- | ----------------------------------------- | ----------------------------------------------- |
| **Definition**   | Used in generic class/method definitions  | Used in method parameters or field declarations |
| **Type Binding** | Represents a specific type                | Represents an unknown type                      |
| **Reusability**  | Can be reused in the same scope           | Cannot be reused (each `?` is independent)      |
| **Flexibility**  | Less flexible (you must specify the type) | More flexible (can accept multiple types)       |

**Type Inference (Diamond Operator)**  
The Java compiler can infer the type parameters based on the context, allowing you to not explicitly specify them. The diamond operator (<>) is used to simplify the instantiation of generic classes by telling the compiler to infer the type parameters from the variable declaration.

Without diamond operator (before Java 7) - have to repeat the generic type on both sides of the assignment

```java
Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
```

With diamond operator (Java 7 and later)

```java
Map<String, List<Integer>> map = new HashMap<>();
List<String> list = new ArrayList<>();
Set<Double> set = new HashSet<>();
Queue<Float> queue = new LinkedList<>();
Stack<Character> stack = new Stack<>();
```

`()` parentheses are simply the constructor call by invoking the no - argument constructor of the class to create a new empty object.

```java
public Stack() {
    super()
}
```

<> tells the compiler to infer that the HashMap should be parameterized with <String, List< Integer >> based on the variable declaration.

**PECS Rule** - Producer Extends Consumer Super

| Situation                    | Wildcard Syntax | Reason                                | Boundary    |
| ---------------------------- | --------------- | ------------------------------------- | ----------- |
| Producer (read `get` items)  | `? extends T`   | Collection produces `T` or subtypes   | Upper Bound |
| Consumer (write `add` items) | `? super T`     | Collection consumes `T` or supertypes | Lower Bound |

**Producer Extends** - Wildcard ? extends Number so is safe to read as Number but not to write Integer, Double etc. all can extend Number.

```java
public static void printNumbers(List<? extends Number> list) {
    for (Number n : list) {  // Safe to read as Number
        System.out.println(n.doubleValue());
    }
    // list.add(42); Can't add because actual type might be List<Integer>, List<Double>, etc.
}

```

**Consumer Super** - Wildcard ? super Integer so is safe to write as unknown type could be Integer or any of Integer's supertypes but only to read as `Object`.

```java
public static void addIntegers(List<? super Integer> list) {
    list.add(42);  // Safe to add Integer
    Object x = list.get(0); // Only safe to read as Object
}
```

**Type Erasure**  
Generics only exist at compile time to enforce type safety. At runtime, all generic type information is erased
and replaced with their upper bounds (or `Object` if none)

```java
List<String> list = new ArrayList<>();
list.add("hello");
String s = list.get(0);
```

After compilation...

```java
List list = new ArrayList(); // type argument removed
list.add("hello");
String s = (String) list.get(0); // compiler inserts cast
```

So

- No Runtime Type Information - can't check `if (list instanceof List<String>` as it's erased to just `List` at runtime
- No Primitive Type Parameters - `List<int>` is not allowed, needs `Integer` wrapper
- Overloading restrictions - after erasure both become `process(List)`
  ```java
    void process(List<String> a) {}
    void process(List<Integer> a) {}
  ```
