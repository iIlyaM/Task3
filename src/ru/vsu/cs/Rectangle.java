package ru.vsu.cs;

public class Rectangle {
    private double x0;
    private double y0;
    private double width;
    private double height;

    public Rectangle(double x0, double y0, double width, double height) {
        this.x0 = x0;
        this.y0 = y0;
        this.width = width;
        this.height = height;
    }

    public boolean isPointInside(double x, double y) {
        return (x0 + x) <= width && (y0 + y) <= height;
    }
}
