package Gof.flyweight;

import java.util.HashMap;
import java.util.HashSet;

public class WebSiteFactory {
    private HashMap<String,ConcreteWebSite> pool=new HashMap<>();
    public WebSite getWebSite(String type)
    {
        if(!pool.containsKey(type))
            pool.put(type,new ConcreteWebSite(type));
        return pool.get(type);
    }
    public int getWebSiteCount()
    {
        return pool.size();
    }
}
