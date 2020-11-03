package hackerrank;

import java.util.*;

public class HackerRankEvenChars {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        List<String> lines = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            lines.add(scanner.nextLine().trim());
        }
        lines.remove(0);
        for (String line : lines) {
            int counter = 0;
            StringBuilder evens = new StringBuilder();
            StringBuilder odds = new StringBuilder();
            for (char ch : line.toCharArray()) {
                if ((counter % 2) == 0) {
                    odds.append(ch);
                } else {
                    evens.append(ch);
                }
                counter++;
            }
            System.out.print(odds + " " + evens + "\n");
        }
    }



}
