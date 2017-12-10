package edu.elte.airlines.service.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CrudService<IdType, EntityType> {
    IdType create(EntityType entityType);
    void delete(EntityType entityType);
    void update(EntityType entityType);
    EntityType findById(IdType id);

    boolean exists(IdType id);

    Collection<EntityType> list();
}
