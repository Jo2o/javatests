package cleancode.args;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class ArgsClean {
//    private Map<Character, ArgumentMarshaler> marshalers;
//    private Set<Character> argsFound;
//    private ListIterator<String> currentArgument;
//
//    public Args(String schema, String[] args) throws ArgsException {
//        marshalers = new HashMap<Character, ArgumentMarshaler>();
//        argsFound = new HashSet<Character>();
//        parseSchema(schema);
//        parseArgumentStrings(Arrays.asList(args));
//    }
//
//    private void parseSchema(String schema) throws ArgsException {
//        for(String element : schema.split(",")) {
//            if (element.length() > 0) {
//                parseSchemaElement(element.trim());
//            }
//        }
//    }
//
//    private void parseSchemaElement(String element) throws ArgsException {
//        char elementId = element.charAt(0);
//        String elementTail = element.substring(1);
//        validateSchemaElementId(elementId);
//        if (elementTail.isEmpty()) {
//            marshalers.put(elementId, newBooleanArgumentMarshaler());
//        } else if (elementTail.equals("*")) {
//            marshalers.put(elementId, newStringArgumentMarshaler());
//        } else if (elementTail.equals("ff")) {
//            marshalers.put(elementId, newIntegerArgumentMarshaler());
//        } else if (elementTail.equals("ffff")) {
//            marshalers.put(elementId, newDoubleArgumentMarshaler());
//        } else if (elementTail.equals("[*]")) {
//            marshalers.put(elementId, newStringArrayArgumentMarshaler());
//        } else {
//            throw new ArgsException(lNVALID_ARGUMENT_FORMAT, elementId, elementTail);
//        }
//    }
//
//    private void validateSchemaElementId(char elementId) throws ArgsException {
//        if (!Character.isLetter(elementId)) {
//            throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
//        }
//    }
//
//    private void parseArgumentStrings(List<String> argsList) throws ArgsException {
//        for(currentArgument = argsList.listlterator(); currentArgument.hasNext();) {
//            String argString = currentArgument.next();
//            if(argString.startsWith("-")){
//                parseArgumentCharacters(argString.substring(1));
//            } else {
//                currentArgument.previous();
//                break;
//            }
//        }
//    }
//
//
//    private void parseArgumentCharacters(String argChars) throws ArgsException {
//        for (int i = 0; i < argChars.length(); i++) {
//            parseArgumentCharacter(argChars.charAt(i));
//        }
//    }
//
//    private void parseArgumentCharacter(char argChar) throws ArgsException {
//        ArgumentMarshaler m = marshalers.get(argChar);
//        if (m == null) {
//            throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
//        } else {
//            argsFound.add(argChar);
//            try {
//                m.set(currentArgument);
//            } catch (ArgsException e) {
//                e.setErrorArgumentId(argChar);
//                throw e;
//            }
//        }
//    }
//
//    public boolean has(char arg) {
//        return argsFound.contains(arg);
//    }
//
//    public int nextArgument() {
//        return currentArgument.nextlndex();
//    }
//
//    public boolean getBoolean(char arg) {
//        return Boolean ArgumentMarshaler.getValue(marshalers.get(arg));
//    }
//
//    public String getString(char arg){
//        return String ArgumentMarshaler.getValue(marshalers.get(arg));
//    }
//
//    public int getInt(char arg){
//        return Integer ArgumentMarshaler.getValue(marshalers.get(arg));
//    }
//
//    public double getDouble(char arg){
//        return Double ArgumentMarshaler.getValue(marshalers.get(arg));
//    }
//
//    public String[] getStringArray(char arg){
//        return StringArrayArgumentMarshaler.getValue(marshalers.get(arg));
//    }

}
