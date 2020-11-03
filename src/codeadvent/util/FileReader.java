package codeadvent.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> readFileLines(String fileAbsolutePath) {
        List<String> lines = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Paths.get(fileAbsolutePath))) {
                lines.add(line);
            }
        } catch (IOException ex) { }
        return lines;
    }

}
