package org.example.ObjectOrientatedProgramming.InterfaceAbstract;

abstract class Quadrilateral {
    protected int height;
    protected int length;

    public Quadrilateral(int height, int length){
        this.height = height;
        this.length = length;
    }

    public int calculateArea() {
        return height * length;
    }

    public abstract void draw();
}
