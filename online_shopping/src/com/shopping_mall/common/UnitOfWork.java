package com.shopping_mall.common;

import com.shopping_mall.entity.DomainObject;
import com.shopping_mall.mapper.DataMapper;
import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {
    private static ThreadLocal current = new ThreadLocal();

    private List<DomainObject> newObjects = new ArrayList<DomainObject>();
    private List<DomainObject> dirtyObjects = new ArrayList<DomainObject>();
    private List<DomainObject> deletedObjects = new ArrayList<DomainObject>();

    public static void newCurrent(){
        setCurrent(new UnitOfWork());
    }

    public static void setCurrent(UnitOfWork uow){
        current.set(uow);
    }

    public static UnitOfWork getCurrent() {
        return (UnitOfWork) current.get();
    }

    public void registerNew(DomainObject obj){
        assert obj.getId() != null : "id is null";
        assert !dirtyObjects.contains(obj) :"object is dirty";
        assert !deletedObjects.contains(obj) : "object is deleted";
        assert !newObjects.contains(obj) : "object is new";
        newObjects.add(obj);
    }

    public void registerDirty(DomainObject obj){
        assert obj.getId() != null : "id is null";
        assert !deletedObjects.contains(obj) : "object is deleted";
        if (!dirtyObjects.contains(obj) && !newObjects.contains(obj)){
            dirtyObjects.add(obj);
        }
    }

    public void registerDeleted(DomainObject obj){
        assert obj.getId() != null : "id is null";
        if (newObjects.remove(obj))
            return;
        dirtyObjects.remove(obj);
        if (!deletedObjects.contains(obj)){
            deletedObjects.add(obj);
        }
    }

    public void registerClean(DomainObject obj){
        assert obj.getId() != null : "id is null";
    }

    // Commit the current unit of work
    public void commit() {
        for (DomainObject obj : newObjects){
            DataMapper.getMapper(obj.getClass()).insert(obj);
        }
        for (DomainObject obj : dirtyObjects){
            DataMapper.getMapper(obj.getClass()).update(obj);
        }
        for (DomainObject obj : deletedObjects){
            DataMapper.getMapper(obj.getClass()).delete(obj);
        }

        this.newObjects = new ArrayList<DomainObject>();
        this.dirtyObjects = new ArrayList<DomainObject>();
        this.deletedObjects = new ArrayList<DomainObject>();
    }

}
