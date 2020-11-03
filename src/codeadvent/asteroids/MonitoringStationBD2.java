package codeadvent.asteroids;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import codeadvent.util.FileReader;

public class MonitoringStationBD2 {

    private static int STATION_IDX = 191;

    public static void main(String[] args) {
        List<String> fileLines = FileReader
                .readFileLines("C:\\Work\\SCR\\projects\\JavaTests\\src\\codeadvent\\asteroids\\in33.txt");
        List<Point> asteroids = AsteroidMap.createMap(fileLines);
        Point station = asteroids.get(STATION_IDX);
        System.out.println("Station coordinates: " + station.getX() + "," + asteroids.get(STATION_IDX).getY());
        System.out.println("--------------------------------");

        List<Vector> vectors = new ArrayList<>();
        for (int j = 0; j < asteroids.size(); j++) {
            double deltaY = asteroids.get(j).getY() - station.getY();
            double deltaX = asteroids.get(j).getX() - station.getX();

            System.out.println(
                    "\nPosition for A[" + station.getX() + "," + station.getY() + "] and B[" + asteroids.get(j).getX()
                            + "," + asteroids.get(j).getY() + "]");
            System.out.println("Delta Y: " + deltaY + ", Delta X: " + deltaX);

            if ((deltaX == deltaY) && (deltaX == 0.0)) {
                System.out.println("\n>>> SKIPPING ITSELF!");
                continue;
            }

            Vector vector = new Vector(deltaX, deltaY);
            vector.setAngle(countAngle(vector));
            vector.setLength(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
            vectors.add(vector);

        }

        Comparator<Vector> comparator = Comparator.comparing(Vector::getAngle);
        comparator = comparator.thenComparing(Vector::getLength);
        List<Vector> sortedVectors = vectors.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        sortedVectors
                .forEach(vector -> System.out.println("x: " + vector.getX() + ", y: " + vector.getY() + ", angle: " + vector.getAngle() + ", length: " + vector.getLength()));

        Map<Double, List<Vector>> groupedSortedVectors = sortedVectors.stream()
                .collect(Collectors.groupingBy(Vector::getAngle, TreeMap::new, Collectors.toList()));

        System.out.println(groupedSortedVectors);

        Map<Double, List<Vector>> groupedReversed = reverse(groupedSortedVectors);


        vaporize(groupedSortedVectors);

        System.out.println("--- END --");
    }

    private static Map<Double, List<Vector>> reverse(Map<Double, List<Vector>> groupedSortedVectors) {
        Map<Double, List<Vector>> result = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Double, List<Vector>> entry : groupedSortedVectors.entrySet()) {
                result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private static void vaporize(Map<Double, List<Vector>> groupedSortedVectors) {
        int counter = 0;
        for (int i = 0; i <= 200; i++) {
            for (Map.Entry<Double, List<Vector>> entry : groupedSortedVectors.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    counter++;
                    System.out.println("... removing: " + entry.getValue().get(0).getX() + "," + entry.getValue().get(0).getY() + " >< counter: " + counter);
                    entry.getValue().remove(0);
                }
            }
        }
    }

    private static double countAngle(Vector vector) {
        double result = 0.0;
        double angleRad = Math.atan2(0.0,1.0) - Math.atan2(vector.getY(), vector.getX());
        double angleDeg = angleRad*360 / (2 * Math.PI);
        if (angleDeg < 0) {
            result = 360 + angleDeg;
        } else {
            result = angleDeg;
        }
        return result;
    }

}


