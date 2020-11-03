package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CommonSubstring {

    public static void main(String[] args) {
        System.out.println(twoStrings("ahojahoj", "dobre"));
    }

    private static String twoStrings(String s1, String s2) {
        if ((s1 == null) || s1.isEmpty() || (s2 == null) || s2.isEmpty()) {
            return "NO";
        }
        s1 = createFrequencyString(s1);
        s2 = createFrequencyString(s2);
        for (char ch2 : s2.toCharArray()) {
            for (char ch1 : s1.toCharArray()) {
                if (ch1 == ch2) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    private static String createFrequencyString(String str) {
        List<Character> uniqueChars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            if (!uniqueChars.contains(ch)) {
                uniqueChars.add(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : uniqueChars) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

}
