## Performance Dimensions

- **Time** - Measures how the execution time of an algorithm increases with input size. The amount of processing has to perform to complete the task.

- **Space** - Measures how the memory usage of an algorithm increases with input size. The memory needed to store data at runtime as well as disk space needed for persistent storage.

- **Network** - Measures how the data transfer requirements of an algorithm increase with input size. The amount of data that needs to be sent or received over a network to complete the task.

**Complexity Analysis**: The measure of how the resource requirements of an algorithm grow as the input size increases. It helps in understanding the efficiency and scalability of algorithms.

**Time Complexity**: A way to express the amount of time (usually the worst-case) an algorithm takes to complete as a function of the length of the input. It is often expressed using Big O notation.

## Big O Notation

Big O Notation is used to describe the time complexity and space complexity of an algorithm. It tells you how the runtime or memory usage grows relative to input size (n). The growth rate of a function is also referred to as its order of growth.

- Helps compare algorithms’ efficiency.
- Focuses on worst-case performance.
- Ignores machine-specific constants.

Example: If sorting n = 1,000,000 elements,

- An O(n log n) algorithm might finish in seconds.
- An O(n²) algorithm might take hours.

| Big O          | Name         | Example Scenario                           |
| -------------- | ------------ | ------------------------------------------ |
| **O(1)**       | Constant     | Accessing an array element by index        |
| **O(log n)**   | Logarithmic  | Binary search                              |
| **O(n)**       | Linear       | Traversing an array                        |
| **O(n log n)** | Linearithmic | Merge sort, quicksort (average case)       |
| **O(n²)**      | Quadratic    | Nested loops (bubble sort, insertion sort) |
| **O(2ⁿ)**      | Exponential  | Recursive Fibonacci                        |
| **O(n!)**      | Factorial    | Generating all permutations                |

![BigO.png](../../../../resources/BigO.png)

**Constant Time Complexity - O(1)**: The execution time remains constant regardless of the input size. Example: Accessing an element in an array by index.

```java
int getElement(int[] array, int index) {
    return array[index];
}
```

```java
for (int i = 0; i < 3; i++) {
    System.out.println(i);
}
```

No mattter how large the input is, the loop runs exactly 3 times.

**Linear Time Complexity - O(n)**: The execution time increases linearly with the input size. Example: Traversing an array.

```java
void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
        System.out.println(array[i]);
    }
}
```

The number of operations grows directly with the size of the input array.

**Quadratic Time Complexity - O(n²)**: The execution time increases quadratically with the input size. Example: Nested loops.

```java
void printPairs(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[i] + ", " + array[j]);
        }
    }
}
```

**Logarithmic Time Complexity - O(log n)**: The execution time increases logarithmically with the input size. Example: Binary search.

```java
public class BinarySearchExample {

    public static int binarySearch(int[] arr, int target) {
        int left = 0; // start index of the array
        int right = arr.length - 1; // end index of the array

        // Continue searching while the left index is less than or equal to the right index
        while (left <= right) {
            int mid = left + (right - left) / 2; // calculate the mid index

            if (arr[mid] == target) {
                return mid;  // target found mid index
            }

            if (arr[mid] < target) {
                left = mid + 1;   // current mid < target, search right half
            } else {
                right = mid - 1;  // current mid > target, search left half
            }
        }

        return -1;  // target not found
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10, 12, 14, 16};
        int target = 10;

        int index = binarySearch(numbers, target);
        System.out.println("Index of " + target + ": " + index);
    }
}
```

Binary search operates on a sorted array and reduces the search space by half with each iteration, leading to logarithmic time complexity.

```scss
Index: 0  1  2  3  4  5  6  7
Value: 2  4  6  8 10 12 14 16
```

Target: 10

1. Initial array: `[2, 4, 6, 8, 10, 12, 14, 16]`
   - Left = 0, Right = 7
   - Mid = (0 + 7) / 2 = 3 → Value = 8 (8 < 10)
   - New Left = Mid + 1 = 4
2. New array segment: `[10, 12, 14, 16]`
   - Left = 4, Right = 7
   - Mid = (4 + 7) / 2 = 5 → Value = 12 (12 > 10)
   - New Right = Mid - 1 = 4
3. New array segment: `[10]`
   - Left = 4, Right = 4
   - Mid = (4 + 4) / 2 = 4 → Value = 10 (10 == 10)
   - Target found at index 4

| Iteration | Elements left | Equation      |
| --------- | ------------- | ------------- |
| 0         | 16            | n             |
| 1         | 8             | n/2           |
| 2         | 4             | n/4 = n / 2²  |
| 3         | 2             | n/8 = n / 2³  |
| 4         | 1             | n/16 = n / 2⁴ |

Stop iterating when `n / 2^k = 1` => `n = 2^k` => `k = log₂(n)`

**Exponential Time Complexity - O(2ⁿ)**: The execution time doubles with each additional input element. Example: Recursive Fibonacci.

```java
public class Fibonacci {

    static long calls = 0;

    static int fib(int n) {
        calls++;                 // Count number of calls
        if (n <= 1) return n;    // Base cases
        return fib(n - 1) + fib(n - 2);  // Recursive branching
    }

    public static void main(String[] args) {
        for (int n = 0; n <= 10; n++) {
            calls = 0;
            fib(n);
            System.out.println("n = " + n + ", calls = " + calls);
        }
    }
}
```

Naive recursive Fibonacci algorithm follows this pattern:

```scss
fib(n)
 ├── fib(n-1)
 │     ├── fib(n-2)
 │     └── fib(n-3)
 └── fib(n-2)
       ├── fib(n-3)
       └── fib(n-4)
```

Each time you compute `fib(n)`, it makes two calls: `fib(n-1)` and `fib(n-2)`. This branching leads to an exponential growth in the number of calls as n increases, resulting in O(2ⁿ) time complexity.

**Factorial Time Complexity - O(n!)**: The execution time grows factorially with the input size. Example: Generating all permutations.

```java
public class FactorialTime {

    static long calls = 0;

    static void permute(String str, String answer) {
        calls++;  // count recursion calls

        // base case: full permutation formed
        if (str.length() == 0) {
            // System.out.println(answer);
            return;
        }

        // recursion: choose each character as the next in permutation
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String rest = str.substring(0, i) + str.substring(i + 1);
            permute(rest, answer + ch);
        }
    }

    public static void main(String[] args) {
        String s = "ABC";  // 3! = 6 permutations
        permute(s, "");
        System.out.println("Total calls = " + calls);
    }
}
```

The recursive permutation generation algorithm explores all possible arrangements of the input string. For a string of length n, there are n! (n factorial) permutations. The recursion tree for generating permutations of "ABC" looks like this:

```
             "ABC"                 (starting)
      /        |        \
     A         B         C       (3 choices)
   /  \       /  \      /  \
  B    C     A    C    A    B   (2 choices)
  |    |     |    |    |    |
  C    B     C    A    B    A   (1 choice)
```

Total number of calls:

- Level 0: 1 call
- Level 1: n calls (3)
- Level 2: n\*(n-1) calls (6)
- Level 3: n*(n-1)*(n-2) calls (6)
- ...
- Level n: n! calls
