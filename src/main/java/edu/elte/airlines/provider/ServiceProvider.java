package edu.elte.airlines.provider;


import java.util.concurrent.ConcurrentHashMap;

import edu.elte.airlines.response.CustomResponseFactory;
import edu.elte.airlines.service.AdminService;
import edu.elte.airlines.service.interfaces.ICrudService;

public class ServiceProvider {
    private final ConcurrentHashMap<Class<?>, AdminService> services = new ConcurrentHashMap<>();
    private final CustomResponseFactory customResponseFactory;


    public ServiceProvider(CustomResponseFactory customResponseFactory) {
        this.customResponseFactory = customResponseFactory;
    }

    public <T> void registerService(Class<T> entityClass, ICrudService crudService) {
        services.put(entityClass, new AdminService(crudService, customResponseFactory));
    }
    public AdminService getService(Class<?> entityClass) {
        return services.get(entityClass);
    }
}