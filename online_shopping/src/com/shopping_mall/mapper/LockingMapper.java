package com.shopping_mall.mapper;

import com.shopping_mall.common.ExclusiveWriteManager;
import com.shopping_mall.common.Session;
import com.shopping_mall.entity.DomainObject;

public class LockingMapper implements DataMapper {

    private DataMapper mapper;
    private ExclusiveWriteManager lockingManager;
    private int userId;

    public LockingMapper(DataMapper mapper) {
        this.mapper = mapper;
        this.lockingManager = ExclusiveWriteManager.getInstance();
        this.userId = Session.getInstance().getUserid();
    }

    @Override
    public void insert(DomainObject obj) {
        // TODO Auto-generated method stub
        mapper.insert(obj);
    }

    @Override
    public void update(DomainObject obj) {
        // TODO Auto-generated method stub
        if(lockingManager.acquireLock(obj.getId(),userId)){
            if(lockingManager.hasLock(obj.getId(), userId)) {
                mapper.update(obj);
                lockingManager.releaseLock(obj.getId());
            } else {
                System.err.println(userId + "does not have the lock of " + obj.getId() + " to update!");
            }
        }else{
            System.err.println("can not lock object");
        }
    }

    @Override
    public void delete(DomainObject obj) {
        // TODO Auto-generated method stub
            mapper.delete(obj);
    }

}
