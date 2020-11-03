package codeadvent.asteroids;

import java.math.BigDecimal;
import java.util.Objects;

public class Slope {

    BigDecimal tangens;
    char quadrant;

    public BigDecimal getTangens() {
        return tangens;
    }

    public void setTangens(BigDecimal tangens) {
        this.tangens = tangens;
    }

    public char getQuadrant() {
        return quadrant;
    }

    public void setQuadrant(char quadrant) {
        this.quadrant = quadrant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Slope slope = (Slope) o;
        return (quadrant == slope.quadrant) && (tangens.compareTo(slope.tangens) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tangens, quadrant);
    }

}
