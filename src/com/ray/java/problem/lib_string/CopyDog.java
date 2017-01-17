package com.ray.java.problem.lib_string;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by 80107442 on 2017-01-13.
 */
public class CopyDog {
    public static void main(String[] args){
        Dog newDog = (Dog) deepCopy(Dog.INSTANCE);
        System.out.println(newDog == Dog.INSTANCE);
        System.out.println(newDog);
    }
    // This method is very slow and generally a bad idea!
    static public Object deepCopy(Object obj){
        try{
            ByteArrayOutputStream bos =
                    new ByteArrayOutputStream();
            new ObjectOutputStream(bos).writeObject(obj);
            ByteArrayInputStream bin =
                    new ByteArrayInputStream(bos.toByteArray());
            return new ObjectInputStream(bin).readObject();
        } catch(Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
