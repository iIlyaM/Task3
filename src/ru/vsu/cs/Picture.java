package ru.vsu.cs;

public class Picture {
    private Circle smallCircle;
    private Circle bigCircle;
    private Parabola bigParabola;
    private Parabola smallParabola;
    private Rectangle rectangle;

    public Picture(Circle smallCircle, Circle bigCircle, Parabola bigParabola, Parabola smallParabola,
                   Rectangle rectangle) {
        this.smallCircle = smallCircle;
        this.bigCircle = bigCircle;
        this.bigParabola = bigParabola;
        this.smallParabola = smallParabola;
        this.rectangle = rectangle;
    }

    public SimpleColor getColor(double x, double y) {
        if(smallCircle.isPointInside(x,y) || (rectangle.isPointInside(x,y) && !bigCircle.isPointInside(x,y))) {
            return SimpleColor.GRAY;
        }
        if(bigParabola.isPointInside(x,y) || (bigCircle.isPointInside(x,y) && rectangle.isPointInside(x,y))) {
            return SimpleColor.WHITE;
        }
        if(bigParabola.isPointInside(x,y) && smallParabola.isPointInside(x,y)) {
            return SimpleColor.YELLOW;
        }
        return SimpleColor.BLUE;
    }
}
