## Intro
Object-oriented programming (OOP) is a programming paradigm that organizes code into objects, which are instances of classes.
## Classes & Objects
- **Object** is an instance of a class
- **Class** is a type of object and serves as the blueprint – defining the data which the object stores and the methods for accessing and manipulating the data 

Class has:
- Fields (variables) - represent the data associated with an object of a class
- Methods (instructions) – called to perform actions and can take in arguments(defined) or parameters(undefined)

**Modifiers**
- Static modifier – its variable is associated with the class as a whole rather than an individual instance of that class e.g. an object

- Access control modifiers 
  - public( accessible to all classes)
  - private(accessible within the class only)

- Abstract modifier – Java will not allow an instance of an abstract class to be constructed without the abstract method

- Final modifier – a variable that when declared final cannot be assigned a new value

**Constructor** – a method used to initialise a newly created instance of a class. Each instance variable of the object is initialised. Cannot be static, abstract or final so only modifier applicable are those that affect visibility (public, private)

.this - to store the reference in a variable, to differentiate between the instance variable(outside method scope) and a local variable(within method scope) with the same name

#### POJO Plain Old Java Objects
To create a POJO a class must meet some requirements:
- private properties
- public getters and setters for every property
- An overloaded constructor with no parameters and an empty body
- No additional methods

#### DTO Data Transfer Objects
POJOs that are used to facilitate communication between different parts of our application

## Interfaces
Blueprint/Contract for a class. Collection of method declarations with no data and body - simply put it specifies what methods a class should have but no how they work.  

No constructor and cannot be directly instantiated. When a class implements an interface it must implement all the methods declared in the interface.  

* Use when you want to define a contract or a set of behaviours that a class must implement
* Promotes loose coupling and testable systems
* Achieves abstraction by defining behaviours without actually implementing them
* Supports multiple inheritance as a single class can implement multiple interfaces
```java
// Interface
public interface Shape {
    void draw(); // Abstract method with no body
    double area();
} 

// Concrete classes implementing the interface
public class Circle implements Shape {
    
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    @Override
    public double area() {
      return Math.PI * radius * radius;
    }

} 

public class Square implements Shape {

    private double side;
  
    public Square(double side) {
      this.side = side;
    }
  
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }

    @Override
    public double area() {
      return side * side;
    }
} 

// Class using the interface
public class Main {
    public static void main(String[] args) { 

        Shape shape1 = new Circle();
        shape1.draw(); // Output: Drawing a circle 
        System.out.println("Circle Area: " + shape1.area());


        Shape shape2 = new Square();
        shape2.draw(); // Output: Drawing a square
        System.out.println("Square Area: " + shape2.area());
    }
} 
```
## Abstract
Class that cannot be instantiated and serves as blueprints for its subclasses. May define methods without providing a body of implementation known as abstract methods like an interface class but unlike an interface may define fields and methods and how they work.  

Classes that inherit from an abstract class can use these implemented methods directly or override them.

Use when there's a common base implementation and share state for subclasses. Abstract classes can have both abstract and non-abstract methods, allowing you to define common functionality that can be inherited by subclasses

* Promotes code reusability and maintainability
* Provides a controlled way of enforcing behavior in subclasses
* Supports partial implementation with default behaviors

```java
// Example of an abstract class
abstract class Shape { 

    protected String color; 
    
    public Shape(String color) {
        this.color = color;
    } 
    
    public abstract double calculateArea(); // Abstract method, no body
    
    public void displayColor() { // Concrete method, has body
        System.out.println("Color: " + color);
    }
} 

// Concrete subclass extending the abstract class
class Rectangle extends Shape { 

    private double width;
    private double height; 
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    } 
    
    @Override
    public double calculateArea() {
        return width * height;
    }
} 

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("Red", 5, 10);
        rectangle.displayColor();                  // Output: Color: Red
        System.out.println(rectangle.calculateArea());  // Output: 50.0
    }
} 
```
## Principles Of OOP
![OOP-Principles](https://github.com/user-attachments/assets/667948b8-d48c-4888-8d61-e7bf8658c31f)

### Abstraction
process of simplifying complex systems by breaking them down into smaller, more manageable parts. Exposing only the essential features without needing to understand the underlying logic.  
For example, when using car you're only exposed to wheel, pedals and buttons (the interface) without needing to understand how things work under the hood.  
Can achieve abstraction through abstract classes and interfaces
```java
abstract class Vehicle {
    abstract void start(); // Abstract method

    void stop() { // Concrete method
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car started");
    }
}

class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike started");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        car.start();  // Output: Car started
        bike.start(); // Output: Bike started
        car.stop();   // Output: Vehicle stopped
    }
}
```
### Polymorphism 
allows objects to be treated as instances of their parent class. It enables one action to behave differently depending on the object that is performing it. This enables code to be written in a generic way that can handle different types of objects without the need for explicit type-checking.  

Polymorphism can be achieved through method overriding /runtime polymorphism (subclasses providing their own implementation of a method) and method overloading /compile-time polymorphism (multiple methods with the same name but different parameters)

* Improves code flexibility by allowing different implementations of the same method
* Reduces code duplication by allowing same method to handle different scenarios

```java
class Animal {
    // method overriding
    void sound() {
        System.out.println("Animal makes a sound");
    }
    
    // method overloading
    void hello(String name) {
        System.out.println("Hi my name is " + name);
    }

    void hello(String name,int age) {
      System.out.println("Hi my name is " + name + " and I'm " + age);
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.sound(); // Output: Dog barks
        myCat.sound(); // Output: Cat meows
    }
}
```

### Inheritance
allows a class to inherit/extend properties and methods from another class, promoting code reuse as common attributes and methods can be defined in a superclass and shared by multiple subclasses. In Java, inheritance is achieved using the extends keyword.

* Avoid redundant code by reusing common fields and methods
* Establish hierarchical relationship between classes for better organisation

```java
class Person {
    String name;

    void speak() {
        System.out.println("Person is speaking");
    }
}

class Employee extends Person {
    double salary;

    void work() {
        System.out.println(name + " is working with a salary of " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.name = "Alice";
        emp.salary = 50000;

        emp.speak(); // Output: Person is speaking
        emp.work();  // Output: Alice is working with a salary of 50000
    }
}

```

### Encapsulation
is the concept of wrapping data (variables) and code (methods) together into a single unit, typically through classes. It restricts direct access to an object’s data by using private fields and provides public getter and setter methods to access and modify the data safely.
```java
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() { // Getter method
        return balance;
    }

    public void deposit(double amount) { // Public method to modify balance
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Cannot deposit a negative amount");
        }
    }

    public void withdraw(double amount) { // Public method to modify balance
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        account.deposit(500);
        System.out.println("Balance: " + account.getBalance()); // Output: Balance: 1500.0

        account.withdraw(200);
        System.out.println("Balance: " + account.getBalance()); // Output: Balance: 1300.0

        // account.balance = 0;  // Not allowed, balance is private
    }
}

```

### Summary
| Principle      | Description                                                                                          | Code Example                             |
|----------------|------------------------------------------------------------------------------------------------------|------------------------------------------|
| **Abstraction**   | Hiding complex details and showing only essential features.                                         | `Vehicle` class and `start()` method     |
| **Polymorphism**  | Allowing actions to behave differently based on the object performing them (method overriding).     | `Animal` and `sound()` in `Dog` and `Cat` |
| **Inheritance**   | Enabling classes to inherit properties and methods from other classes, promoting code reuse.        | `Person` and `Employee` relationship     |
| **Encapsulation** | Restricting access to object data and methods, typically using private fields and public methods. | `BankAccount` with private `balance`     |
