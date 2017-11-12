package edu.elte.airlines.integration;

import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.model.EntityInterface;
import edu.elte.airlines.service.interfaces.CrudService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractIntegrationTest<EntityType extends EntityInterface<IdType>, IdType> {
    protected abstract CrudService<IdType, EntityType> getService();
    protected abstract AbstractFactory<EntityType> getFactory();
    protected abstract EntityType getEntity();


    @Test
    public void testCreate() {
        EntityType dtoType = getFactory().createOne();
        assertTrue("DTO ID should be null before", dtoType.getId() == null);
        IdType createdId = getService().create(dtoType);
        assertTrue("DTO ID should not be null after creation", createdId != null);
    }
    @Test
    public void testDelete() {
        EntityType dtoType = getEntity();
        getService().delete(dtoType);
        assertFalse("DTO should have been deleted", getService().exists(getEntity().getId()));
    }
    @Test
    public void testUpdate() {
        EntityType dtoType = getEntity();
        getService().update(dtoType);
    }
    @Test
    public void testList() {
        List<EntityType> result = getService().list();
        assertTrue("DTO List should not be null", result != null);
    }
}
