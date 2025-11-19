# Patterns

## Arrays

### Traversal

Traversal patterns mean visiting each node in a data structure at least once.

#### Left to Right - `O(n)`

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

- Counting, summing, or searching elements in an array.
- Finding the maximum or minimum value in an array.

#### Right to Left - `O(n)`

```java
for (int i = arr.length - 1; i >= 0; i--) {
    System.out.println(arr[i]);
}
```

- Suffix computations.
- Reversing an array.

### Prefix Sums

A prefix sum array is an auxiliary array that stores the cumulative sum of elements up to each index.

```java
int[] prefixSums(int[] arr) {
    int n = arr.length;
    int[] prefixSums = new int[n];
    prefixSums[0] = arr[0]; // First element is the same
    for (int i = 1; i < n; i++) {
        prefixSums[i] = prefixSums[i - 1] + arr[i]; // Previous sum + current element
    }
    return prefixSums;
}
```

### Suffix Sums

A suffix sum array is an auxiliary array that stores the cumulative sum of elements from each index to the end of the array.

```java
int[] suffixSums(int[] arr) {
    int n = arr.length;
    int[] suffixSums = new int[n];
    suffixSums[n - 1] = arr[n - 1]; // Last element is the same
    for (int i = n - 2; i >= 0; i--) {
        suffixSums[i] = suffixSums[i + 1] + arr[i]; // Next sum + current element
    }
    return suffixSums;
}
```

### Difference Arrays

A difference array is an auxiliary array that helps efficiently perform (`O(1)`) range update operations on an array. If you want to add a value to all elements in a range `[l, r]`, you can use a difference array (diff) to achieve this efficiently instead of updating each element in the range individually.

```java
void rangeUpdate(int[] arr, int l, int r, int val) {
    int n = arr.length;
    int[] diff = new int[n + 1]; // One extra space to avoid n+1 index out of bounds and make calculations easier
    diff[l] += val; // Start of the range increase by val
    if (r + 1 < n) { // End of the range reached
        diff[r + 1] -= val; // End of the range + 1
    }

    // Apply the difference array to get the updated array
    int current = 0;
    for (int i = 0; i < n; i++) {
        current += diff[i];
        arr[i] += current;
    }
}
```

`l` and `r` are the starting and ending indices of the range (inclusive), and `val` is the value to be added to each element in that range.

`int[] diff = new int[n + 1];` creates a difference array with one extra element to handle the end of the range update without going out of bounds.

`arr = [1,1,1,1,1]`  
`l = 1`  
`r = 3`  
`val = 2`

1. Allocate `diff` array

```scss
diff indices:  0  1  2  3  4  5
diff initial = [0, 0, 0, 0, 0, 0]
```

2. Apply `diff[l] += val` -> `diff[1] += 2`

```scss
diff after l = [0, 2, 0, 0, 0, 0]
```

3. Apply `diff[r + 1] -= val` -> `diff[4] -= 2`

```scss
diff after r+1 = [0, 2, 0, 0, -2, 0]
```

4. Construct the updated array by applying the difference array

| i   | diff[i] | current (after adding diff[i]) | arr before | arr after = arr before + current |
| --- | ------: | -----------------------------: | ---------: | -------------------------------: |
| 0   |       0 |                              0 |          1 |                    1 (no change) |
| 1   |       2 |                              2 |          1 |                        3 (1 + 2) |
| 2   |       0 |                              2 |          1 |                        3 (1 + 2) |
| 3   |       0 |                              2 |          1 |                        3 (1 + 2) |
| 4   |      -2 |                   0 (2 + (-2)) |          1 |             1 (back to original) |

Final updated `arr = [1, 3, 3, 3, 1]`

Difference arrays are particularly useful when you have multiple range update operations to perform on an array, as they allow you to apply all updates in `O(n + k)` time, where `k` is the number of updates, instead of `O(n * k)` if you were to update each element in the range individually for each operation.

### Subarray Patterns

### Range Sum / Prefix Applications

### Kadane’s Algorithm

## Sliding Window

### Fixed Window

### Variable Window

### Expand–Contract Windows

### Min/Max Window Problems

### Substring Window Problems

## Strings I

### Palindrome Patterns

### Frequency Array Patterns

### Basic String Traversal

### Two-Pointer String Problems

## Strings II

### Anagram Patterns

### Permutation & Substring Matching

### Frequency Match Windows

### Fixed Window String Problems

## HashMap / HashSet

### Frequency Counting

### Duplicate Detection

### O(1) Lookup Patterns

### Hash-Based Pair/Group Problems

## Two Pointers

### Opposite-End Two Pointers

### Slow/Fast Pointers

### Sorted Array Pair Logic

### Cycle Detection

## Linked Lists I

### Linked List Construction

### Traversal Patterns

### Dummy Node Technique

### Pointer Manipulation Basics

## Linked Lists II

### Palindrome Linked List Pattern

### Partitioning Lists

### Finding Middle Node

### Multi-Pass Traversal Patterns

### Reversal Variants

## Stacks + Monotonic Stack

### Valid Parentheses Patterns

### Monotonic Stack (Next Greater/Smaller)

### Stack-Based Linear Processing

### Nearest Element Problems

## Queues + Deque

### FIFO Patterns

### Circular Queue Logic

### Monotonic Deque

### Sliding Window Maximum

## Binary Search Basics

### Classic Binary Search

### Lower/Upper Bounds

### Search in Sorted Array

## Binary Search on Answer

### Monotonic Predicate Search

### Feasibility Checking

### Binary Search on Solution Space

## Sorting Patterns

### Sorting-Based Tricks

### Sweep Line Patterns

### Interval Sorting Problems

### Dutch National Flag (3-Way Partition)

## Prefix Sums II

### Range Query Optimization

### Prefix Hashing

### Subarray Sum Count (e.g., Sum = K)

## DP Basics

### Memoization

### Tabulation

### Min/Max / Count DP

### Recurrence-Based DP

## DP on Subsequences

### LIS / LCS Patterns

### Subsequence DP (Non-Contiguous)

### Prefix Comparison DP

## Knapsack DP

### 0/1 Knapsack

### Subset Sum Variants

### Take/Not-Take DP Pattern

## DP on Grids

### Path Counting DP

### Minimum Path Cost DP

### 2D DP with Grid Boundaries

## DP on Intervals

### Interval DP

### Partition-Based DP

### Palindromic Interval DP

## Trees Basics

### DFS Tree Traversal

### BFS Tree Traversal

### Tree Depth / Height Patterns

## BST (Binary Search Tree)

### Inorder Traversal

### Search/Insert/Delete Patterns

### BST Property Applications

## Trees Advanced

### Lowest Common Ancestor (LCA)

### Tree Diameter

### Depth Tracking DFS

## Graphs BFS/DFS

### Adjacency List Graph Representation

### Connected Component Search

### DFS/BFS Exploration

### Island/Region Problems

## Graph Topological Sort

### Kahn’s Algorithm

### DAG Ordering

### In-Degree Based Processing

## Shortest Path

### Dijkstra’s Algorithm

### BFS for Unweighted Paths

### Weighted Graph Traversal

## Heaps & Priority Queue

### Top-K Problems

### Heap-Based Partial Sorting

### Priority Queue Applications

## Tries

### Prefix Tree Structure

### Autocomplete Logic

### Prefix Matching Patterns

## Bit Manipulation

### XOR Tricks

### Bitmasking

### Odd/Even Occurrence Patterns

## Mixed Review

### Combined Patterns

### Hybrid Techniques

### Pattern Identification Practice
