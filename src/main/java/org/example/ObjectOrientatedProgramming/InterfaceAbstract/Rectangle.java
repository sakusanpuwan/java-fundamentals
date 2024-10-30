package org.example.ObjectOrientatedProgramming.InterfaceAbstract;

public class Rectangle extends Quadrilateral {

    public Rectangle(int height, int length) {
        super(height, length);
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}
