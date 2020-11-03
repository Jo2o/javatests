package sk.jo2o.javatests;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SockMerchant {

    public static void main(String[] args) {
        int[] ar = {10,20,20,10,10,30,50,10,20};

        Map<Integer,Integer> counter = new HashMap<>();
        for(int i : ar) {
            if(counter.containsKey(i)) {
                counter.put(i, counter.get(i)+1);
            }
            else {
                counter.put(i,1);
            }
        }

        int sum = 0;
        for (Entry<Integer,Integer> entry : counter.entrySet()) {
            if(entry.getValue()==1) continue;
            if((entry.getValue()%2) == 0) { sum = entry.getValue()/2 + sum; continue; }
            sum = (entry.getValue()-1)/2 + sum;
        }
       // return sum;
        System.out.println(sum);
    }

}
