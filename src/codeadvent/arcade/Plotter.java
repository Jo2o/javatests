package codeadvent.arcade;

import java.util.ArrayList;
import java.util.List;


public class Plotter {

    private static final int X_SIZE = 50;
    private static final int Y_SIZE = 25;

    private static final int ID_EMPTY = 0;
    public static final int ID_WALL = 1;
    private static final int ID_BLOCK = 2;
    public static final int ID_PADDLE = 3;
    public static final int ID_BALL = 4;

    private static final int CHAR_EMPTY = ' ';
    private static final int CHAR_WALL = '#';
    private static final int CHAR_BLOCK = 'X';
    private static final int CHAR_PADDLE = 'T';
    private static final int CHAR_BALL = 'O';

    private List<List<Character>> canvas  = new ArrayList<>();

    public Plotter() {
        for (int y = 0; y < Y_SIZE; y++) {
            List<Character> line = new ArrayList<>();
            for (int x = 0; x < X_SIZE; x++) {
                line.add(' ');
            }
            canvas.add(line);
        }
    }

    public void draw(long x, long y, long id) {
        char character = decode(id);
        canvas.get((int) y).set((int) x, character);
        if (ID_BALL == id) {
            draw();
        }
    }

    private char decode(long id) {
        if (ID_EMPTY == id) {
            return CHAR_EMPTY;
        }
        if (ID_WALL == id) {
            return CHAR_WALL;
        }
        if (ID_BLOCK == id) {
            return CHAR_BLOCK;
        }
        if (ID_PADDLE == id) {
            return CHAR_PADDLE;
        }
        if (ID_BALL == id) {
            return CHAR_BALL;
        }
        return '8';
    }

    public void draw() {
        for (int y = 0; y < Y_SIZE; y++) {
            for (int x = 0; x < X_SIZE; x++) {
                System.out.print(canvas.get(y).get(x));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Plotter plotter = new Plotter();
        plotter.draw(0, 0, 0);
    }

}
