package edu.elte.airlines.integration;

import edu.elte.airlines.domain.ModelInterface;
import edu.elte.airlines.dto.DtoInterface;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.service.interfaces.CrudService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractIntegrationTest<EntityType extends ModelInterface<IdType>, DtoType extends DtoInterface<IdType>, IdType> {
    protected abstract CrudService<EntityType, DtoType, IdType> getService();
    protected abstract AbstractDtoFactory<EntityType, DtoType, IdType> getFactory();
    protected abstract DtoType getDto();


    @Test
    public void testDtoCreate() {
        DtoType dtoType = getFactory().createOne();
        assertTrue("DTO ID should be null before", dtoType.getId() == null);
        IdType createdId = getService().create(dtoType);
        assertTrue("DTO ID should not be null after creation", createdId != null);
    }
    @Test
    public void testDtoDelete() {
        DtoType dtoType = getDto();
        getService().delete(dtoType);
        assertFalse("DTO should have been deleted", getService().exists(getDto().getId()));
    }
    @Test
    public void testDtoUpdate() {
        DtoType dtoType = getDto();
        getService().update(dtoType);
    }
    @Test
    public void testDtoList() {
        List<DtoType> result = getService().list();
        assertTrue("DTO List should not be null", result != null);
    }
}
