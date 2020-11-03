package codeadvent.amplifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramAmplifiersFeedbackOneInput {

    private static final int BRAKE_CODE = -99999459;

    // after phases setup
    private static int iA = 2;
    private static int iB = 2;
    private static int iC = 2;
    private static int iD = 2;
    private static int iE = 2;

    public static void main(String[] args) {

        boolean brzda = false;
        int max = 0;

        int[] phases = {5, 6, 7, 8, 9};
        ArrayList<ArrayList<Integer>> permutations = permute(phases);
        for (ArrayList<Integer> permutation : permutations) {

            resetIs();

//            permutation.clear();
//            permutation.add(9);
//            permutation.add(7);
//            permutation.add(8);
//            permutation.add(5);
//            permutation.add(6);

            System.out.println("------------------------------------------------------");
            System.out.println("Permutation: " + permutation);
            System.out.println("------------------------------------------------------");

//            List<Integer> amp = Arrays.asList(3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10);
//            List<Integer> amp = Arrays.asList(3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10);
            List<Integer> amp = Arrays.asList(3,8,1001,8,10,8,105,1,0,0,21,38,63,88,97,118,199,280,361,442,99999,3,9,1002,9,3,9,101,2,9,9,1002,9,4,9,4,9,99,3,9,101,3,9,9,102,5,9,9,101,3,9,9,1002,9,3,9,101,3,9,9,4,9,99,3,9,1002,9,2,9,1001,9,3,9,102,3,9,9,101,2,9,9,1002,9,4,9,4,9,99,3,9,102,2,9,9,4,9,99,3,9,102,4,9,9,101,5,9,9,102,2,9,9,101,5,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,99);

            List<Integer> ampA = new ArrayList<>(amp);
            List<Integer> ampB = new ArrayList<>(amp);
            List<Integer> ampC = new ArrayList<>(amp);
            List<Integer> ampD = new ArrayList<>(amp);
            List<Integer> ampE = new ArrayList<>(amp);

            prepareAmpPhase(ampA, permutation.get(0));
            prepareAmpPhase(ampB, permutation.get(1));
            prepareAmpPhase(ampC, permutation.get(2));
            prepareAmpPhase(ampD, permutation.get(3));
            prepareAmpPhase(ampE, permutation.get(4));

            printAmps(ampA, ampB, ampC, ampD, ampE);
            printIs();

            callProgram(0, ampA, 'a', true);
            callProgram(0, ampB, 'b', true);
            callProgram(0, ampC, 'c', true);
            callProgram(0, ampD, 'd', true);
            callProgram(0, ampE, 'e', true);

            System.out.println("---");
            printAmps(ampA, ampB, ampC, ampD, ampE);
            printIs();
            System.out.println("-------------------- preparation finished ---------------------");

            int outA = 0;
            int outB = 0;
            int outC = 0;
            int outD = 0;
            int outE = 0;
            int outEPrevious = 0;
            while (!brzda) {
                outEPrevious = outE;

                outA = callProgram(outE, ampA, 'a', false);
                outB = callProgram(outA, ampB, 'b', false);
                outC = callProgram(outB, ampC, 'c', false);
                outD = callProgram(outC, ampD, 'd', false);
                outE = callProgram(outD, ampE, 'e', false);

                printAmps(ampA, ampB, ampC, ampD, ampE);
                printIs();
                System.out.println("OUT-E: " + outE);
                System.out.println("OUT-E-PREVIOUS: " + outEPrevious);
                System.out.println("***************************************");

                if (outE == BRAKE_CODE) {
                    brzda = true;
                }

           }
            brzda = false;

            if (outEPrevious > max) {
                max = outEPrevious;
            }
            //break; // TODO: remove
        }

        System.out.println(">>>>>>>>>>>>>> RESULT: " + max + " <<<<<<<<<<<<<<<");
    }

    private static void resetIs() {
        iA = 2;
        iB = 2;
        iC = 2;
        iD = 2;
        iE = 2;
    }

    private static int callProgram(int input1, List<Integer> program, char id, boolean preparation) {
        int result = Integer.MIN_VALUE;
        int step = 0;

        for (int i = iToStart(id); i < program.size(); i += step) {
            int instruction = getInstruction(program.get(i));
            int firstMode = getFirstParamMode(program.get(i));
            int secondMode = getSecondParamMode(program.get(i));

            if (instruction == 99) {
                System.out.println(id + " - 99 ENDED");
                    return BRAKE_CODE;
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
                if (preparation) {
                    storeI(id, i);
                    return Integer.MIN_VALUE;
                } else {
                    step = 2;
                    int inIdx = program.get(i + 1);
                    program.set(inIdx, input1);
                    System.out.println(id + " - processing input - idx: " + inIdx + ", value: " + input1);
                }

            } else if (instruction == 4) {
                step = 2;
                int value = getValue(program.get(i + 1), firstMode, program);
                System.out.println(id + " - storing position: " + (i + step));
                System.out.println(id + " - setting output: " + value);
                System.out.println("---");
                storeI(id, i + step);
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
        System.out.println(id + " - !!!SHOULD NOT GET HERE!!!");
        return result; // should not get here!
    }

    private static void printIs() {
        System.out.println("iA: " + iA);
        System.out.println("iB: " + iB);
        System.out.println("iC: " + iC);
        System.out.println("iD: " + iD);
        System.out.println("iE: " + iE);
    }

    private static void printAmps(List<Integer>... amps) {
        for (List<Integer> amp : amps) {
            System.out.println(amp);
        }
    }

    private static void prepareAmpPhase(List<Integer> amp, int phase) {
        amp.set(amp.get(1), phase);
    }

    private static int iToStart(char id) {
        if (id == 'a') {
            return iA;
        } else if (id == 'b') {
            return iB;
        } else if (id == 'c') {
            return iC;
        } else if (id == 'd') {
            return iD;
        } else if (id == 'e') {
            return iE;
        }
        return 9999;
    }

    private static void storeI(char id, int iToGo) {
        if (id == 'a') {
            iA = iToGo;
        } else if (id == 'b') {
            iB = iToGo;
        } else if (id == 'c') {
            iC = iToGo;
        } else if (id == 'd') {
            iD = iToGo;
        } else if (id == 'e') {
            iE = iToGo;
        }
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
