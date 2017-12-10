package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.impl.AbstractDao;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.model.EntityInterface;
import edu.elte.airlines.service.interfaces.CrudService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

@Transactional
public class CrudServiceImpl<IdType extends Serializable, EntityType extends EntityInterface<IdType>> implements CrudService<IdType, EntityType> {

    private final CrudDao<IdType, EntityType> dao;

    public CrudServiceImpl(CrudDao<IdType, EntityType> dao) {
        this.dao = dao;
    }

    @Override
    public IdType create(EntityType entity) {
        Objects.requireNonNull(entity, "The entity to be created must not be null");
        dao.persist(entity);
        return entity.getId();
    }

    @Override
    public void delete(EntityType entity) {
        Objects.requireNonNull(entity, "The entity to be deleted must not be null");
        dao.delete(entity);
    }

    @Override
    public void update(EntityType entity) {
        Objects.requireNonNull(entity, "The entity to be updated must not be null");
        dao.update(entity);
    }

    @Override
    public EntityType findById(IdType id) {
        Objects.requireNonNull(id, "The id to be found must not be null");
        return dao.findById(id);
    }

    @Override
    public boolean exists(IdType id) {
        Objects.requireNonNull(id, "The id to be found must not be null");
        return dao.exists(id);
    }

    @Override
    public Collection<EntityType> list() {
        return dao.list();
    }
}
