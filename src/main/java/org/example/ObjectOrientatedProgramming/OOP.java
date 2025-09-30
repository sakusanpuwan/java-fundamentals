package org.example.ObjectOrientatedProgramming;

import org.example.ObjectOrientatedProgramming.ClassesObjects.Player;
import org.example.ObjectOrientatedProgramming.InterfaceAbstract.Circle;
import org.example.ObjectOrientatedProgramming.InterfaceAbstract.Rectangle;
import org.example.ObjectOrientatedProgramming.InterfaceAbstract.Shape;
import org.example.ObjectOrientatedProgramming.InterfaceAbstract.Square;

public class OOP {
    public static void classesObjects(){
        Player.shout("Drogba"); // Static method

        Player newPlayer = new Player("Lampard"); // Constructor init new instance of Player class
        String name = newPlayer.getName();
        int goals = newPlayer.getGoals();
        newPlayer.publicScoreGoalMethod();
        int newGoals = newPlayer.getGoals();
//        int salary = newPlayer.getSalary    get salary is private method cannot access outside Player class
    }

    public static void interfaceAbstract(){
        // Interface
        Shape circle = new Circle();
        circle.draw();

        Shape square = new Square();
        square.draw();

        // Abstract
        Rectangle rectangle = new Rectangle(2,3);
        rectangle.draw();
        int area = rectangle.calculateArea();

    }
}
