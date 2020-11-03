package codeadvent;

public class Password {

    public static void main(String[] args) {
        int min = 108457;
        int max = 562041;
        int counter = 0;

        for (int i  = 108457; i < 562041; i++) {
            if (isAtLeastOneDouble(i) && isIncreasedOrSame(i) && containsOneSeparatedDouble(i)) {
                System.out.println(i);
                counter++;
            }
        }
        System.out.println(counter);
    }

    private static boolean containsOneSeparatedDouble(int input) {
        String num = Integer.toString(input);
        char[] chars = num.toCharArray();
        if (chars[0] == chars[1] && chars[1] != chars[2]) {
            return true;
        }
        for (int i = 1; i < 4; i++) {
            char previous = chars[i-1];
            char current = chars[i];
            char next = chars[i+1];
            char nextNext = chars[i+2];
            if (previous != current && current == next && current != nextNext) {
                return true;
            }

        }
        if (chars[3] != chars[4] && chars[4] == chars[5]) {
            return true;
        }
        return false;
    }

    private static boolean isIncreasedOrSame(int input) {
        String num = Integer.toString(input);
        char[] chars = num.toCharArray();
        int previous = Integer.parseInt(String.valueOf(chars[0]));
        for (int i = 1; i < 6; i++) {
            int current = Integer.parseInt(String.valueOf(chars[i]));
            if (previous > current) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    private static boolean isAtLeastOneDouble(int input) {
        String num = Integer.toString(input);
        char[] chars = num.toCharArray();
        char previous = chars[0];
        for (int i = 1; i < 6; i++) {
            char current = chars[i];
            if (current == previous) {
                return true;
            }
            previous = current;
        }
        return false;
    }


}
