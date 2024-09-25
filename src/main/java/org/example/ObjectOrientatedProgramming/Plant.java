package org.example.ObjectOrientatedProgramming;

public class Plant implements Organism{

    // Encapsulation: Fields are private and accessed through getter and setter methods
    private String species;
    private boolean isFlowering;

    // Constructor for Plant class
    public Plant(String species, boolean isFlowering){
        this.species = species;
        this.isFlowering = isFlowering;
    }

    // Polymorphism: Method overriding
    //Implementation of respire() from Organism interface
    @Override //Overrides method from a superclass or interface
    public void respire() {
        System.out.println(species + " is respiring through photosynthesis."); // Polymorphism
    }

    // Method specific to plants
    public void grow() {
        System.out.println(species + " is growing."); // Encapsulation
    }

    @Override
    public boolean isAlive() {
        return isFlowering;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public void setSpecies(String species) {

    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public void setAge(int age) {
        // Plants do not have age, so this method does nothing
    }
}
