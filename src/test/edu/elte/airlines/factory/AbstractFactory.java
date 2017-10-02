package edu.elte.airlines.factory;


import edu.elte.airlines.dao.interfaces.CrudDao;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFactory<EntityType> {
    private CrudDao<EntityType, ?> dao;

    public AbstractFactory(CrudDao<EntityType, ?> dao) {
        this.dao = dao;
    }

    public List<EntityType> create(int howMany, Object... arguments) {
        List<EntityType> entities = new ArrayList<>();
        for (int i = 1; i <= howMany; i++) {
            entities.add(createOne(arguments));
        }
        return entities;
    }

    public List<EntityType> createAndSave(int howMany, Object... arguments) {
        List<EntityType> entitiesCreated = create(howMany, arguments);
        for (EntityType entity : entitiesCreated) {
            dao.createEntity(entity);
        }
        return entitiesCreated;
    }

    public EntityType createOneAndSave(Object... arguments) {
        EntityType createdEntity = createOne(arguments);
        dao.createEntity(createdEntity);
        return createdEntity;
    }

    public abstract EntityType createOne(Object... arguments);

    public CrudDao<EntityType, ?> getDao() {
        return dao;
    }
}
