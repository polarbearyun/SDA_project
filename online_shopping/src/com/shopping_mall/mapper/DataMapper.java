package com.shopping_mall.mapper;

import com.shopping_mall.entity.DomainObject;

public abstract class DataMapper {

    private DataMapper datamapper;

    public static DataMapper getMapper(Class<? extends DomainObject> objClass) {
        DataMapper dataMapper = null;

        return dataMapper;
    }

    /**
     * an abstract function to perform insert action to database
     * @param object
     * @return
     */
    public abstract boolean insert(DomainObject object);

    /**
     * an abstract function to perform delete action by domainObject's id to database.
     * @param object
     * @return
     * @throws Exception
     */
    public abstract boolean delete(DomainObject object) throws Exception;

    /**
     * an abstract function to perform update action by domainObject's id to database.
     * @param object
     * @return
     * @throws Exception
     */
    public abstract boolean update(DomainObject object) throws Exception;
}
