The Collections framework provides a set of interfaces, implementations and utilities in `java.util` 
for storing, retrieving and manipulating groups of objects through standard data structures (list, sets, maps, queues), 
algorithms (sort, shuffle) and interoperability (iterators, streams)

![CollectionsHierarchy.png](../../../../resources/CollectionsHierarchy.png)

# `Iterable<T>`
The root interface for anything that can be iterated (looped over).
`Iterator<T> iterator();` - provides an `Iterator` to traverse elements.

(Java 8+) `forEach(Consumer<? super T> action);` - perform action on each element.

(Java 8+) `Spliterator<T> spliterator();` - used in streams & parallel iteration.

Any class that implements `Iterable` can be used in a for-each loop. Only promises that you can loop through elements
but does not say how elements are stored, added, removed etc. 

`Iterable` is general purpose (can iterate over a sequence of any type) so uses the generic type `T` (Type).
`Iterable<String>` then `T` = `String`. 

# `Collection<E>`
The root interface of the Collections Framework and extends `Iterable<E>`.  
Defines the basic operations for a group of Objects(elements):
* `boolean add(E e)`
* `boolean remove(Object o)`
* `boolean contains(Object o)`
* `int size()`
* `boolean isEmpty()`
* `void clear()`
* `Object[] toArray()`
* `containsAll(Collection<?> c)`
* `boolean addAll(Collection<? extends E> c)`
* `boolean removeAll(Collection<?> c)`
* `void clear()`

All list, sets and queues implement `Collection`.  

`Collection` represents a group of elements therefore `Collection<E>` stores elements of type `E`.  
`Collection<Integer>` then `E` = `Integer` meaning collection stores elements of type `Integer`. 

## `List<E>`
An ordered collection (sequence) of elements

* Maintains insertion order 
* Allows duplicate elements 
* Supports positional access via index 
* Important methods:
  * `get(int index)`
  * `set(int index, E element)`
  * `indexOf(Object o)`
  * `lastIndexOf(Object o)`
  * `subList(int from, int to)`

### `ArrayList<E>`
A resizable-array implementation of `List`, used best for random access operations such as fast lookups 
and fewer inserts/deletes in the middle. Elements are stored contiguously (connected without a break) in memory. 

* `get(int index)` → `O(1)`
* `set(int index, E e)` → `O(1)`
* `add(E e)` → Amortized `O(1)`
* `remove(int index)` → `O(n)` 
  * Best Case: remove last element = no shift needed = `O(1)`
  * Worst Case: remove first element = shift all `n-1` elements to left = `O(n)`
  * Average: `n/2` shifts -> `O(n)` (drop constants to simplify in Big - O)

### `LinkedList<E>`
A doubly-linked list implementation of `List` (also `Deque`) used best for frequent insertions and deletions.  
Each node has reference to its previous and next node. Elements are not stored contiguously making it great for inserts / deletions 
but not for random access. 

* `get(int index)` → `O(n)` - to access element at index `i`, must traverse node by node till index `i` is reached then need to update pointers (prev/next)
* `add/remove at ends` → `O(1)` - directly access head (first) or tail (last) node reference with no bulk shifting like `ArrayList`
* `add/remove in middle` → `O(n/2)` → `O(n)`

![LinkedList.png](../../../../resources/LinkedList.png)
where tail pointer references last node

### `ArrayList<E>` vs `LinkedList<E>`
| Operation              | `ArrayList`        | `LinkedList`                           |
| ---------------------- | ------------------ | -------------------------------------- |
| `get(int index)`       | **`O(1)`**           | **`O(n)`**                               |
| `add/remove at end`    | Amortized **`O(1)`** | **`O(1)`**                               |
| `add/remove in middle` | **`O(n)`**           | **`O(n)`**                               |
| Memory overhead        | Low (array)        | Higher (extra node objects + pointers) |

* Use `ArrayList` when you need fast random access and fewer insertions / deletions
* Use `LinkedList` when you need lots of insertions / deletions at ends

### `HashMap`
A `HashMap` in Java is a data structure that implements the `Map` interface, providing a way to store key-value pairs. 
It uses a hash table to store the map's entries, allowing for fast retrieval, insertion, and deletion operations.

In a `HashMap`, the `hashCode()` method generates an integer hash code for each key, which is used to determine the bucket (a slot in the hash table) where the key-value pair is stored, allowing for efficient retrieval, insertion, and deletion operations.

Use `.get()` then perform a null check rather than `containsKey` then `get`.
`Map` doesn't extend or implement the `Collection` interface.

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

### `HashSet`
A `HashSet` in Java is a data structure that implements the `Set` interface, providing a way to store unique elements. It uses a hash table to store the set's elements only once without duplication, allowing for fast insertion, deletion, and lookup operations.

```java
Set<Product> products = new HashSet<>();
```
