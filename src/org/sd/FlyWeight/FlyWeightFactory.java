package org.sd.FlyWeight;

import java.util.HashMap;
import java.util.Map;

//享元池
public class FlyWeightFactory {
    private static Map<String,ConcreteChess> map=new HashMap<>() ;

    public static  ConcreteChess getChess(String color)
    {
        if(map.get(color)!=null) {
            return map.get(color);
        }else{
            ConcreteChess concreteChess=new ConcreteChess(color);
            map.put(color,concreteChess);
            return concreteChess;
        }

    }
}
