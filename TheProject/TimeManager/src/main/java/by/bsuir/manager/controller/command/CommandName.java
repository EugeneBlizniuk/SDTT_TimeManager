package by.bsuir.manager.controller.command;

public enum CommandName {
    SIGN_UP("Sign_Up"), SIGN_IN("Sign_In");

    private String name;

    CommandName(String name) {
        this.name = name;
    }
}
