package algorithms.permutation;

public class PrintAllBinaryCombinations {

    public static void main(String[] args) {
        new PrintAllBinaryCombinations().printBinaryCombination(2, "");
    }

    private void printBinaryCombination(int n, String str) {
        if (n == str.length()) {
            System.out.println(str);
            return;
        }
        printBinaryCombination(n, str + 0);
        printBinaryCombination(n, str + 1);
    }

}
