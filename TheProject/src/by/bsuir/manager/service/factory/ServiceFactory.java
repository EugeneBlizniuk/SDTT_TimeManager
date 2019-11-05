package by.bsuir.manager.service.factory;

import by.bsuir.manager.service.ClientService;
import by.bsuir.manager.service.impl.ClientServiceImpl;

public final class ServiceFactory {
    private final static ServiceFactory INSTANCE = new ServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public final ClientService getClientService() {
        return clientService;
    }
}
