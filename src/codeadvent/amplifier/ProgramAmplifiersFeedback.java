package codeadvent.amplifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramAmplifiersFeedback {

    public static void main(String[] args) {

        boolean brzda = false;

        int max = 0;

        int[] phases = {5,6,7,8,9};
        ArrayList<ArrayList<Integer>> permutations = permute(phases);

        for (ArrayList<Integer> permutation : permutations) {

            List<Integer> ampA = new ArrayList<>(Arrays.asList(3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5));
            List<Integer> ampB = new ArrayList<>(Arrays.asList(3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5));
            List<Integer> ampC = new ArrayList<>(Arrays.asList(3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5));
            List<Integer> ampD = new ArrayList<>(Arrays.asList(3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5));
            List<Integer> ampE = new ArrayList<>(Arrays.asList(3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5));

            int outA;
            int outB;
            int outC;
            int outD;
            int outE = 0;
            while (!brzda) {
                outA = callProgram(permutation.get(0), outE, ampA);
                outB = callProgram(permutation.get(1), outA, ampB);
                outC = callProgram(permutation.get(2), outB, ampC);
                outD = callProgram(permutation.get(3), outC, ampD);
                outE = callProgram(permutation.get(4), outD, ampE);
                if (false) {
                    brzda = true;
                }
            }

            if (outE > max) {
                max = outE;
            }
        }
        System.out.println("------");
        System.out.println("RESULT: " + max);
    }

    private static int callProgram(int input1, int input2, List<Integer> program) {

        int inputCounter = 0;
        int result = -1;

        int instruction = getInstruction(program.get(0));
        int step;
        if ((instruction == 1) || (instruction == 2)) {
            step = 4;
        } else {
            step = 2;
        }

        for (int i = 0; i < program.size(); i += step) {
            instruction = getInstruction(program.get(i));
            int firstMode = getFirstParamMode(program.get(i));
            int secondMode = getSecondParamMode(program.get(i));

            if (instruction == 99) {
                System.out.println(">>>>>> FINISHED <<<<<< " + result);
                return result;
            } else if (instruction == 1) {
                step = 4;
                int value1 = getValue(program.get(i+1), firstMode, program);
                int value2 = getValue(program.get(i+2), secondMode, program);
                int outIdx = program.get(i+3);
                program.set(outIdx, value1 + value2);

            } else if (instruction == 2) {
                step = 4;
                int value1 = getValue(program.get(i+1), firstMode, program);
                int value2 = getValue(program.get(i+2), secondMode, program);
                int outIdx = program.get(i+3);
                program.set(outIdx, value1 * value2);

            } else if (instruction == 3) {
                /*Opcode 3 takes a single integer as input and saves it to the position given by its only parameter.*/
                step = 2;
                int inIdx = program.get(i+1);

                inputCounter++;
                if (inputCounter == 1) {
                    program.set(inIdx, input1);
                } else {
                    program.set(inIdx, input2);
                }

            } else if (instruction == 4) {
                step = 2;
                int value = getValue(program.get(i + 1), firstMode, program);
                System.out.println("Output for 4: " + value);
                //result = value;
                return value;

            } else if (instruction == 5) {
                step = 3;
                int value1 = getValue(program.get(i+1), firstMode, program);
                int value2 = getValue(program.get(i+2), secondMode, program);
                if (value1 > 0) {
                    i = value2 - step;
                }

            } else if (instruction == 6) {
                step = 3;
                int value1 = getValue(program.get(i+1), firstMode, program);
                int value2 = getValue(program.get(i+2), secondMode, program);
                if (value1 == 0) {
                    i = value2 - step;
                }

            } else if (instruction == 7) {
                step = 4;
                int value1 = getValue(program.get(i+1), firstMode, program);
                int value2 = getValue(program.get(i+2), secondMode, program);
                int outIdx = program.get(i+3);
                if (value1 < value2) {
                    program.set(outIdx, 1);
                } else {
                    program.set(outIdx, 0);
                }

            } else if (instruction == 8) {
                step = 4;
                int value1 = getValue(program.get(i+1), firstMode, program);
                int value2 = getValue(program.get(i+2), secondMode, program);
                int outIdx = program.get(i+3);
                if (value1 == value2) {
                    program.set(outIdx, 1);
                } else {
                    program.set(outIdx, 0);
                }

            } else {
                System.out.println("Wrong input at i: " + i);
            }
        }

        System.out.println("RESULT: " + result);
        return result;
    }

    private static int getValue(int in, int mode, List<Integer> program) {
        if (mode == 0) {
            return program.get(in);
        }
        return in;
    }

    private static int getFirstParamMode(int in) {
        return (in/100) % 10;
    }

    private static int getSecondParamMode(int in) {
        return (in/1000) % 10;
    }

    private static int getInstruction(int in) {
        if (in < 100) {
            return in;
        }
        return in%100;
    }

    private static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int value : num) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();
            for (ArrayList<Integer> l : result) {
                for (int j = 0; j < (l.size() + 1); j++) {
                    l.add(j, value);
                    ArrayList<Integer> temp = new ArrayList<>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            result = new ArrayList<>(current);
        }
        return result;
    }



}
