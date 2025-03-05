### Streams
Streams are a new abstraction introduced in Java 8 that lets you process collections of objects in a functional way.  
Streams allow you to perform operations like filtering, mapping, and reducing on collections in a declarative way, without the need for explicit loops.

- `.filter()` - remove elements from the Stream that don't match a predicate, returns a new Stream

- `.map()` - transform elements in the Stream to another value, returns a new Stream

- `.sorted()` - sort the elements in the Stream, returns a new Stream

- `.distinct()` - remove duplicate elements from the Stream, returns a new Stream

- `.limit()` - limit the number of elements in the Stream, returns a new Stream

- `.skip()` - skip a number of elements in the Stream, returns a new Stream

- `.flatMap()` - transform each element in the Stream to a Stream of elements, then flatten the Streams into a single Stream

- `.forEach()` - perform an action on each element in the Stream, returns void

- `.reduce()` - reduce the elements in the Stream to a single value, returns an Optional

- `.anyMatch()` - check if any elements in the Stream match a predicate, returns a boolean

- `.allMatch()` - check if all elements in the Stream match a predicate, returns a boolean

- `.noneMatch()` - check if no elements in the Stream match a predicate, returns a boolean

- `.findFirst()` - find the first element in the Stream, returns an Optional

- `.findAny()` - find any element in the Stream, returns an Optional

- `.count()` - count the number of elements in the Stream, returns a long

- `.min()` - find the minimum element in the Stream, returns an Optional

- `.max()` - find the maximum element in the Stream, returns an Optional

- `.collect()` - collect the elements in the Stream into a collection, returns a Collector  

- `.groupingBy()` - group elements in the Stream by a classifier function, returns a Map
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
- `.toList()` - collect the elements in the Stream into a List
  ```java
  .collect(Collectors.toList());
  ```
- `.toSet()` - collect the elements in the Stream into a Set
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
```
