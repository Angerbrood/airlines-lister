package edu.elte.airlines.service.interfaces;

import java.util.List;

public interface ICrudService<EntityType, DtoType, IdType> {
    IdType create(DtoType dto);
    void delete(DtoType dto);
    void update(DtoType dto);
    DtoType findById(IdType id);

    boolean exists(IdType id);

    List<DtoType> list();
}