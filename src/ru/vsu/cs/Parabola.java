package ru.vsu.cs;

public class Parabola {
    private double x0;
    private double y0;
    private double a;

    public Parabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointInside(double x, double y) {
        if (a > 0) {
            return a * Math.pow(x - x0, 2) + y0 <= y;
        } else {
            return a * Math.pow(x - x0, 2) + y0 >= y;
        }
    }
}
