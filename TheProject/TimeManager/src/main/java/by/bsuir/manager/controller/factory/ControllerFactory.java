package by.bsuir.manager.controller.factory;

import by.bsuir.manager.controller.Controller;

public class ControllerFactory {
    private static final ControllerFactory INSTANCE = new ControllerFactory();
    private  final Controller controller = new Controller();
    private ControllerFactory() {}

    public final Controller getController() {
        return controller;
    }

    public static final ControllerFactory getInstance() {
        return INSTANCE;
    }
}
