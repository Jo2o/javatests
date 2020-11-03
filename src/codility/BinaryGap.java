package codility;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(solution(5546));
    }


    static int solution(int number) {
        String binaryString = Integer.toBinaryString(number);
        System.out.println("BINARY STRING: " + binaryString);
        char[] charArray = binaryString.toCharArray();
        int counter = 0;
        int max = 0;
        boolean gapSwitch = false;
        for (int i = 0; i < (binaryString.length() - 1); i++) {
            if ((charArray[i] == '1') && (charArray[i + 1] == '0') && !gapSwitch) {
                gapSwitch = true;
                continue;
            }
            if ((charArray[i] == '0') && (charArray[i + 1] == '1') && gapSwitch) {
                gapSwitch = false;
                counter++;
                if (max < counter) {
                    max = counter;
                }
                counter = 0;
                continue;
            }
            if (gapSwitch) {
                counter++;
            }
        }
        return max;
    }

}
