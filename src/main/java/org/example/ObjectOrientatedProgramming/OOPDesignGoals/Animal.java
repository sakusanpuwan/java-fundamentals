package org.example.ObjectOrientatedProgramming.OOPDesignGoals;

// Abstraction: Animal is an abstract concept
public abstract class Animal implements Organism {

    // Encapsulation: Fields are private and accessed through getter and setter methods
    private String species;
    private int age;

    // Constructor to initialize the fields
    //           <-------Parameters------->
    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
    }

    // Polymorphism: Method overriding
    // Implementation of respire() from Organism interface
    @Override //Overrides method from a superclass or interface
    public void respire(){
        System.out.println(species + "is respiring");
    }

    // Specific to Animal
    public abstract void move();

    // Encapsulation: Getter and setter methods for accessing fields
    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }

    // Abstraction: Abstract method to be inherited by subclasses
    public void makeSound(){
        System.out.println(species + " is making a sound");
    };

    // Polymorphism: Method overriding
    @Override
    public String toString() {
        return "Species: " + species + ", Age: " + age;
    }
}
