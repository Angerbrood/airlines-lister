package edu.elte.airlines.dao.interfaces;

import java.util.List;


public interface CrudDao<EntityType, IdType> {
    void createEntity(EntityType entity);
    void updateEntity(EntityType entity);
    void deleteEntity(EntityType entity);
    EntityType findById(IdType id);

    boolean exists(IdType id);

    List<EntityType> list();
}