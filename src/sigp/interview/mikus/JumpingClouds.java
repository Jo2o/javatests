package sigp.interview.mikus;

public class JumpingClouds {

    private static int jumpCloudsCount(int[] c) {
        int jumpCounter = 0;
        int i = 0;

        while((i+2)<c.length) {
            if (c[i+2]==0) {
                jumpCounter++;
                i+=2;
                continue;
            }
            if (c[i+1]==0) {
                jumpCounter++;
                i+=1;
                continue;
            }
        }

        if (c.length == i+2) {
            if (c[i+1]==0) jumpCounter++;
        }

        return jumpCounter;
    }

    public static void main(String[] args) {

        System.out.println(jumpCloudsCount(new int[] {0, 0, 0, 1, 0, 0}));

    }

}
