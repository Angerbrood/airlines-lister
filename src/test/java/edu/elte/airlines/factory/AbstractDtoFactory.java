package edu.elte.airlines.factory;

import edu.elte.airlines.service.interfaces.CrudService;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDtoFactory<EntityType, DtoType, IdType> {
    private final CrudService<EntityType, DtoType, IdType> crudService;

    protected CrudService<EntityType, DtoType, IdType> getService() {
        return crudService;
    }
    public AbstractDtoFactory(CrudService<EntityType, DtoType, IdType> crudService) {
        this.crudService = crudService;
    }

    public abstract DtoType createOne(Object... arguments);

    public List<DtoType> createAndSave(int howMany, Object... arguments) {
        List<DtoType> entitiesCreated = create(howMany, arguments);
        for (DtoType entity : entitiesCreated) {
            crudService.create(entity);
        }
        return entitiesCreated;
    }

    public DtoType createOneAndSave(Object... arguments) {
        DtoType createdEntity = createOne(arguments);
        crudService.create(createdEntity);
        return createdEntity;
    }
    public List<DtoType> create(int howMany, Object... arguments) {
        List<DtoType> entities = new ArrayList<>();
        for (int i = 1; i <= howMany; i++) {
            entities.add(createOne(arguments));
        }
        return entities;
    }

}
