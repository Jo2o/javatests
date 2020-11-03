package codeadvent.imgdecode;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImageDecode2 {

    private static final int WIDTH = 25;
    private static final int HEIGHT = 6;
    private static final int LAYER_SIZE = WIDTH * HEIGHT;
    private static final int MIN = LAYER_SIZE;

    public static void main(String[] args) throws IOException {
        List<List<Integer>> layers = readFile("C:\\Work\\SCR\\projects\\JavaTests\\src\\codeadvent\\imgdecode\\in.txt");
        List<String> overlayedLayer = overlay(layers);
        printLayer(overlayedLayer);
    }

    private static List<String> overlay(List<List<Integer>> layers) {
        List<String> resultLayer = new ArrayList<>();
        for (int i = 0; i < LAYER_SIZE; i++) {
            for (List<Integer> current : layers) {
                int currentPx = current.get(i);
                if (currentPx == 0) {
                    resultLayer.add("-");
                    break;
                }
                if (currentPx == 1) {
                    resultLayer.add("O");
                    break;
                }
            }
        }
        return resultLayer;
    }

    private static void printLayer(List<String> layer) {
        int counter = -1;
        for (String i: layer) {
            counter++;
            if (counter%WIDTH == 0) {
                System.out.println();
                System.out.print(i);
            }
            System.out.print(i);
        }
    }

    private static int count1sXcount2s(List<Integer> layer) {
        int ones = 0;
        int twos = 0;
        for (int i : layer) {
            if (i == 1) ones++;
            else if (i == 2) twos++;
        }
        return ones * twos;
    }

    private static List<Integer> findFewest0(List<List<Integer>> layers) {
        List<Integer> result = new ArrayList<>();
        int min = LAYER_SIZE;
        for (List<Integer> layer : layers) {
            int zeros = countZeros(layer);
            if (zeros < min) {
                result = layer;
                min = zeros;
            }
        }

        return result;
    }

    private static int countZeros(List<Integer> layer) {
        int counter = 0;
        for (int i : layer) {
            if (i==0) {
                counter++;
            }
        }
        return counter;
    }

    private static List<List<Integer>> readFile(String fileAbsolutePath) throws IOException {
        List<List<Integer>> layers = new ArrayList<>();
        String[] ints = null;

        try {
            for (String line : Files.readAllLines(Paths.get(fileAbsolutePath))) {
                ints = line.split(",");
            }
        } catch (IOException ex) { }

        List<Integer> layer = null;
        for (int i=0; i < ints.length; i++) {
            if (i%LAYER_SIZE == 0) {
                layer = new ArrayList<>();
                layers.add(layer);
            }
            layer.add(Integer.parseInt(ints[i]));
        }
        return layers;
    }

}
