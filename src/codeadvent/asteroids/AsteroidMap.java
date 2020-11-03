package codeadvent.asteroids;

import java.util.ArrayList;
import java.util.List;

public class AsteroidMap {

    private static final List<Point> asteroids = new ArrayList<>();

    public static List<Point> createMap(List<String> fileLines) {
        int rowNum = fileLines.size();
        int colNum = fileLines.get(0).toCharArray().length;
        for (int x = 0; x < rowNum; x++) {
            char[] rowLine = fileLines.get(x).toCharArray();
            for (int y = 0; y < colNum; y++) {
                if (rowLine[y] == '#') {
                    asteroids.add(new Point(y, x));
                }
            }
        }
        System.out.println("FOUND " + asteroids.size() + " ASTEROIDS.");
        return asteroids;
    }

}
