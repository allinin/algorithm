package Gof.momentor;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private List<Momentor> list=new ArrayList<>();

    public void add(Momentor momentor)
    {
        list.add(momentor);
    }

    public Momentor get(int index)
    {
        return list.get(index);
    }
}
