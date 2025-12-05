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

```Java
// Create String using literal

String newString = "Hello";

// Create String using new keyword

String newString = new String("Hello");
```

```Java
str == str1 // compare the address not value;

String newStr = str.equals(str2); // compares the values

String newStr = str.equalsIgnoreCase() // compares the values ignoring their case

int length = str.length() // calculates length

String newStr = "*".repeat(5) // returns *****

char character = str.charAt(1) // extract i'th character

String newStr = str.toUpperCase() // returns string in ALL CAPS

String newStr str.toLowerCase() // returns string in ALL LOWERCASE

String newStr = str.replace(oldVal, newVal) // search and replace

String newStr = str.trim() // trims surrounding whitespace

boolean containsValue = str.contains("value"); // Check for the values

boolean containsChar = str.contains(char + ""); // Check if string contains specific char

boolean containsChar = str.contains(Character.toString(char)); //Check if string contains specific char

char[] charArray = str.toCharArray(); // Convert into character array

boolean IsEmpty = str.IsEmpty(); // Check for empty String

boolean endsWith = str.endsWith("value"); // Checks if string ends with the given suffix

String[] characters = str.split(""); // Splits string into array of char

String[] stringArray = str.split(" "); // Splits string into array of strings with delimiter " "

String joinedString = String.join("", stringArray); // Joins together strings from array

String substring = str.substring(start, end); // Creates substring from startIndex(inclusive) to endIndex(exclusive)

String str = new String(charArray); // Joins together chars from array

String str = String.format("%s, %s and %d others like this", "A", "B", 2);

String str = String.format("(%d%d%d) %d%d%d-%d%d%d%d",
                numbers[0], numbers[1], numbers[2],
                numbers[3], numbers[4], numbers[5],
                numbers[6], numbers[7], numbers[8], numbers[9]);

```

```Java
// Instead of newStr += "addToString"

StringBuilder newStr = new StringBuilder();

newStr.append("");

newStr.append(char sequence,startIndex,endIndex)

Use .equals to compare strings not == or !=

new StringBuilder(word).reverse().toString();
```

```Java
//Check if string contains values from aA - zZ
boolean containsAlphabeticChar = str.matches(".*[a-zA-Z].*");
```
