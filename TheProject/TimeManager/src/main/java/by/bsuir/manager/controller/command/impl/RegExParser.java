package by.bsuir.manager.controller.command.impl;

public final class RegExParser {
    private RegExParser() {}

    public static String[] parseCommand(String command) {
        if(!command.contains("-")) {
            //log
            throw new IllegalArgumentException("Request: " + command + " does not contain '-' ");
        }
        return command.split("[-]+");
    }
}
