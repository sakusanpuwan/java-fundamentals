# `Map`
Maps keys to values similar to a dictionary. Each key is unique maps to one value. It is not a subtype of `Collection`.

It allows null keys and values (except in `HashTable` and `TreeMap`). Provides key based access than index based.

---
## `HashMap`
A `HashMap` in Java is a data structure that implements the `Map` interface, providing a way to store key-value pairs.

In a `HashMap`, the `hashCode()` method generates an integer hash code for each key, which is used to determine
the bucket (a slot in the hash table) where the key-value pair is stored, allowing for efficient retrieval, insertion, and deletion operations.

```sql
Hash Table (array)
+---------------------------------------+
| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
+---------------------------------------+
         |           |        |
         ↓           ↓        ↓
      Bucket 1    Bucket 3  Bucket 7
       ("Bob")   ("Alice") ("Charlie")

```

If keys are complex in a `HashMap` (e.g. Person with name, age, address is key)
* Override `hashCode()` to generate a consistent hash code based on significant fields such as name
* Override `equals()` to compare the significant field and ensure two Person objects are equal only if they have same
  name, age and address.

Using mutable objects as keys in a HashMap can lead to unexpected behaviour because the hash code may change after
the object is inserted, leading to incorrect bucket assignments.

Overriding only the `equals()` and not the `hashCode()` can lead to inconsistent behaviour. Two keys that are considered
equal by `equals()` might not have the same `hashCode()` causing them to be placed in different buckets.


* Allows one null key and multiple null values
* Not synchronised (not thread-safe)
* Order is not guaranteed
* Use `.get()` then perform a null check rather than `containsKey` then `get`.
* Bucket index = `hash % table.length`


* `put()` - direct hash inert if the bucket is empty, if collision needs to traverse list/tree
    * Average - `O(1)`
    * Worst - `O(n)` - when many keys hash to the same bucket index (collide)
* `get()` - direct hash lookup, if collision needs to traverse list/tree
    * Average - `O(1)`
    * Worst - `O(n)`
* `remove()` - needs to traverse to find element in bucket
    * Average - `O(1)`
    * Worst - `O(n)`
* `containsKey()` - Same as get
* `iteration` - Must scan all entries
    * Average - `O(n)`
    * Worst - `O(n)`

Uniform Hash Distribution - the keys are spread evenly across buckets. If the `hashCode()` function is good and the table
has enough capacity then each bucket contains very few entries (<= 1) so functions `get()`,`put()`,`remove()`.

Since Java 8 : If a bucket’s linked list exceeds 8 elements, it converts to a Red-Black Tree,
improving lookup and insertion from O(n) → O(log n) in those rare cases.

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

`map.put()` // puts a key-value pair in the map, returns the old value or null if the key was not present

`map.replace()` // replaces the value of a key if the key is present, returns the old value or null if the key was not present

`map.replaceAll((id,product) -> new Product(id,product.getName(),product.getWeight() + 10))` // replaces all values in the map, returns void

`map.remove()` // removes a key if it is present, returns the value associated with the key or null if the key was not present

`map.getOrDefault()` // returns a default value if the key is not found, otherwise returns the value associated with the key

`map.computeIfAbsent(key, id -> new Product(id,"Name",5))` // computes and returns a value if the key is not found, otherwise returns the existing value

`map.putIfAbsent()` // puts a value if the key is not found, returns the existing value or null if the key was not present

`map.compute()` // computes and returns a value if the key is found, otherwise returns null

`map.merge()` // merges the value with the existing value if the key is found, returns the new value associated with the key

`map.forEach((id,product)) -> { System.out.println(id + " : " + product.getName()); }`// performs an action on each entry, returns void
```

```java
Map<String, Integer> map = new HashMap<>();

for( Map.Entry<String, Integer> entry :map.entrySet()){
  String key = entry.getKey();
  Integer value = entry.getValue();
}

```
`Map.Entry` is a static nested interface within the `Map` interface. Represents a key - value pair or an entry.

---

## `LinkedHashMap`
Extends `HashMap` but preserves insertion order by using a doubly - linked list along with hash table.

```java
LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
```

[//]: # (TODO: Add further notes on TreeMap, HashTable, ConcurrentHashMap)