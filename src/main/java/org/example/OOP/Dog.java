package org.example.OOP;

public class Dog extends Canidae{


    public Dog(String species,int age) {
        super(species, age);
    }

    @Override
    public void respire(){
        System.out.println("Dog is panting.");
    }
}
