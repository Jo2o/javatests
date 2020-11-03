package codeadvent;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProgramAlarmModes {

    public static void main(String[] args) {

//        List<Integer> program = Arrays.asList(1002,4,3,4,33);
//        List<Integer> program = Arrays.asList(1101,100,-1,4,0);

        List<Integer> program = Arrays.asList(3,225,1,225,6,6,1100,1,238,225,104,0,101,67,166,224,1001,224,-110,224,4,224,102,8,223,223,1001,224,4,224,1,224,223,223,2,62,66,224,101,-406,224,224,4,224,102,8,223,223,101,3,224,224,1,224,223,223,1101,76,51,225,1101,51,29,225,1102,57,14,225,1102,64,48,224,1001,224,-3072,224,4,224,102,8,223,223,1001,224,1,224,1,224,223,223,1001,217,90,224,1001,224,-101,224,4,224,1002,223,8,223,1001,224,2,224,1,223,224,223,1101,57,55,224,1001,224,-112,224,4,224,102,8,223,223,1001,224,7,224,1,223,224,223,1102,5,62,225,1102,49,68,225,102,40,140,224,101,-2720,224,224,4,224,1002,223,8,223,1001,224,4,224,1,223,224,223,1101,92,43,225,1101,93,21,225,1002,170,31,224,101,-651,224,224,4,224,102,8,223,223,101,4,224,224,1,223,224,223,1,136,57,224,1001,224,-138,224,4,224,102,8,223,223,101,2,224,224,1,223,224,223,1102,11,85,225,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,1107,226,226,224,102,2,223,223,1006,224,329,1001,223,1,223,1007,226,677,224,1002,223,2,223,1005,224,344,101,1,223,223,108,677,677,224,1002,223,2,223,1006,224,359,101,1,223,223,1008,226,226,224,1002,223,2,223,1005,224,374,1001,223,1,223,108,677,226,224,1002,223,2,223,1006,224,389,101,1,223,223,7,226,226,224,102,2,223,223,1006,224,404,101,1,223,223,7,677,226,224,1002,223,2,223,1005,224,419,101,1,223,223,107,226,226,224,102,2,223,223,1006,224,434,1001,223,1,223,1008,677,677,224,1002,223,2,223,1005,224,449,101,1,223,223,108,226,226,224,102,2,223,223,1005,224,464,1001,223,1,223,1108,226,677,224,1002,223,2,223,1005,224,479,1001,223,1,223,8,677,226,224,102,2,223,223,1006,224,494,1001,223,1,223,1108,677,677,224,102,2,223,223,1006,224,509,1001,223,1,223,1007,226,226,224,1002,223,2,223,1005,224,524,1001,223,1,223,7,226,677,224,1002,223,2,223,1005,224,539,1001,223,1,223,8,677,677,224,102,2,223,223,1005,224,554,1001,223,1,223,107,226,677,224,1002,223,2,223,1006,224,569,101,1,223,223,1107,226,677,224,102,2,223,223,1005,224,584,1001,223,1,223,1108,677,226,224,102,2,223,223,1006,224,599,1001,223,1,223,1008,677,226,224,102,2,223,223,1006,224,614,101,1,223,223,107,677,677,224,102,2,223,223,1006,224,629,1001,223,1,223,1107,677,226,224,1002,223,2,223,1005,224,644,101,1,223,223,8,226,677,224,102,2,223,223,1005,224,659,1001,223,1,223,1007,677,677,224,102,2,223,223,1005,224,674,1001,223,1,223,4,223,99,226);

//        List<Integer> program = Arrays.asList(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,
//                0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99);

        callProgram(program);
        System.out.println(program);

    }

    private static int callProgram(List<Integer> program) {

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
                break;
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
                Scanner input = new Scanner( System.in );
                System.out.println("Input int:");
                int in = input.nextInt();

                step = 2;
                int inIdx = program.get(i+1);
                program.set(inIdx, in);

            } else if (instruction == 4) {
                step = 2;
                int value = getValue(program.get(i + 1), firstMode, program);
                System.out.println("Output for 4: " + value);

            } else if (instruction == 5) {
                step = 3;
                int value1 = getValue(program.get(i+1), firstMode, program);
                int value2 = getValue(program.get(i+2), secondMode, program);
                if (value1 > 0) {
                    //step = value2;
                    i = value2 - step;//+ 1;
                }

            } else if (instruction == 6) {
                step = 3;
                int value1 = getValue(program.get(i+1), firstMode, program);
                int value2 = getValue(program.get(i+2), secondMode, program);
                if (value1 == 0) {
                    //step = value2;
                    i = value2 - step; //+ 1;
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
        return program.get(0);
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

    private static int getThirdParamMode(int in) {
        return (in/10000) % 10;
    }

    private static int getInstruction(int in) {
        if (in < 100) {
            return in;
        }
        return in%100;
    }



}