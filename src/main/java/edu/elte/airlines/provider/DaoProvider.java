package edu.elte.airlines.provider;

import java.util.concurrent.ConcurrentHashMap;

import edu.elte.airlines.dao.interfaces.CrudDao;

public class DaoProvider {
    private final ConcurrentHashMap<Class<?>, CrudDao> daos = new ConcurrentHashMap<>();
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> void registerDao(Class<T> entityClass, CrudDao crudDao) {
        daos.put(entityClass, crudDao);
    }
    public CrudDao getDao(Class<?> entityClass) {
        return daos.get(entityClass);
    }
}
