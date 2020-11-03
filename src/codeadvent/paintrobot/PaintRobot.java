package codeadvent.paintrobot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PaintRobot {

    private static int COUNTER;
    private static int TURN_LEFT = 0;
    private static int TURN_RIGHT = 1;

    public static void main(String[] args) {
        //                                           0   1   2      3   4     5      6   7    8   9   10  11    12  13    14  15  16  17    18   19  20   21    22  23   24   25  26   27     28  29  30   31  32   33     34  35  36   37  38     39   40   41  42     43  44   45  46  47     48  49   50   51     52   53  54   55  56   57    58  59  60
        Program program = new Program(Arrays.asList("3","8","1005","8","299","1106","0","11","0","0","0","104","1","104","0","3","8","102","-1","8","10","101","1","10","10","4","10","1008","8","0","10","4","10","1002","8","1","29","1","1007","14","10","2","1106","8","10","3","8","1002","8","-1","10","1001","10","1","10","4","10","108","1","8","10","4","10","1002","8","1","58","3","8","1002","8","-1","10","101","1","10","10","4","10","108","0","8","10","4","10","1002","8","1","80","3","8","1002","8","-1","10","1001","10","1","10","4","10","1008","8","0","10","4","10","102","1","8","103","1","5","6","10","3","8","102","-1","8","10","101","1","10","10","4","10","108","1","8","10","4","10","101","0","8","128","1","106","18","10","1","7","20","10","1006","0","72","1006","0","31","3","8","1002","8","-1","10","1001","10","1","10","4","10","108","0","8","10","4","10","1002","8","1","164","3","8","1002","8","-1","10","1001","10","1","10","4","10","108","1","8","10","4","10","102","1","8","186","1","1007","8","10","1006","0","98","3","8","1002","8","-1","10","1001","10","1","10","4","10","1008","8","0","10","4","10","101","0","8","216","2","102","8","10","1","1008","18","10","1","1108","8","10","1006","0","68","3","8","1002","8","-1","10","1001","10","1","10","4","10","1008","8","1","10","4","10","1001","8","0","253","3","8","102","-1","8","10","1001","10","1","10","4","10","108","1","8","10","4","10","1002","8","1","274","1","1105","7","10","101","1","9","9","1007","9","1060","10","1005","10","15","99","109","621","104","0","104","1","21102","936995738520","1","1","21102","316","1","0","1106","0","420","21101","0","936995824276","1","21102","1","327","0","1106","0","420","3","10","104","0","104","1","3","10","104","0","104","0","3","10","104","0","104","1","3","10","104","0","104","1","3","10","104","0","104","0","3","10","104","0","104","1","21102","248129784923","1","1","21102","1","374","0","1105","1","420","21102","29015149735","1","1","21101","385","0","0","1106","0","420","3","10","104","0","104","0","3","10","104","0","104","0","21101","983925826304","0","1","21101","0","408","0","1105","1","420","21102","825012036364","1","1","21101","0","419","0","1105","1","420","99","109","2","22101","0","-1","1","21101","0","40","2","21101","0","451","3","21102","441","1","0","1105","1","484","109","-2","2105","1","0","0","1","0","0","1","109","2","3","10","204","-1","1001","446","447","462","4","0","1001","446","1","446","108","4","446","10","1006","10","478","1101","0","0","446","109","-2","2105","1","0","0","109","4","2102","1","-1","483","1207","-3","0","10","1006","10","501","21102","0","1","-3","21201","-3","0","1","22102","1","-2","2","21102","1","1","3","21101","520","0","0","1106","0","525","109","-4","2105","1","0","109","5","1207","-3","1","10","1006","10","548","2207","-4","-2","10","1006","10","548","21201","-4","0","-4","1105","1","616","21201","-4","0","1","21201","-3","-1","2","21202","-2","2","3","21102","1","567","0","1105","1","525","21202","1","1","-4","21102","1","1","-1","2207","-4","-2","10","1006","10","586","21102","0","1","-1","22202","-2","-1","-2","2107","0","-3","10","1006","10","608","21201","-1","0","1","21102","1","608","0","106","0","483","21202","-2","-1","-2","22201","-4","-2","-4","109","-5","2106","0","0"));

        List<ColorPoint> path = new ArrayList<>();
        path.add(new ColorPoint(1, 0, 0, Orientation.UP));

        long color = 100;
        long leftOrRight = 100;
        while ((color != 99) && (leftOrRight != 99)) {

            ColorPoint standingPoint = getLast(path);
            Logger.log(">>>>> IN POINT: " + standingPoint, true);
            Logger.log(">>>>> IN COLOR: " + standingPoint.getColor(), true);

            color = program.callProgram(standingPoint.getColor());
            Logger.log(">>>>> OUT COLOR: " + color, true);
            standingPoint.setColor((int) color);
            Logger.log(">>>>> STANDING POINT: " + getLast(path), true);

            if (color == 99) {
                continue;
            }

            leftOrRight = program.callProgram(Program.IGNORED_INPUT);
            Logger.log(">>>>> OUT L/R: " + leftOrRight, true);

            if (leftOrRight == 99) {
                continue;
            }

            ColorPoint nextPoint = getNextPoint(leftOrRight, standingPoint, path);
            path.add(nextPoint);
            Logger.log(">>>>> NEXT POINT: " + getLast(path), true);
            Logger.log("counter " + COUNTER, true);

        }
        Logger.log(">>>>> POINT: " + getLast(path), true);
        System.out.println("COUNTER >>>>> " + COUNTER);
        List<ColorPoint> checkList = path.stream().distinct().collect(Collectors.toList());

        System.out.println("Distinct points: " + checkList.size());

        Plotter plotter = new Plotter();
        plotter.draw(path);
    }

    private static ColorPoint getNextPoint(long leftOrRight, ColorPoint standingPoint, List<ColorPoint> path) {
        Orientation resultOrientation = Orientation.UP;
        int resultX = -1000;
        int resultY = -1000;

        if (standingPoint.getOrientation() == Orientation.UP) {
            if (leftOrRight == TURN_RIGHT) {
                resultOrientation = Orientation.RIGHT;
                resultX = standingPoint.getX() + 1;
                resultY = standingPoint.getY();
            } else if (leftOrRight == TURN_LEFT) {
                resultOrientation = Orientation.LEFT;
                resultX = standingPoint.getX() - 1;
                resultY = standingPoint.getY();
            } else {
                throw new IllegalStateException("ERROR IN TURNED VECTOR!");
            }
        } else if (standingPoint.getOrientation() == Orientation.DOWN) {
            if (leftOrRight == TURN_RIGHT) {
                resultOrientation = Orientation.LEFT;
                resultX = standingPoint.getX() - 1;
                resultY = standingPoint.getY();
            } else if (leftOrRight == TURN_LEFT) {
                resultOrientation = Orientation.RIGHT;
                resultX = standingPoint.getX() + 1;
                resultY = standingPoint.getY();
            } else {
                throw new IllegalStateException("ERROR IN TURNED VECTOR!");
            }
        } else if (standingPoint.getOrientation() == Orientation.LEFT) {
            if (leftOrRight == TURN_RIGHT) {
                resultOrientation = Orientation.UP;
                resultX = standingPoint.getX();
                resultY = standingPoint.getY() - 1;
            } else if (leftOrRight == TURN_LEFT) {
                resultOrientation = Orientation.DOWN;
                resultX = standingPoint.getX();
                resultY = standingPoint.getY() + 1;
            } else {
                throw new IllegalStateException("ERROR IN TURNED VECTOR!");
            }
        } else if (standingPoint.getOrientation() == Orientation.RIGHT) {
            if (leftOrRight == TURN_RIGHT) {
                resultOrientation = Orientation.DOWN;
                resultX = standingPoint.getX();
                resultY = standingPoint.getY() + 1;
            } else if (leftOrRight == TURN_LEFT) {
                resultOrientation = Orientation.UP;
                resultX = standingPoint.getX();
                resultY = standingPoint.getY() - 1;
            } else {
                throw new IllegalStateException("ERROR IN TURNED VECTOR!");
            }
        }

        ColorPoint tempPoint = new ColorPoint(resultX, resultY);
        if (!path.contains(tempPoint)) {
            COUNTER++;
            return new ColorPoint(0, resultX, resultY, resultOrientation);
        }
        ColorPoint alreadyVisitedPoint = path.get(path.indexOf(tempPoint));
        alreadyVisitedPoint.setOrientation(resultOrientation);
        return alreadyVisitedPoint;
    }

    private static ColorPoint getLast(List<ColorPoint> path) {
        return path.get(path.size()-1);
    }

}