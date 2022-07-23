package com.khoalt;

public class Circle {
    private double radius = 1;
    private static int numberOfObject = 0;

    public Circle() {
        numberOfObject++;
    }

    public Circle(double newRadius) {
        radius = newRadius;
        numberOfObject++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) {
        radius = (newRadius >= 0) ? newRadius : 0;
    }

    public static int getNumberOfObject() {
        return numberOfObject;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public static void main(String[] args) {
        Circle myCircle = new Circle(5.0);
        System.out.println("Radius is " + myCircle.radius);
        System.out.println(myCircle.getRadius());
    }
}
