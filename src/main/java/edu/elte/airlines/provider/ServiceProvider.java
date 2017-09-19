package edu.elte.airlines.provider;


import java.util.concurrent.ConcurrentHashMap;

import edu.elte.airlines.response.CustomResponseFactory;
import edu.elte.airlines.service.AdminService;
import edu.elte.airlines.service.interfaces.CrudService;

public class ServiceProvider {
    private final ConcurrentHashMap<Class<?>, AdminService> services = new ConcurrentHashMap<>();
    private final CustomResponseFactory customResponseFactory;


    public ServiceProvider(CustomResponseFactory customResponseFactory) {
        this.customResponseFactory = customResponseFactory;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> void registerService(Class<T> entityClass, CrudService crudService) {
        services.put(entityClass, new AdminService(crudService, customResponseFactory));
    }
    public AdminService getService(Class<?> entityClass) {
        return services.get(entityClass);
    }
}