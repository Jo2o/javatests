package codeadvent.paintrobot;

import java.util.Objects;

public class ColorPoint {

    private int color = 0;
    private int x = 0;
    private int y = 0;

    private Orientation orientation;

    public ColorPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ColorPoint(int color, int x, int y, Orientation orientation) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ColorPoint that = (ColorPoint) o;
        return (x == that.x) && (y == that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, x, y, orientation);
    }

    @Override
    public String toString() {
        return "ColorPoint{color=" + color + ", x=" + x + ", y=" + y + ", orientation=" + orientation + '}';
    }

}
