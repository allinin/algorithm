package JUC.Demo5;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        ////Vector<String> vector=new Vector<>();
       //List<String> vector = Collections.synchronizedList(new ArrayList<String>());
        CopyOnWriteArrayList<String>vector=new CopyOnWriteArrayList<>();
        for(int i=0;i<30;i++)
        {
            new Thread(()->{vector.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(vector);},"AA").start();
        }



    }
}
