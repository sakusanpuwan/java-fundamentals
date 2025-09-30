## Collections
### HashMap
A HashMap in Java is a data structure that implements the Map interface, providing a way to store key-value pairs. It uses a hash table to store the map's entries, allowing for fast retrieval, insertion, and deletion operations.

In a HashMap, the hashCode() method generates an integer hash code for each key, which is used to determine the bucket (a slot in the hash table) where the key-value pair is stored, allowing for efficient retrieval, insertion, and deletion operations.

Use .get() then perform a null check rather than containsKey then get.
Map doesn't extend or implement the Collection interface.

```java
import java.util.HashMap;
import java.util.Set;

final Map<Integer, Product> idToProduct = new HashMap<>(); // Initialise & Declare
idToProduct.put(1, new Product(1, "Product 1"));
idToProduct.put(2, new Product(2, "Product 2"));

Set<Integer> ids = idToProduct.keySet();
```

```java
import java.util.Collection;

Collection<Product> products = idToProduct.values();
```

```java
Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet(); 
for(Map.Entry<Integer, Product> entry : entries){
    System.out.println(entry.getKey() + " : " + entry.getValue());
}
// Map.Entry is a nested interface of Map

// From Java 10
var entries = idToProduct.entrySet();
```

```java
// Initialise & Declare 

HashMap<KeyType, ValueType> map = new HashMap<>();

HashMap<String, Integer> map = new HashMap<>(); 


map.put(key1, value1); // Adding elements to the HashMap 

ValueType value = map.get(key); // Retrieving values based on keys 


// Checking if the HashMap contains a specific key or value 

boolean containsKey = map.containsKey(key);

boolean containsValue = map.containsValue(value);

ValueType removedValue = map.remove(key); // Removing an entry from the HashMap 

boolean isEmpty = map.isEmpty(); // Checking if the HashMap is empty 

int size = map.size(); // Getting the size of the HashMap 

map.clear(); // Clearing the HashMap (removing all entries) 

Set<KeyType> keySet = map.keySet(); // Getting a Set of keys in the HashMap  

Collection<ValueType> values = map.values(); // Getting a Collection of values in the HashMap


// Iterating over the entries in the HashMap using a for-each loop 

for (Map.Entry<KeyType, ValueType> entry : map.entrySet()) {
    KeyType key = entry.getKey(); 

    ValueType value = entry.getValue(); 

    // Perform operations on key-value pairs 

}

map.put() // puts a key-value pair in the map, returns the old value or null if the key was not present

map.replace() // replaces the value of a key if the key is present, returns the old value or null if the key was not present

map.replaceAll((id,product) -> 
        new Product(id,product.getName(),product.getWeight() + 10)) // replaces all values in the map, returns void

map.remove() // removes a key if it is present, returns the value associated with the key or null if the key was not present

map.getOrDefault() // returns a default value if the key is not found, otherwise returns the value associated with the key

map.computeIfAbsent(key, id -> new Product(id,"Name",5)) // computes and returns a value if the key is not found, otherwise returns the existing value

map.putIfAbsent() // puts a value if the key is not found, returns the existing value or null if the key was not present

map.compute() // computes and returns a value if the key is found, otherwise returns null

map.merge() // merges the value with the existing value if the key is found, returns the new value associated with the key

map.forEach((id,product)) ->
        {
            System.out.println(id + " : " + product.getName());
        }// performs an action on each entry, returns void
```

### Empty Collections
When you want to pass no values to a method that expects a collection.
```java
import java.util.Collections;
import java.util.Set;

List<String> list = Collections.emptyList();
Map<Integer, String> map = Collections.emptyMap();
Set<Integer> set = Collections.emptySet();
```
### Collection Factories

```java
import java.util.Map;

List<String> list = List.of("A", "B", "C");

Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);

Map<String, Integer> map = Map.ofEntries(
        Map.entry("A", 1),
        Map.entry("B", 2),
        Map.entry("C", 3)
);
```

### Collection Operations

```java
import java.util.Collection;
import java.util.Collections;

Product lightestProduct = Collection.min(products, Product.BY_WEIGHT);
Product heaviestProduct = Collection.max(products, Product.BY_WEIGHT);

Collections.shuffle(products);
```

### HashSet
A HashSet in Java is a data structure that implements the Set interface, providing a way to store unique elements. It uses a hash table to store the set's elements only once without duplication, allowing for fast insertion, deletion, and lookup operations.

```java
Set<Product> products = new HashSet<>();
```
