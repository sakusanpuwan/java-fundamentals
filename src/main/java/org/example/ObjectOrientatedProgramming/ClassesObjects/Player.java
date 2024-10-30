package org.example.ObjectOrientatedProgramming.ClassesObjects;

public class Player {

    // private String instance variable
    private String name;

    private int goals;

    private int salary;

    public Player() {};

    public Player(String name) {
        //   inst   local
        this.name = name;
        this.goals = 0;
        this.salary = 100;
    }

    public static void shout(String name){
        System.out.println("I'm " + name);
    }

    // Public access control modifier
    public void publicScoreGoalMethod() {
        goals++;
    }

    // Private access control modifier
    private int getSalary() {
        return salary;
    }

    // Public accessor method
    public String getName() {
        return this.name;
    }

    // Public update method
    public int getGoals() {
        return this.goals;
    }
}
