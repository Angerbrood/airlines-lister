package edu.elte.airlines.dao.interfaces;

import java.util.List;

public interface CrudDao<IdType, EntityType> {
    void persist(EntityType entity);
    void update(EntityType entity);
    void delete(EntityType entity);
    EntityType findById(IdType id);
    boolean exists(IdType id);
    List<EntityType> list();
}
