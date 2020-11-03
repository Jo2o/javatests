package codeadvent.boostprogram;

import java.util.List;

public class Program {

    /* modes */
    private static final int POSITIONAL = 0;
    private static final int IMMEDIATE = 1;
    private static final int RELATIVE_BASE = 2;

    /* instructions */
    private static final int EXIT = 99;
    private static final int ADD = 1;
    private static final int MULTIPLY = 2;
    private static final int INPUT = 3;
    private static final int OUTPUT = 4;
    private static final int JUMP_ON_TRUE = 5;
    private static final int JUMP_ON_ZERO = 6;
    private static final int LESS_THAN = 7;
    private static final int EQUAL = 8;
    private static final int RELATIVE_BASE_OFFSET = 9;

    private final LargeList program;

    private long relativeBase = 0;

    public Program(List<String> prg) {
        program = new LargeList(prg);
    }

    public long callProgram(long input) {
        long result = Integer.MIN_VALUE;
        int step = 0;

        for (long i = 0; i < program.size(); i += step) {

            int instruction = getInstruction(program.get(i));
            int firstMode = getFirstParamMode(program.get(i));
            int secondMode = getSecondParamMode(program.get(i));
            int thirdMode = getThirdParamMode(program.get(i));

            if (instruction == EXIT) {
                return result;

            } else if (instruction == ADD) {
                step = 4;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                long outIdx = getIndex(program.get(i + 3), thirdMode);
                program.set(outIdx, value1 + value2);
                System.out.println("STEP i: " + i + " ADDING " + value1 + " + " + value2 + " PUT RESULT " + (value1 + value2) + " TO idx: " + outIdx);

            } else if (instruction == MULTIPLY) {
                step = 4;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                long outIdx = getIndex(program.get(i + 3), thirdMode); //                        program.get(i + 3));
                program.set(outIdx, value1 * value2);
                System.out.println("STEP i: " + i + " MULTIPLY " + value1 + " * " + value2 + " PUT RESULT " + (value1*value2) + " TO idx: " + outIdx);

            } else if (instruction == INPUT) {
                step = 2;
//                System.out.print("Input int <<< ");
//                Scanner scan = new Scanner( System.in );
//                int in = scan.nextInt();
//                long inIdx = program.get(i + 1);
                long inIdx = getValue(program.get(i + 1), firstMode);
                if (firstMode == RELATIVE_BASE) {
                    inIdx = program.get(i + 1) + relativeBase;
                }
                program.set(inIdx, input); //input <-> in
                System.out.println("STEP i: " + i + " PUT INPUT " + input + " TO idx: " + inIdx);

            } else if (instruction == OUTPUT) {
                step = 2;
                long value = getValue(program.get(i + 1), firstMode);
                System.out.println("STEP i: " + i + " OUTPUT IS: " + value + " FROM idx: " + (program.get(i + 1) + relativeBase));
                result = value;
            } else if (instruction == JUMP_ON_TRUE) {
                step = 3;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                if (value1 > 0) {
                    i =  (value2 - step);
                    System.out.println("STEP i: " + i + " JUMPING ON > 0 -> " + value2 + ", value1: " + value1);
                }

            } else if (instruction == JUMP_ON_ZERO) {
                step = 3;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                if (value1 == 0) {
                    i =  (value2 - step);
                    System.out.println("STEP i: " + i + " JUMPING ON ZERO TO " + value2 + ", value1: " + value1);
                }

            } else if (instruction == LESS_THAN) {
                step = 4;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                long outIdx = getIndex(program.get(i + 3), thirdMode); //                        program.get(i + 3));
                if (value1 < value2) {
                    program.set(outIdx, 1L);
                    System.out.println("STEP i: " + i + " COMPARED: " + value1 + " < " + value2 + " PUT RESULT 1 TO idx: " + outIdx);
                } else {
                    program.set(outIdx, 0L);
                    System.out.println("STEP i: " + i + " COMPARED: " + value1 + " < " + value2 + " PUT RESULT 0 TO idx: " + outIdx);
                }

            } else if (instruction == EQUAL) {
                step = 4;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                long outIdx = getIndex(program.get(i + 3), thirdMode);
                if (value1 == value2) {
                    program.set(outIdx, 1L);
                    System.out.println("STEP i: " + i + " EQUALS: " + value1 + " == " + value2 + " PUT RESULT 1 TO idx: " + outIdx);
                } else {
                    program.set(outIdx, 0L);
                    System.out.println("STEP i: " + i + " EQUALS: " + value1 + " != " + value2 + " PUT RESULT 0 TO idx: " + outIdx);
                }

            } else if (instruction == RELATIVE_BASE_OFFSET) {
                step = 2;
                long previousRelOffset = relativeBase;
                long value = getValue(program.get(i + 1), firstMode);
                relativeBase += value;
                System.out.println("STEP i: " + i + " SETTING RELATIVE BASE OFFSET FROM " + previousRelOffset + " TO " + relativeBase + ", INSTRUCTION: " + program.get(i) + "   VALUE: " + program.get(i + 1) + "   DECODED VALUE: " + value);

            } else {
                System.out.println("Wrong input at i: " + i);
            }
        }
        System.out.println("!!!SHOULD NOT GET HERE!!!");
        return result;
    }

    private long getValue(long in, int mode) {
        if (POSITIONAL == mode) {
            return program.get(in);
        }
        if (RELATIVE_BASE == mode) {
            return program.get(in + relativeBase);
        }
        /* IMMEDIATE */
        return in;
    }

    private long getIndex(long in, int mode) {
        long result = in;
        if (RELATIVE_BASE == mode) {
            result = in + relativeBase;
        }
        return result;
    }

    private static int getFirstParamMode(long in) { return (int) ((in/100) % 10); }

    private static int getSecondParamMode(long in) { return (int) ((in/1000) % 10); }

    private int getThirdParamMode(long in) {
        int result = (int) ((in/10000) % 10);
        if (result == 0) result = 1; // if not relative => always immediate for out params
        return result;
    }

    private static int getInstruction(long in) {
        if (in < 100) {
            return (int) in;
        }
        return (int) (in%100);
    }

}
