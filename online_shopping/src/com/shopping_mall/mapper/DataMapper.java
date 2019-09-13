package com.shopping_mall.mapper;

import com.shopping_mall.entity.DomainObject;

import java.sql.SQLException;

public interface DataMapper {


    public static DataMapper getMapper(Class<? extends DomainObject> objClass) {
        DataMapper dataMapper = null;

        return dataMapper;
    }

    // Insert a new domainObject into database
    public void insert(DomainObject obj) throws SQLException;

    // Update the information of a domainObject in database
    public void update(DomainObject obj) throws SQLException;

    // Delete a DomainObject in database
    public void delete(DomainObject obj) throws SQLException;
}
