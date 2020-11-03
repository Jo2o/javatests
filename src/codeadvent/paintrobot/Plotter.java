package codeadvent.paintrobot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plotter {

    private static final int CANVAS_SIZE = 250;

    private List<List<Character>> canvas  = new ArrayList<>();

    public Plotter() {
        for (int j = 0; j < CANVAS_SIZE; j++) {
            List<Character> line = new ArrayList<>();
            for (int i = 0; i < CANVAS_SIZE; i++) {
                line.add(' ');
            }
            canvas.add(line);
        }
    }

    public void draw(List<ColorPoint> path) {
        List<ColorPoint> whitePoints = getWhiteUpperPoints(path);

        // include white points to canvas
        for (ColorPoint wp : whitePoints) {
            List<Character> line = canvas.get(wp.getY() + 100);
            line.set(wp.getX() + 100, 'X');
        }

        // prints canvas
        for (int i = 0; i < CANVAS_SIZE; i++) {
            for (int j = 0; j < CANVAS_SIZE; j++) {
                System.out.print(canvas.get(i).get(j));
            }
            System.out.println();
        }
    }

    private List<ColorPoint> getWhiteUpperPoints(List<ColorPoint> path) {
        List<ColorPoint> whitePoints = new ArrayList<>();
        Collections.reverse(path);
        path.remove(0);
        for (ColorPoint cp : path) {
            if (!whitePoints.contains(cp) && cp.getColor() == 1) {
                whitePoints.add(cp);
            }
        }
        return whitePoints;
    }

    public static void main(String[] args) {
        Plotter plotter = new Plotter();
        plotter.draw(new ArrayList<>());
    }

    //    public void draw() {
    //        for (int i = 0; i < CANVAS_SIZE; i++) {
    //            for (int j = 0; j < CANVAS_SIZE; j++) {
    //                System.out.print(canvas.get(i).get(j));
    //            }
    //            System.out.println();
    //        }
    //    }

}
