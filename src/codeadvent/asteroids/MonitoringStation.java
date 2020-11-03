package codeadvent.asteroids;

import java.util.ArrayList;
import java.util.List;
import codeadvent.util.FileReader;

public class MonitoringStation {

    public static void main(String[] args) {
        List<String> fileLines = FileReader.readFileLines(
//                "C:\\Work\\SCR\\projects\\JavaTests\\src\\codeadvent\\asteroids\\in.txt"
                "C:\\Work\\SCR\\projects\\JavaTests\\src\\codeadvent\\asteroids\\in33.txt"
        );
        List<Point> asteroids = AsteroidMap.createMap(fileLines);

        int max = 0;
        Point mostConvenient = null;

        for (int i = 0; i < asteroids.size(); i++) {
            List<Slope> slopes = new ArrayList<>();
            System.out.println("--------------------------------");
            for (int j = 0; j < asteroids.size(); j++) {
                double deltaY = asteroids.get(j).getY() - asteroids.get(i).getY();
                double deltaX = asteroids.get(j).getX() - asteroids.get(i).getX();

                System.out.println("\nPosition for A[" + asteroids.get(i).getX() + "," + asteroids.get(i).getY() + "] and B[" + asteroids.get(j).getX() + "," + asteroids.get(j).getY() + "]");
                System.out.println("Delta Y: " + deltaY + ", Delta X: " + deltaX);

                if (deltaX == deltaY && deltaX == 0.0) {
                    System.out.println("\n>>> SKIPPING ITSELF!");
                    continue;
                }

                Slope slope = new Slope();
                slope.setQuadrant(countQuadrant(deltaX, deltaY));
                //slope.setTangens(countTangens(deltaX, deltaY));
                System.out.println("Slope: " + slope.getTangens() + " (Q:" + slope.getQuadrant() + ")");

                boolean alreadyAccounted = false;
                for (Slope slopeToCompare : slopes) {
//                    if (Double.doubleToLongBits(slopeToCompare.getTangens()) == Double.doubleToLongBits(slope.getTangens())
//                            && (slopeToCompare.getQuadrant() == slope.getQuadrant())) {
                        alreadyAccounted = true;
//                    }
                }
                if (!alreadyAccounted) {
                    slopes.add(slope);
                }
            }
            System.out.println("\nSLOPES SIZE: " + slopes.size());
            if (slopes.size() > max) {
                max = slopes.size();
                mostConvenient = asteroids.get(i);
            }
        }

        System.out.println(">>>>>>>>>> RESULT: " + mostConvenient.getX() + "," + mostConvenient.getY());
    }

    private static double countTangens(double deltaX, double deltaY) {
        double result = 111.0;
        if (deltaX != 0) {
            result = deltaY / deltaX;
        }
        return result;
    }

    private static char countQuadrant(double deltaX, double deltaY) {
        if (deltaX > 0 && deltaY >= 0) {
            return '1';
        }
        if (deltaX <= 0 && deltaY > 0) {
            return '2';
        }
        if (deltaX < 0 && deltaY <= 0) {
            return '3';
        }
        //if (deltaX >= 0 && deltaY < 0)
        return '4';
    }

}


