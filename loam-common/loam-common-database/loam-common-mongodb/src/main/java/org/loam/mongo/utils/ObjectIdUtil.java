package org.loam.mongo.utils;

import org.bson.types.ObjectId;

public class ObjectIdUtil {

    public static ObjectId format(String id){
        if(ObjectId.isValid(id)){
            return new ObjectId(id);
        }
        throw new RuntimeException("Invalid ObjectId: "+id);
    }
}
