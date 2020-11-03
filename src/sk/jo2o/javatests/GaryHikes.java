package sk.jo2o.javatests;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GaryHikes {

    public static void main(String[] args) {
        String path = "DDDUUUDUDUDUDUUUUUUDDDDDDDDDDDDUUUUUUUDUDUUD";
        int runningSum = 0;
        int valleyCounter = 0;
        boolean inValleyBefore = false;

        for (int i=0; i<path.length(); i++) {
            if(path.charAt(i)=='D') runningSum++;
            else if(path.charAt(i)=='U') runningSum--;

            if (inValleyBefore) {

            }

            if (runningSum==0) valleyCounter++;
        }

        //return valleyCounter;
        System.out.println(valleyCounter);


    }

}
