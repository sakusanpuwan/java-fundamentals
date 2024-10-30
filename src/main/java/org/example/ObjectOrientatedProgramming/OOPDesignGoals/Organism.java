package org.example.ObjectOrientatedProgramming.OOPDesignGoals;

// Blueprint for classes
// Collection of method declarations with no data and method body
// Tells us what each should do but not how
// Implemented class must implement all methods

// Interface representing organisms
public interface Organism {

    // Abstract method (no implementation)
    void respire();

    // Default method with implementation
    default boolean isAlive(){
        return true;
    }

    String getSpecies();

    void setSpecies(String species);

    int getAge();

    void setAge(int age);
}
