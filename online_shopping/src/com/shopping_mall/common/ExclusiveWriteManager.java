package com.shopping_mall.common;

import java.util.HashMap;
import java.util.Map;

public class ExclusiveWriteManager {
    private final Map<Integer,Integer> lockMap = new HashMap<>();

    private static ExclusiveWriteManager exclusiveWriteManager = null;

    public static ExclusiveWriteManager getInstance() {
        if(exclusiveWriteManager == null)
            exclusiveWriteManager = new ExclusiveWriteManager();
        return exclusiveWriteManager;
    }

    public boolean acquireLock (Integer object, Integer owner) {
        Integer obj = lockMap.get(object);
        Boolean res ;
        if(obj==null){
            lockMap.put(object,owner);
            res = true;
        }else {
            res = false;
        }
        return res;
    }

    public void releaseLock(Integer object) {
        if(hasLock(object)){
            lockMap.put(object,null);

        }else {
            System.out.println("there is no lock");
        }

    }

    public Boolean hasLock(Integer object){
        Integer obj = lockMap.get(object);
        Boolean res ;
        if(obj==null){
            res = false;
        }else {
            res = true;
        }
        return res;
    }

    public Boolean hasLock(Integer object, Integer user_id){
        Integer obj = lockMap.get(object);
        Boolean res ;
        if(obj==user_id){
            res = true;
        }else {
            res = false;
        }
        return res;
    }




}
