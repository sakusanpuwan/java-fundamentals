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
