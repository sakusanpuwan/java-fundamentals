# String

Type of object can can store a sequence(array) of characters enclosed by double quotes. Every character is stored in 16 bits.

**String literal**

```java
String s1 = "Hello";
String s2 = "Hello";
```

- Stored in static memory in the String Constant Pool (SCP) part of the Java Heap
- SCP ensures identical string literals are not duplicated and reuses existing literals to save memory
- `s1` and `s2` both refer to the same memory location
- `s1 == s2` returns true as both same reference
- `s1 === s2` returns true due to equality

**String object**

```java
String s3 = new String("Hello");
String s4 = new String("Hello");
```

- Each `new String()` call creates a brand-new distinct String object on the heap, even if an identical literal already exists on the SCP
- The literal "Hello" is placed in the SCP (if not already there) but the `new` String object is a separate copy
- `s3 == s4` returns false as different heap objects

String is an immutable class in Java, meaning once a String object is created, its value cannot be changed. Any changes will create a new String object with the original remaining unchanged.

```java
String s1 = "Hello";
s1.concat(" World");

System.out.println(s1); // Output: Hello
```

`concat()` returns a new String instead of modifying `s1` so output is still "Hello".

```java
String s2 = s1.concat(" World");
System.out.println(s2); // Output: Hello World
```

`s2` is a new String object which points to "Hello World" and `s1` still points to "Hello"

Methods like `concat()`,`substring(), `replace()` actually create a new String object, return the new Object and leave the original unchanged.

**StringBuffer**

- Mutable - content can be changed without creating new String objects
- Thread - Safe - all methods are synchronised
- Slower than `StringBuilder` because of synchronisation overhead

```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb); // Output: Hello World
```

**StringBuilder**

- Mutable - content can change without creating new objects
- Not thread - safe - no synchronisation / use in single - threaded environments
- Offers better performance than string manipulation

```java
    StringBuilder sb = new StringBuilder("Hello");
    sb.append(" World");
    System.out.println(sb);
```

append() method modifies the existing object directly without creating a new one

| Feature     | String                                            | StringBuilder                               | StringBuffer                                     |
| ----------- | ------------------------------------------------- | ------------------------------------------- | ------------------------------------------------ |
| Mutability  | Immutable — creates new objects on modification   | Mutable — modifies in place                 | Mutable — modifies in place                      |
| Thread-Safe | Yes (immutable, inherently thread-safe)           | No (not thread-safe)                        | Yes (synchronized, thread-safe)                  |
| Performance | Slower — creates new objects on each modification | Fast — no object creation, good performance | Slower than StringBuilder due to synchronization |
| Use Case    | Fixed, unchanging strings                         | Single-threaded string manipulation         | Multi-threaded string manipulation               |
