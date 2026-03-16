# Design Patterns

## Creational Design Pattern
### Singleton Pattern
The Singleton Pattern is a design pattern that restricts the instantiation of a class to a single instance and provides a global point of access to that instance. This is useful when exactly one object is needed to coordinate actions across the system.

* Only one instance of the class can be created.
* Provides a global point of access to the instance.
* Guarantees that the instance is created only when it is needed (lazy initialization).
* Examples: Logger, Spring Beans, Configuration Manager, Database Connection Pool.


Design: 
* Class is responsible for lifecycle
* Static method to get the instance
* Threadsafe
* Private instance and constructor
* No parameters in constructor



```java
public class DbSingleton {
    
    private static DbSingleton instance = new DbSingleton();

    private DbSingleton() {
        // private constructor to prevent instantiation
    }

    public static DbSingleton getInstance() {
        return instance;
    }
}
```

```java
public class DbSingletonDemo {
    
    public static void main(String[] args) {
        DbSingleton instance1 = DbSingleton.getInstance();

        DbSingleton instance2 = new DbSingleton(); // This will cause a compilation error because the constructor is private

        DbSingleton instance3 = DbSingleton.getInstance();

        System.out.println(instance1);
        System.out.println(instance3); // instance1 and instance3 will be the same instance
    }
}
```

Lazy Initialization:

```java
public class DbSingleton {
    
    private static DbSingleton instance = null;

    private DbSingleton() {
        // private constructor to prevent instantiation
    }

    public static synchronized DbSingleton getInstance() {
        if (instance == null) {
            instance = new DbSingleton(); // instance is created only when it is needed
        }
        return instance;
    }
}
```

Threadsafe:

```java
public class DbSingleton {
    
    private static volatile DbSingleton instance = null; // Volatile keyword ensures changes made to instance are visible to all threads

    private DbSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        } // prevent reflection from creating another instance
    }

    public static DbSingleton getInstance() {
        if (instance == null) { // Avoid unnecessary synchronization overhead if the instance is already initialized
            synchronized (DbSingleton.class) { // synchronize on the class to ensure that only one thread can access this block at a time
                if (instance == null) { // Double-checked locking to ensure that only one instance is created even in a multithreaded environment
                    instance = new DbSingleton(); // instance is created only when it is needed
                }
            }
        }
        return instance;
    }
}
```

Disadvantages:
* Often overused
* Difficult to unit test
* If not careful, not thread-safe
* Can be easily confused with Factory

### Builder Pattern
The Builder Pattern is a design pattern that allows for the construction of complex objects step by step. It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

* Handles complex constructors
* Large number of parameters
* Immutability
* Examples: StringBuilder, Lombok @Builder, Apache Commons Lang's ToStringBuilder.

Design: 
* Flexibilty over telescoping constructor (multiple constructors with different parameters)
* Static inner class
* Calls appropriate constructor
* Negates the need for exposed setters

Bean Setters
```java
public class LunchOrderBean {
    
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrderBean() {

    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }
}
```

```java
LunchOrderBean lunchOrderBean = new LunchOrderBean();

lunchOrderBean.setBread("Wheat");
lunchOrderBean.setCondiments("Lettuce");
lunchOrderBean.setDressing("Mustard");
lunchOrderBean.setMeat("Ham");
```

Builder

```java
public static LunchOrder {

    public static class Builder {
        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        public Builder() {
        }

        public LunchOrder build() {
            return new LunchOrder(this);
        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }
    }

    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    private LunchOrder(Builder builder) {
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    public String getBread() {}
    public String getCondiments() {}
    public String getDressing() {}
    public String getMeat() {}
}
```

Disadvantages
* Immutable 
* Inner static class
* Designed first
* Complex

### Prototype Pattern
Prototype is a design pattern that allows for the creation of new objects by copying an existing object, known as the prototype rather than instantiating a new object. This is useful when the process of creating a new object is expensive or complex, and it can be more efficient to clone an existing object.

* Objects are cloned not created from scratch 
* Avoids keyword `new`
* Although a copy, each clone is a unique instance and can be modified independently

```java
public abstract class Item implements Cloneable {

    private String title;
    private double price;
    private String url;

    // Cloneable implementation 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Create a shallow copy
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }
}
```

```java
public class Book extends Item {
    private int numberOfPages;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
```

```java
public class PrototypeDemo {
    public static void main(String[] args) {
        try {
            Book originalBook = new Book();
            originalBook.setNumberOfPages(300);
            // Set other properties...

            Book clonedBook = (Book) originalBook.clone();
            clonedBook.setNumberOfPages(400); // Modify clone independently

            System.out.println(originalBook.getNumberOfPages()); // 300
            System.out.println(clonedBook.getNumberOfPages());   // 400
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
```

### Factory Pattern
The Factory Pattern is a creational design pattern that provides an interface for creating objects, allowing subclasses or implementations to decide which class to instantiate. This promotes loose coupling by eliminating the need to bind application-specific classes into your code.

* Encapsulates object creation logic
* Promotes loose coupling
* Allows for easy extension and maintenance

```java
public interface Notification {
    void notifyUser();
}
```

```java
public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email notification");
    }
}

public class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification");
    }
}

public class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push notification");
    }
}
```

```java
public enum NotificationType {
    EMAIL, SMS, PUSH;
}

```java
public class NotificationFactory {
    public Notification createNotification(NotificationType type) {
        if (type == null)
            return null;
        switch (type) {
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SMSNotification();
            case PUSH:
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type " + type);
        }
    }
}
```

```java
public class FactoryDemo {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification emailNotification = factory.createNotification("EMAIL");
        Notification smsNotification = factory.createNotification("SMS");
        Notification pushNotification = factory.createNotification("PUSH");

        emailNotification.notifyUser(); // Output: Sending an Email notification
        smsNotification.notifyUser();   // Output: Sending an SMS notification
        pushNotification.notifyUser();  // Output: Sending a Push notification
    }
}
```

### Abstract Factory Pattern
The Abstract Factory Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It allows you to create a suite of related products without being concerned about the specific classes that will be instantiated.

```java
public interface Button {
    void paint();
}

public interface Checkbox {
    void paint();
}
```

```java
// Light theme
public class LightButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering Light Button");
    }
}

public class LightCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering Light Checkbox");
    }
}

// Dark theme
public class DarkButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering Dark Button");
    }
}

public class DarkCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering Dark Checkbox");
    }
}

```

```java
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

```java
public class LightFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

public class DarkFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}
```

```java
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

```

```java
public class Main {
    public static void main(String[] args) {
        GUIFactory factory = new LightFactory(); // or new DarkFactory()
        Application app = new Application(factory);
        app.paint();
    }
}
```