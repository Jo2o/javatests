package codeadvent.asteroids;

import java.math.BigDecimal;
import java.util.Objects;

public class Vector
//        implements Comparable<Vector>
{

    private double x;
    private double y;
    private double angle;
    private double length;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

//    @Override
//    public int compareTo(Vector anotherVector) {
//        BigDecimal angleBD = BigDecimal.valueOf(angle).setScale(20,BigDecimal.ROUND_HALF_UP);
//        BigDecimal anotherAngleBD = BigDecimal.valueOf(anotherVector.getAngle()).setScale(20,BigDecimal.ROUND_HALF_UP);
//        BigDecimal lengthBD = BigDecimal.valueOf(length).setScale(20,BigDecimal.ROUND_HALF_UP);
//        BigDecimal anotherLengthBD = BigDecimal.valueOf(anotherVector.getLength()).setScale(20,BigDecimal.ROUND_HALF_UP);
//        if ((angleBD.compareTo(anotherAngleBD) == 0) && (lengthBD.compareTo(anotherLengthBD) == 0)) {
//            return 0;
//        } else if ((angleBD.compareTo(anotherAngleBD) > 0) && (lengthBD.compareTo(anotherLengthBD) > 0)) {
//            return 1;
//        } else if ((angleBD.compareTo(anotherAngleBD) == 0) && (lengthBD.compareTo(anotherLengthBD) > 0)) {
//            return 1;
//        } else if ((angleBD.compareTo(anotherAngleBD) > 0) && (lengthBD.compareTo(anotherLengthBD) == 0)) {
//            return 1;
//
//        } else {
//            return -1;
//        }
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Vector vector = (Vector) o;
//        return Double.compare(vector.angle, angle) == 0 && Double.compare(vector.length, length) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(angle, length);
//    }


    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", angle=" + angle +
                ", length=" + length +
                '}';
    }

}
