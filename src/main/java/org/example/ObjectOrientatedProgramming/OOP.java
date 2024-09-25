package org.example.ObjectOrientatedProgramming;

public class OOP {
    public static void intro(){
        Player.shout("Drogba"); // Static method

        Player newPlayer = new Player("Lampard"); // Constructor init new instance of Player class
        String name = newPlayer.getName();
        int goals = newPlayer.getGoals();
        newPlayer.publicScoreGoalMethod();
        int newGoals = newPlayer.getGoals();
//        int salary = newPlayer.getSalary    get salary is private method cannot access outside Player class
    }
}
