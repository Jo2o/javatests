package sigp.interview.mikus;

import java.util.Stack;

public class Brackets {

    private static boolean resultcheckString(String text) {
        if (text == null || text.isEmpty())
            return false;

        char[] chars = text.toCharArray();
        Stack stack = new Stack();

        for (char ch : chars) {
            if ( !(isLeftBracket(ch)||isRightBracket(ch)) ) {
                continue;
            }
            if (isLeftBracket(ch)) {
                stack.push(new Character(ch));
            }
            if (isRightBracket(ch)) {
                try {
                    Character ch1 = (Character) stack.pop();
                    if (!isPair(ch1,ch)) {
                        return false;
                    }
                } catch(Exception e) {
                    return false;
                }

            }
        }
        return true;
    }

    private static boolean isLeftBracket(char ch) {
        if (ch == '(' || ch == '[' || ch == '{') {
            return true;
        }
        return false;
    }

    private static boolean isRightBracket(char ch) {
        if (ch == ')' || ch == ']' || ch == '}') {
            return true;
        }
        return false;
    }

    private static boolean isPair(Character left, Character right) {
        if (left == '(' && right == ')') return true;
        if (left == '[' && right == ']') return true;
        if (left == '{' && right == '}') return true;
        return false;
    }

    public static void main(String[] args) {

        System.out.println(resultcheckString("(ahoj)[ako]]{sa}([mas])"));

    }

}
