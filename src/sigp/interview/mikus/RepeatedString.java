package sigp.interview.mikus;

public class RepeatedString {

    private static long resultcheckString(String s, long n) {

        long stringLength = s.length();
        char[] charArray = s.toCharArray();

        long wholeStringCount = n / stringLength;
        long lastPartLength = n - (stringLength*wholeStringCount);

        long countAInLastPart = 0;
        long countAInString = 0;

        for (int i = 0; i < stringLength; i++) {
            if (charArray[i] == 'a') {
                countAInString++;
                if (i < lastPartLength) {
                    countAInLastPart++;
                }
            }
        }

        return countAInLastPart + countAInString*wholeStringCount;
    }




    public static void main(String[] args) {

        System.out.println(resultcheckString("ahaj", 13));

    }

}
