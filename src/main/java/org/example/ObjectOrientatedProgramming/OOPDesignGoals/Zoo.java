package org.example.ObjectOrientatedProgramming.OOPDesignGoals;

import java.util.ArrayList;

public class Zoo {
    private String name;
    private String address;
    private ArrayList exhibitions;

    public Zoo(String name,String address,ArrayList exhibitions){
        this.name = name;
        this.address = address;
        this.exhibitions = exhibitions;
    }

    Canidae canidae = new Canidae("General canidae",10);
    Dog dog = new Dog("Greyhound",4);

    public void makeNoise(){
        canidae.makeSound();
        dog.makeSound();
    }

    Plant plant = new Plant("Rose",true);

    public void respire(){
        plant.respire();
    }
}
