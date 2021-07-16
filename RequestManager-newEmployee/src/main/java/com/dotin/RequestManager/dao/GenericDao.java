package com.dotin.RequestManager.dao;

import java.io.Serializable;
import java.util.List;

interface GenericDao<entityType, PK extends Serializable> {

    entityType insert(entityType type);

    entityType update(entityType type);

    void delete(PK id);

    List<entityType> selectAll();

    entityType getEntity(PK id);
}
