package codeadvent.paintrobot;

import java.util.List;

import codeadvent.boostprogram.LargeList;

public class Program {

    public static final boolean logEnabled = false;
    public static final int IGNORED_INPUT = -48569;

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

    private long currentI = 0;
    private long relativeBase = 0;

    public Program(List<String> prg) {
        program = new LargeList(prg);
    }

    public long callProgram(long input) {
        int step = 0;
        for (long i = currentI; i < program.size(); i += step) {

            int instruction = getInstruction(program.get(i));
            int firstMode = getFirstParamMode(program.get(i));
            int secondMode = getSecondParamMode(program.get(i));
            int thirdMode = getThirdParamMode(program.get(i));
            Logger.log("<" + program.get(i) + "," + program.get(i + 1) + "," + program.get(i + 2) + "," + program.get(i +3) + ">", logEnabled);

            if (instruction == EXIT) {
                return EXIT;

            } else if (instruction == INPUT) {
                if (input == IGNORED_INPUT) {
                    continue;
                }
                step = 2;
                long inIdx = getIndex(program.get(i + 1), firstMode);
                if (firstMode == RELATIVE_BASE) {
                    inIdx = program.get(i + 1) + relativeBase;
                }
                program.set(inIdx, input);
                Logger.log("STEP i: " + i + " PUT INPUT " + input + " TO idx: " + inIdx, logEnabled);

            } else if (instruction == OUTPUT) {
                step = 2;
                long value = getValue(program.get(i + 1), firstMode);
                Logger.log("STEP i: " + i + " OUTPUT IS: " + value + " FROM idx: " + (program.get(i + 1) + relativeBase), logEnabled);
                currentI = i +step;
                return value;

            } else if (instruction == ADD) { // 1
                step = 4;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                long outIdx = getIndex(program.get(i + 3), thirdMode);
                program.set(outIdx, value1 + value2);
                Logger.log("STEP i: " + i + " ADDING " + value1 + " + " + value2 + " PUT RESULT " + (value1 + value2) + " TO idx: " + outIdx, logEnabled);

            } else if (instruction == MULTIPLY) {
                step = 4;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                long outIdx = getIndex(program.get(i + 3), thirdMode); //                        program.get(i + 3));
                program.set(outIdx, value1 * value2);
                Logger.log("STEP i: " + i + " MULTIPLY " + value1 + " * " + value2 + " PUT RESULT " + (value1*value2) + " TO idx: " + outIdx, logEnabled);

            } else if (instruction == JUMP_ON_TRUE) { // 5
                step = 3;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                if (value1 > 0) {
                    i =  (value2 - step);
                    Logger.log("STEP i: " + i + " JUMPING ON > 0 -> " + value2 + ", value1: " + value1, logEnabled);
                }
                Logger.log("STEP i: " + i + " NOT jumping on > 0 -> " + value2 + ", value1: " + value1, logEnabled);

            } else if (instruction == JUMP_ON_ZERO) { // 6
                step = 3;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                if (value1 == 0) {
                    Logger.log("STEP i: " + i + " JUMPING ON ZERO TO " + value2 + ", value1: " + value1, logEnabled);
                    i =  (value2 - step);
                }

            } else if (instruction == LESS_THAN) { // 7
                step = 4;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                long outIdx = getIndex(program.get(i + 3), thirdMode);
                if (value1 < value2) {
                    program.set(outIdx, 1L);
                    Logger.log("STEP i: " + i + " COMPARED: " + value1 + " < " + value2 + " PUT RESULT 1 TO idx: " + outIdx, logEnabled);
                } else {
                    program.set(outIdx, 0L);
                    Logger.log("STEP i: " + i + " COMPARED: " + value1 + " < " + value2 + " PUT RESULT 0 TO idx: " + outIdx, logEnabled);
                }

            } else if (instruction == EQUAL) { // 8
                step = 4;
                long value1 = getValue(program.get(i + 1), firstMode);
                long value2 = getValue(program.get(i + 2), secondMode);
                long outIdx = getIndex(program.get(i + 3), thirdMode);
                if (value1 == value2) {
                    program.set(outIdx, 1L);
                    Logger.log("STEP i: " + i + " EQUALS: " + value1 + " == " + value2 + " PUT RESULT 1 TO idx: " + outIdx, logEnabled);
                } else {
                    program.set(outIdx, 0L);
                    Logger.log("STEP i: " + i + " EQUALS: " + value1 + " != " + value2 + " PUT RESULT 0 TO idx: " + outIdx, logEnabled);
                }

            } else if (instruction == RELATIVE_BASE_OFFSET) {
                step = 2;
                long previousRelOffset = relativeBase;
                long value = getValue(program.get(i + 1), firstMode);
                relativeBase += value;
                Logger.log("STEP i: " + i + " SETTING RELATIVE BASE OFFSET FROM " + previousRelOffset + " TO " + relativeBase + ", INSTRUCTION: " + program.get(i) + "   VALUE: " + program.get(i + 1) + "   DECODED VALUE: " + value, logEnabled);

            } else {
                throw new IllegalStateException("WRONG INSTRUCTION at i: " + i);
            }

        }
        throw new IllegalStateException("PROGRAM DID NOT EXIT CORRECTLY!");
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
