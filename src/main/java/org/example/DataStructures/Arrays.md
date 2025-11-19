# Arrays

A linear data structure that allows multiple values of the same type to be stored. `Arrays` is a utility class that extends `Object`.

- Store Primitives and Objects: Java arrays can hold both primitive types (like int, char, boolean, etc.) and objects (like String, Integer, etc.)
- Contiguous Memory Allocation When we use arrays of primitive types, the elements are stored in contiguous locations. For non primitive types, references of items are stored at contiguous locations.
- Zero-based Indexing: The first element of the array is at index 0.
- Fixed Length: After creating an array, its size is fixed; we can not change it.

![PrimitiveArray.png](../../../../resources/PrimitiveArray.png)
![NonPrimitiveArray.png](../../../../resources/NonPrimitiveArray.png)

**Declaring an Array**

```java
int arr[];
```

Just tells compiler this variable `arr` will hold an array of integers

**Initialisation of an Array**

```java
int arr[] = new int[size];
```

Reference of an array is created with `new`, JVM allocates memory for an array of a given `size` in the heap.

The array size is dynamically allocated (decided at runtime not compile time) but statically fixed (cannot be changed).

**Declare and Initialise**

```java
int intArr[] = { 10, 20, 15, 22, 35 };
```

**Multidimensional Array**

```java
int[][] arr = new int[1][3];

arr[0][0] = 3;
```

```java
int[][] arr = { { 1, 2 }, { 3, 4 } };
```

**Methods**

- `Arrays.asList()` - convert array to list
- `Arrays.binarySearch()` - `O(log(n))` - searches for element in a sorted array using binary search
- `Arrays.equals()` - `O(n)` - must compare each element in array
- `Arrays.sort()` - `O(nlog(n))` - sorts an array in ascending order

| Operation       | Complexity          | Why                    |
| --------------- | ------------------- | ---------------------- |
| Access by index | **O(1)**            | Direct addressing      |
| Update element  | **O(1)**            | Direct addressing      |
| Insert at end   | **O(1)** (if space) | Just assign            |
| Insert at index | **O(n)**            | Need to shift elements |
| Delete at index | **O(n)**            | Need to shift elements |
| Search unsorted | **O(n)**            | Must scan all          |
| Search sorted   | **O(log n)**        | Binary search          |

`Arrays` vs `ArrayList`
| Feature | Arrays | ArrayList |
| --------------------- | -------------------------- | ------------------------------ |  
| Size | Fixed size | Dynamic size |
| Type | Can hold primitives or objects | Can only hold objects |
| Performance | Faster for fixed size data | Slightly slower due to resizing (copies to new array `O(n)`) |

---

**Null pointers**  
An array variable that has not been initialized points to `null`. Accessing or modifying elements of such an array will result in a `NullPointerException`.

```java
int[] arr;
arr = new int[5]; // Now arr points to an array of size 5
```

---

**Out-of-bounds Access**  
Accessing an index outside the valid range (0 to length-1) of the array will throw an `ArrayIndexOutOfBoundsException`.

```java
int[] arr = new int[3];
int value = arr[5]; // This will throw ArrayIndexOutOfBoundsException
int value = arr[arr.length]; // This will also throw ArrayIndexOutOfBoundsException
```

```java
for (int i = 0; i <= arr.length; i++) // Out-of-bounds error
for (int i = 0; i < arr.length; i++)  // Correct way
```

---

**Array Copying**

```java
int[] original = {1, 2, 3};
int[] copy = Arrays.copyOf(original, original.length);
```

---

**Comparing Arrays** - do not use `==` operator

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};
boolean areEqual = Arrays.equals(arr1, arr2); // true
```
