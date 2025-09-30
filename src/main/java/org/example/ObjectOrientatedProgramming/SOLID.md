SOLID principles are essential guidelines that enhance software design by making code more maintainable and scalable. 

## Single Responsibility Principle (SRP)
A class should have one, and only one, reason to change.

Every class should have a single responsibility, job or purpose. 

```java
// Class for baking bread
class BreadBaker {
    public void bakeBread() {
        System.out.println("Baking high-quality bread...");
    }
}

// Class for managing inventory
class InventoryManager {
    public void manageInventory() {
        System.out.println("Managing inventory...");
    }
}

// Class for ordering supplies
class SupplyOrder {
    public void orderSupplies() {
        System.out.println("Ordering supplies...");
    }
}

// Class for serving customers
class CustomerService {
    public void serveCustomer() {
        System.out.println("Serving customers...");
    }
}

// Class for cleaning the bakery
class BakeryCleaner {
    public void cleanBakery() {
        System.out.println("Cleaning the bakery...");
    }
}

public class BakeryOperations {
    public static void main(String[] args) {
        BreadBaker baker = new BreadBaker();
        InventoryManager inventoryManager = new InventoryManager();
        SupplyOrder supplyOrder = new SupplyOrder();
        CustomerService customerService = new CustomerService();
        BakeryCleaner cleaner = new BakeryCleaner();

        // Each class focuses on its specific responsibility
        baker.bakeBread();
        inventoryManager.manageInventory();
        supplyOrder.orderSupplies();
        customerService.serveCustomer();
        cleaner.cleanBakery();
    }
}

```

## Open-Closed Principle (OCP)
Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

For a PaymentProcessor class that currently supports credit card payment, it should be extended to support PayPal functionality instead of modified.  
The abstract class is needed to define a common abstract so that the client code can depend on abstraction and not the concrete class, enabling polymorphism. 

Without the abstract class you have two completely separate classes
```java
class CreditCardPaymentProcessor {
    public void processPayment(double amount) { ... }
}

class PayPalPaymentProcessor {
    public void processPayment(double amount) { ... }
}
```

```java
// Violates OCP: tightly coupled and not extensible
if (type.equals("creditcard")) {
    CreditCardPaymentProcessor c = new CreditCardPaymentProcessor();
    c.processPayment(amount);
} else if (type.equals("paypal")) {
    PayPalPaymentProcessor p = new PayPalPaymentProcessor();
    p.processPayment(amount);
}
```

With abstract class
```java
// Base class for payment processing
// Pure virtual function that acts as common interface for all payment processors
abstract class PaymentProcessor {
    public abstract void processPayment(double amount); // Abstract method
}

// Credit card payment processor
class CreditCardPaymentProcessor extends PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

// PayPal payment processor
class PayPalPaymentProcessor extends PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}
```

```java
// Create concrete instances of the processors
PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();
PaymentProcessor payPalProcessor = new PayPalPaymentProcessor();

// Call the method polymorphically
creditCardProcessor.processPayment(150.00);
payPalProcessor.processPayment(75.50);
```

## Liskov Substitution Principle (LSP)
Sub / Child classes must be substitutable for their base / parent classes in every context.

```java
// Base class for Rectangle
class Rectangle {
    protected double width;
    protected double height;

    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    public double area() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double w) {
        this.width = w;
    }

    public void setHeight(double h) {
        this.height = h;
    }
}

// Derived class for Square
class Square extends Rectangle {
    public Square(double size) {
        super(size, size);
    }

    @Override
    public void setWidth(double w) {
        this.width = w;
        this.height = w;
    }

    @Override
    public void setHeight(double h) {
        this.width = h;
        this.height = h;
    }
}

```

LSP violation example - if you sub a Square where a Rectangle is expected, changing the width / height would lead to incorrect results because it will change both dimensions

```java
Square s = new Square(5);
s.setWidth(7);    // sets both width and height to 7
s.setHeight(3);   // sets both width and height to 3

Rectangle r = new Square(5);  // Looks like a Rectangle, but acts differently
r.setWidth(5);
r.setHeight(10);
System.out.println(r.area()); // Output: 100 ❌ (Expected: 50)
```

If Square is a subclass of Rectangle then it should behave like a Rectangle.

## Interface Segregation Principle
Client should not be forced to implement an interface which is irrelevant to them. 

It is preferred to use many small client specific interface rather than one general interface, and each interface should have only one responsibility.

```java
import java.util.List;
import java.util.Arrays;

interface IVegetarianMenu {
    List<String> getVegetarianItems();
}

interface INonVegetarianMenu {
    List<String> getNonVegetarianItems();
}

interface IDrinkMenu {
    List<String> getDrinkItems();
}

class VegetarianMenu implements IVegetarianMenu {
    public List<String> getVegetarianItems() {
        return Arrays.asList("Vegetable Curry", "Paneer Tikka", "Salad");
    }
}

class NonVegetarianMenu implements INonVegetarianMenu {
    public List<String> getNonVegetarianItems() {
        return Arrays.asList("Chicken Curry", "Fish Fry", "Mutton Biryani");
    }
}

class DrinkMenu implements IDrinkMenu {
    public List<String> getDrinkItems() {
        return Arrays.asList("Water", "Soda", "Juice");
    }
}

public class MenuDemo {
    public static void displayVegetarianMenu(IVegetarianMenu menu) {
        System.out.println("Vegetarian Menu:");
        for (String item : menu.getVegetarianItems()) {
            System.out.println("- " + item);
        }
    }

    public static void displayNonVegetarianMenu(INonVegetarianMenu menu) {
        System.out.println("Non-Vegetarian Menu:");
        for (String item : menu.getNonVegetarianItems()) {
            System.out.println("- " + item);
        }
    }

    public static void main(String[] args) {
        VegetarianMenu vegMenu = new VegetarianMenu();
        NonVegetarianMenu nonVegMenu = new NonVegetarianMenu();

        displayVegetarianMenu(vegMenu);
        displayNonVegetarianMenu(nonVegMenu);
    }
}

```

Each interface represents a distinct responsibility. 

A vegetarian menu is not concerned with drinks or non - veg menu items. Avoiding bloated interfaces like
```java
// Bad design violating ISP
interface IMenu {
    List<String> getVegetarianItems();
    List<String> getNonVegetarianItems();
    List<String> getDrinkItems();
}

```

`Vegetarian Menu` would now have to implement methods which are not needed like `getDrinkItems()`.

## Dependency Inversion Principle (DIP)
High-level modules should not depend on low-level modules. Both should depend on abstractions.

Classes should rely on abstractions (interfaces, abstracts) than concrete implementations. Making code more flexible and decoupled. 

```java
// Interface for version control system
interface IVersionControl {
    void commit(String message);
    void push();
    void pull();
}

// Git version control implementation
class GitVersionControl implements IVersionControl {
    @Override
    public void commit(String message) {
        System.out.println("Committing changes to Git with message: " + message);
    }

    @Override
    public void push() {
        System.out.println("Pushing changes to remote Git repository.");
    }

    @Override
    public void pull() {
        System.out.println("Pulling changes from remote Git repository.");
    }
}

// Team class that relies on version control
class DevelopmentTeam {
    private IVersionControl versionControl;

    public DevelopmentTeam(IVersionControl versionControl) {
        this.versionControl = versionControl;
    }

    public void makeCommit(String message) {
        versionControl.commit(message);
    }

    public void performPush() {
        versionControl.push();
    }

    public void performPull() {
        versionControl.pull();
    }
}

// Main class to run the example
public class VersionControlDemo {
    public static void main(String[] args) {
        IVersionControl git = new GitVersionControl();
        DevelopmentTeam team = new DevelopmentTeam(git);

        team.makeCommit("Initial commit");
        team.performPush();
        team.performPull();
    }
}

```
`IVersionControl` interface defines the operations that any version control system should support. It serves as an abstraction that
decouples high - level code from low level implementations. 

`DevelopmentTeam` class depends on the version control interface, meaning it can work with any version control implementation that implements the interface. 
It does not need to depend on the low - level details of `GitVersionControl`. 