# Algorithms_java
Java Exercises
  
**What are the differences between static and non-static nested classes?** 

Following are major differences between static nested class and non-static nested class. Non-static nested class is also called Inner Class.

1) Nested static class doesn’t need reference of Outer class, but Non-static nested class or Inner class requires Outer class reference.

2) Inner class(or non-static nested class) can access both static and non-static members of Outer class. A static class cannot access non-static members of the Outer class. It can access only static members of Outer class.

3) An instance of Inner class cannot be created without an instance of outer class and an Inner class can reference data and methods defined in Outer class in which it nests, so we don’t need to pass reference of an object to the constructor of the Inner class. For this reason Inner classes can make program simple and concise.
 
**Priority Queue** default as minHeap

Parameters:

o1 - the first object to be compared.

o2 - the second object to be compared.

Returns:

a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

**Arrays.sort** 

1. primitive type array

Quicksort: time complexity O(nlogn) (worse O(n^2))

		   space comlexity: O(1)

2. Object

Mergesort: time complexity O(nlogn) **stable**

		   space comlexity: O(n)
