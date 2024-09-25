package org.example.ObjectOrientatedProgramming;

// Inheritance: Canidae is a subclass of Animal
public class Canidae extends Animal{

    // Constructor for Canidae class
    public Canidae(String species, int age) {
        super(species, age); // Call to superclass constructor

        // super()
        // Allows the Animal class to initialize its fields
        // Perform any necessary setup before the Canidae class constructor continues its execution
    }

    // Implementation of respire method for Canidae from Animal parent class from Organism interface
    // Polymorphism: Method overriding
    @Override
    public void respire() {
        System.out.println("Canidae is panting."); // Additional behavior specific to Canidae
    }

    // Polymorphism: Method overriding
    // makeSound() is an abstract method and has to be implemented but not move()
    @Override
    public void move(){
        System.out.println("Canidae is moving.");
    }

}
