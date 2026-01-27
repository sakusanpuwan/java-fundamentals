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

String newStr = String.valueOf(charArray); // Convert char array back to string

boolean IsEmpty = str.isEmpty(); // Check for empty String

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

newStr.delete(startIndex,endIndex)

newStr.deleteCharAt(index)

Use .equals to compare strings not == or !=

new StringBuilder(word).reverse().toString();
```

```Java
//Check if string contains values from aA - zZ
boolean containsAlphabeticChar = str.matches(".*[a-zA-Z].*");
```

`.split()` to convert a string into an array based on a delimiter

```Java
String str = "apple,banana,cherry";
String[] fruits = str.split(","); // ["apple", "banana", "cherry"]
```

**Scanning characters in a string**

```java
for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    // Process each character
}
```

**Pattern Matching in Strings**

Manual checking each character:

```java
charAt(i)
Character.isDigit(c)
Character.isLetter(c)
Character.isLetterOrDigit(c)
Character.isWhitespace(c)
Character.isUpperCase(c)
Character.isLowerCase(c)
```

Regex pattern matching:

| Symbol   | Meaning                          |
| -------- | -------------------------------- |
| `.`      | any character                    |
| `\d`     | digit                            |
| `\w`     | word (letter, digit, underscore) |
| `\s`     | whitespace                       |
| `[abc]`  | any of a/b/c                     |
| `[^abc]` | not a/b/c                        |
| `+`      | 1 or more                        |
| `*`      | 0 or more                        |
| `?`      | 0 or 1                           |
| `{m,n}`  | between m and n repeats          |
| `^`      | start                            |
| `$`      | end                              |

## Regex

Regular Expressions (Regex) is a way to define string patters for searching, validating and manipulating text.
Used in email validation, password strength checking, text replacement.

```java
    String input = "Email: test@example.com";
    Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
    Matcher matcher = pattern.matcher(input);

    if (matcher.find()) {
        System.out.println("Found email: " + matcher.group());
    } else {
        System.out.println("No email found.");
    }
```

**Pattern**
Pattern class compiles a regex string into pattern objects.

- `Pattern pattern = Pattern.compile("regex");` - compiles regex into new pattern
- `Matcher matcher = pattern.matcher("input");` - creates matcher for input string
- `boolean isMatch = Pattern.matches("\\d+", "123"); // true` - checks if entire input matches regex
- ```java
    Pattern splitPattern = Pattern.compile(",");
    String[] parts = splitPattern.split("a,b,c");
  ```
  splits input based on regex

**Matcher**
Matcher class performs matching operations for input strings.

- `find()` - finds next subsequence matching the pattern

  ```java
  Matcher matcher = Pattern.compile("\\d+").matcher("There are 123 apples");

  if (matcher.find()) {
      System.out.println("Found number: " + matcher.group()); // 123
  }
  ```

- `group()` - returns the matched subsequence
  ```java
  Pattern p = Pattern.compile("(\\w+)@(\\w+\\.\\w+)");
  Matcher m = p.matcher("Contact: test@example.com");
  if (m.find()) {
      System.out.println("Full match: " + m.group());      // test@example.com
      System.out.println("Username: " + m.group(1));       // test
      System.out.println("Domain: " + m.group(2));         // example.com
      System.out.println("Group count: " + m.groupCount()); // 2
  }
  ```
- `matches()` - checks if entire input matches the pattern
  ```java
  Matcher m2 = Pattern.compile("\\d+").matcher("123");
  boolean isFullMatch = m2.matches(); // true
  ```

**Regex Patterns**

- [xyz]: Matches x, y, or z
- [^xyz]: Matches any character except x, y, or z
- [a-zA-Z]: Matches any character in the specified range
- X?: X appears 0 or 1 time
- X+: X appears 1 or more times
- X\*: X appears 0 or more times
- X{n}: X appears exactly n times
- X{n,}: X appears n or more times
- X{n,m}: X appears between n and m times
- \d : Digit [0-9]
- \D : Non-digit
- \s : Whitespace
- \S : Non-whitespace
- \w : Word character [a-zA-Z0-9_]
- \W : Non-word character
- \b : Word boundary
- \B : Non-word boundary

### Regex Pattern Examples

```java
// [xyz]: Matches x, y, or z
Matcher m1 = Pattern.compile("[xyz]").matcher("abcxyz");
while (m1.find()) {
    System.out.println(m1.group()); // x, y, z
}

// [^xyz]: Matches any character except x, y, or z
Matcher m2 = Pattern.compile("[^xyz]").matcher("abcxyz");
while (m2.find()) {
    System.out.print(m2.group()); // a b c

// [a-zA-Z]: Matches any character in the specified range
Matcher m3 = Pattern.compile("[a-zA-Z]").matcher("A1b2C3");
while (m3.find()) {
    System.out.print(m3.group()); // A b C

// X?: X appears 0 or 1 time
Matcher m4 = Pattern.compile("a?").matcher("aaab");
while (m4.find()) {
    System.out.print(m4.group()); // a a a (and empty matches)

// X+: X appears 1 or more times
Matcher m5 = Pattern.compile("a+").matcher("aaab");
while (m5.find()) {
    System.out.println(m5.group()); // aaa

// X*: X appears 0 or more times
Matcher m6 = Pattern.compile("a*").matcher("aaab");
while (m6.find()) {
    System.out.print(m6.group()); // a a a (and empty matches)

// X{n}: X appears exactly n times
Matcher m7 = Pattern.compile("a{2}").matcher("aaab");
while (m7.find()) {
    System.out.println(m7.group()); // aa

// X{n,}: X appears n or more times
Matcher m8 = Pattern.compile("a{2,}").matcher("aaaab");
while (m8.find()) {
    System.out.println(m8.group()); // aaaa

// X{n,m}: X appears between n and m times
Matcher m9 = Pattern.compile("a{2,3}").matcher("aaaaab");
while (m9.find()) {
    System.out.println(m9.group()); // aaa, aa

// \d : Digit [0-9]
Matcher m10 = Pattern.compile("\\d").matcher("a1b2c3");
while (m10.find()) {
    System.out.print(m10.group()); // 1 2 3

// \D : Non-digit
Matcher m11 = Pattern.compile("\\D").matcher("a1b2c3");
while (m11.find()) {
    System.out.print(m11.group()); // a b c

// \s : Whitespace
Matcher m12 = Pattern.compile("\\s").matcher("a b\tc");
while (m12.find()) {
    System.out.print(m12.group()); // (space) (tab)

// \S : Non-whitespace
Matcher m13 = Pattern.compile("\\S").matcher("a b\tc");
while (m13.find()) {
    System.out.print(m13.group()); // a b c

// \w : Word character [a-zA-Z0-9_]
Matcher m14 = Pattern.compile("\\w").matcher("a_b@1");
while (m14.find()) {
    System.out.print(m14.group()); // a _ b 1

// \W : Non-word character
Matcher m15 = Pattern.compile("\\W").matcher("a_b@1");
while (m15.find()) {
    System.out.print(m15.group()); // @

// \b : Word boundary
Matcher m16 = Pattern.compile("\\bcat\\b").matcher("cat scatter category");
while (m16.find()) {
    System.out.println(m16.group()); // cat

// \B : Non-word boundary
Matcher m17 = Pattern.compile("\\Bcat\\B").matcher("scat category");
while (m17.find()) {
    System.out.println(m17.group()); // cat (from scat, category)
```

**Character Array**
```java
int[] charCount = new int[256]; // ASCII character set
for (int i = 0; i < str.length(); i++) {
    charCount[str.charAt(i)]++;
}
```

