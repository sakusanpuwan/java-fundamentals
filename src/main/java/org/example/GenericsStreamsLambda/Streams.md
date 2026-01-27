### Streams

Streams are a new abstraction introduced in Java 8 that lets you process collections of objects in a functional way.

Streams allow you to perform operations like filtering, mapping, and reducing on collections in a declarative way, without the need for explicit loops.

A Stream represents a sequence of elements and supports various operations that can be chained together to form a pipeline. Streams can be created from collections, arrays, or I/O channels. They do not store data themselves but operate on the source data.

- Concise and readable code using functional programming concepts
- Lazy evaluation for improved performance as operations are only executed when needed
- Can be parallelized easily for multi-core processors
- Reusable operations that can be combined in different ways like `map`, `filter`, `reduce`, etc.
- Does not store data, but operate on data from a source

General pattern of Stream operations:
```
source.stream()
      .intermediate operations...
      .terminal operation...
```

**Creation of Streams**

- From Collection (`List`, `Set`, etc.) using `.stream()` or `.parallelStream()`

  ```java
  List<String> list = Arrays.asList("A", "B", "C");
  Stream<String> stream = list.stream();
  ```

- From Array using `Arrays.stream(array)`

  ```java
  String[] array = {"A", "B", "C"};
  Stream<String> stream = Arrays.stream(array);
  ```

- From Values using `Stream.of()`

  ```java
  Stream<String> stream = Stream.of("A", "B", "C");
  ```

- From a Map
  ```java 
  map.keySet().stream()
  map.values().stream()
  map.entrySet().stream()
   ```
**Common Stream Data Structure Conversions**
* `.toArray()` - convert Stream to array

  ```java
  Object[] array = stream.toArray();
  ```
* `.collect()` - convert Stream to Collection (List, Set, etc.)

  ```java
  List<String> list = stream.collect(Collectors.toList());
  Set<String> set = stream.collect(Collectors.toSet());
  ```
* Array to List 
  ```java
  List<String> list = Arrays.stream(array).collect(Collectors.toList());
  ```
* List to Array
  ```java
  String[] array = list.stream().toArray(String[]::new);
  ```
* Map to List of Keys or Values
  ```java
  List<KeyType> keys = map.keySet().stream().collect(Collectors.toList());
  List<ValueType> values = map.values().stream().collect(Collectors.toList());
  List<Map.Entry<KeyType, ValueType>> entries = map.entrySet().stream().collect(Collectors.toList());
  ```

**Common Stream Operations**

* `.filter()` - remove elements from the Stream that don't match a predicate, returns a new Stream
* `.map()` - transform elements in the Stream to another value, returns a new Stream
* `.sorted()` - sort the elements in the Stream, returns a new Stream
* `.distinct()` - remove duplicate elements from the Stream, returns a new Stream
* `.limit()` - limit the number of elements in the Stream, returns a new Stream
* `.skip()` - skip a number of elements in the Stream, returns a new Stream
* `.flatMap()` - transform each element in the Stream to a Stream of elements, then flatten the Streams into a single Stream
* `.forEach()` - perform an action on each element in the Stream, returns void
* `.reduce()` - reduce the elements in the Stream to a single value, returns an Optional
* `.anyMatch()` - check if any elements in the Stream match a predicate, returns a boolean
* `.allMatch()` - check if all elements in the Stream match a predicate, returns a boolean
* `.noneMatch()` - check if no elements in the Stream match a predicate, returns a boolean
* `.findFirst()` - find the first element in the Stream, returns an Optional
* `.findAny()` - find any element in the Stream, returns an Optional
* `.count()` - count the number of elements in the Stream, returns a long
* `.min()` - find the minimum element in the Stream, returns an Optional
* `.max()` - find the maximum element in the Stream, returns an Optional
* `.collect()` - collect the elements in the Stream into a collection, returns a Collector
* `.groupingBy()` - group elements in the Stream by a classifier function, returns a Map

  ```java
  List<Country> countries = new ArrayList<>();
  countries.add(new Country("USA", "New York"));
  countries.add(new Country("USA", "Los Angeles"));
  countries.add(new Country("UK", "London"));
  countries.add(new Country("UK", "Manchester"));

  countries.stream()
  .collect(Collectors.groupingBy(Country::cities));
  // Map<String, List<String>>
  // output: {USA=[New York, Los Angeles], UK=[London, Manchester]}
  ```

* `.toList()` - collect the elements in the Stream into a List

  ```java
  .collect(Collectors.toList());
  ```

* `.toSet()` - collect the elements in the Stream into a Set

  ```java
    .collect(Collectors.toSet());
  ```

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

List<Product> products = new ArrayList<>();

// Stream operations on the products list
List<String> productNames = products.stream()
        .filter(product -> product.getWeight() > 10) // Filter products with weight greater than 10
        .map(Product::getName) // Map each product to its name
        .sorted(Comparator.comparing(String::toString)) // Sort product names
        .distinct() // Remove duplicate names
        .limit(5) // Limit the stream to 5 elements
        .skip(2) // Skip the first 2 elements
        .flatMap(product -> product.getCategories().stream()) // Flatten the categories of each product into a single stream
        .collect(Collectors.toList()); // Collect the results into a list

// Group products by category
Map<String, List<Product>> productsByCategory = products.stream()
        .collect(Collectors.groupingBy(Product::getCategory));

// Count products by name
Map<String, Long> productCountByName = products.stream()
        .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));

// Joins elements into String
String productNames = products.stream()
        .map(Product::getName)
        .collect(Collectors.joining(", "));

// Reduce to sum of weights
int totalWeight = products.stream()
        .map(Product::getWeight)
        .reduce(0, Integer::sum);

// Check if any product has weight greater than 10
boolean anyProductOver10 = products.stream()
        .anyMatch(product -> product.getWeight() > 10);

// Check if all products have weight greater than 10
boolean allProductsOver10 = products.stream()
        .allMatch(product -> product.getWeight() > 10);

// Check if no product has weight greater than 10
boolean noProductOver10 = products.stream()
        .noneMatch(product -> product.getWeight() > 10);

// Find the first product with name containing "Chair"
Optional<Product> firstChair = products.stream()
        .filter(product -> product.getName().contains("Chair"))
        .findFirst();

// Count products with name containing "Chair"
long chairCount = products.stream()
        .filter(product -> product.getName().contains("Chair"))
        .count();

// Find any product
Optional<Product> anyProduct = products.stream()
        .findAny();

// Count total number of products
long totalProducts = products.stream()
        .count();

// Find the product with minimum weight
Optional<Product> minWeightProduct = products.stream()
        .min(Comparator.comparing(Product::getWeight));

// Find the product with maximum weight
Optional<Product> maxWeightProduct = products.stream()
        .max(Comparator.comparing(Product::getWeight));

// Streaming a map
Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);
// Using entrySet() to iterate through the map
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
        System.out.println("Name: " + entry.getKey() + ", Age: " + entry.getValue());
        }
        // Using entrySet() and streams
        ages.entrySet().stream()
            .filter(entry -> entry.getValue() > 30)
        .forEach(entry -> System.out.println("Name: " + entry.getKey()));
        }


// Flat mapping
List<List<String>> listOfLists = Arrays.asList(
        Arrays.asList("a", "b"),
        Arrays.asList("c", "d", "e"),
        Arrays.asList("f")
);

List<String> flatList = listOfLists.stream()
        .flatMap(List::stream) // Each inner list becomes a stream
        .collect(Collectors.toList());

        System.out.println(flatList); // Output: [a, b, c, d, e, f]
```

**Parallel Streams**
Parallel streams allow you to process data in parallel, leveraging multiple CPU cores for improved performance on large datasets. You can create a parallel stream by calling `.parallelStream()` on a collection or by converting an existing stream to a parallel stream using `.parallel()`.

```java
List<String> list = Arrays.asList("A", "B", "C");
Stream<String> parallelStream = list.parallelStream();
// or
Stream<String> parallelStream2 = list.stream().parallel();
```

When using parallel streams, the stream operations are divided into multiple sub-tasks that can be executed concurrently. The results are then combined to produce the final output. However, be cautious when using parallel streams, as they may introduce overhead and complexity, especially when dealing with shared mutable state or non-thread-safe operations.

**Sorting with Streams**
- Natural ordering

  ```java
  List<String> sortedList = list.stream()
          .sorted()
          .collect(Collectors.toList());
  ```
- Reverse order

  ```java
  List<String> reverseSortedList = list.stream()
          .sorted(Comparator.reverseOrder())
          .collect(Collectors.toList());
  ```
- Custom comparator

  ```java
  List<String> customSortedList = list.stream()
          .sorted(Comparator.comparing(String::length))
          .collect(Collectors.toList());
  ```

  ```java
  .sorted(Comparator.comparing(Person::getAge).reversed())
  ```
- Sort Map by Keys

  ```java
  Map.Entry.<String, Integer> sortedByKey = map.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByKey())
  ```

  ```java
  Map.Entry.<String, Integer> sortedByKeyDesc = map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
  ```
- Multi-level sorting

  ```java
  List<Person> sortedPeople = people.stream()
          .sorted(Comparator.comparing(Person::getAge)
          .thenComparing(Person::getName))
          .collect(Collectors.toList());
  ```