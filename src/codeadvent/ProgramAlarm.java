package codeadvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramAlarm {

    public static void main(String[] args) {

        List<Integer> program = Arrays.asList(1002,4,3,4,33);

//        List<Integer> program = Arrays.asList(1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,19,1,19,6,23,1,23,6,27,1,13,27,31,2,13,31,
//                35,1,5,35,39,2,39,13,43,1,10,43,47,2,13,47,51,1,6,51,55,2,55,13,59,1,59,10,63,1,63,10,67,2,10,67,71,1,6,71,75,1,
//                10,75,79,1,79,9,83,2,83,6,87,2,87,9,91,1,5,91,95,1,6,95,99,1,99,9,103,2,10,103,107,1,107,6,111,2,9,111,115,1,5,
//                115,119,1,10,119,123,1,2,123,127,1,127,6,0,99,2,14,0,0);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {

                List<Integer> currentProgram = new ArrayList<>();
                for (Integer item : program) {
                    currentProgram.add(new Integer(item));
                }
                currentProgram.set(1, i);
                currentProgram.set(2, j);

                if (callProgram(currentProgram) == 19690720) {
                    System.out.println(currentProgram);
                    return;
                }
            }
        }

    }

    private static int callProgram(List<Integer> program) {
        for (int i = 0; i < program.size(); i += 4) {
            if (program.get(i) == 99) {
                break;
            } else if (program.get(i) == 1) {
                int inIdx1 = program.get(i+1);
                int inIdx2 = program.get(i+2);
                int outIdx = program.get(i+3);
                program.set(outIdx, program.get(inIdx1) + program.get(inIdx2));

            } else if (program.get(i) == 2) {
                int inIdx1 = program.get(i+1);
                int inIdx2 = program.get(i+2);
                int outIdx = program.get(i+3);
                program.set(outIdx, program.get(inIdx1) * program.get(inIdx2));

            } else if (program.get(i) == 3) {
                int inIdx = program.get(i+1);
                program.set(inIdx, inIdx);

            } else if (program.get(i) == 4) {
                int outIdx = program.get(i+1);
                System.out.println("Output for 4: " + program.get(outIdx));
//                int inIdx1 = program.get(i+1);
//                int inIdx2 = program.get(i+2);
//                int outIdx = program.get(i+3);
//                program.set(outIdx, program.get(inIdx1) * program.get(inIdx2));

            } else {
                System.out.println("Wrong input!");
            }
        }
        return program.get(0);
    }

}
