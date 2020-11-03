package sigp.interview.luptak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class brackets {

    private static boolean resultcheckString(String text) {

        int char1 = text.indexOf("(");
        int char2 = text.indexOf(")");
        int char3 = text.indexOf("[");
        int char4 = text.indexOf("]");
        int char5 = text.indexOf("{");
        int char6 = text.indexOf("}");

        boolean result = false;
        if ((char1<char2) && (char3<char4) && (char5<char6)             )
        {
            result = true;
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String text = bufferedReader.readLine();

        boolean result = resultcheckString(text);

        bufferedWriter.write(String.valueOf(result ? 1 : 0));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
