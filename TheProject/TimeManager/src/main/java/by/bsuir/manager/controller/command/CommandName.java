package by.bsuir.manager.controller.command;

public enum CommandName {
    SIGN_UP("Sign_Up"), SIGN_IN("Sign_In");

    private String name;

    private CommandName() {}

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
