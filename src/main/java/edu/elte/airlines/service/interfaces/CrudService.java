package edu.elte.airlines.service.interfaces;

import java.util.List;

public interface CrudService<IdType, EntityType> {
    IdType create(EntityType entityType);
    void delete(EntityType entityType);
    void update(EntityType entityType);
    EntityType findById(IdType id);

    boolean exists(IdType id);

    List<EntityType> list();
}
