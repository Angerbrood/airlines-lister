package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.service.interfaces.CrudService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.core.convert.ConversionService;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractServiceTest<EntityType, DtoType> {

    protected abstract CrudService<EntityType, DtoType, Integer> getService();

    protected abstract CrudDao<EntityType, Integer> getDao();

    protected abstract ConversionService getConversionService();

    protected abstract Class<EntityType> getEntityClass();

    protected abstract EntityType createEntity(boolean withId);

    protected abstract DtoType createDto();

    @SuppressWarnings("unchecked")
    @Before
    public void before() {
        assertNotNull("Service under test should not be null", getService());
        reset(getDao());
    }
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testCreateNull() throws Exception {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("The DTO to be created must not be null");

        getService().create(null);
        verify(getDao(), times(0)).createEntity(any());
        verify(getDao(), times(0)).updateEntity(any());
    }
    @Test
    public void testUpdateNull() throws Exception {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("The DTO to be updated must not be null");

        getService().update(null);
        verify(getDao(), times(0)).createEntity(any());
        verify(getDao(), times(0)).updateEntity(any());
    }
    @Test
    public void testDeleteNull() throws Exception {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("The DTO to be deleted must not be null");
        getService().delete(null);

        verify(getDao(), times(0)).createEntity(any());
        verify(getDao(), times(0)).updateEntity(any());
    }
}