package com.common.util.clone;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.List;
import java.util.Objects;

/**
 * @author David Tian
 * @desc
 * @since 2022/5/25 21:22
 */
@Slf4j
public class CloneUtils {

    @SuppressWarnings("unchecked")
    private static <T extends Serializable> T clone(T obj){
        T cloneObj = null;
        try {

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            cloneObj = (T) ois.readObject();
            ois.close();

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return cloneObj;
    }

    //exposed interface
    public static <T,R> void clone_Dest_from_Source(List<T> dest, List<R> source){

        /*for(int i=0; i<source.size(); i++){
            Object obj = source.get(i);
            dest.add(CloneUtils.clone(obj);
        }*/
    }

}
