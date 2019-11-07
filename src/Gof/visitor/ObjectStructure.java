package Gof.visitor;

import java.util.ArrayList;
import java.util.List;

//数据结构，用来管理很多的人
public class ObjectStructure {

    private List<Person> persons=new ArrayList<>();

    //添加到list
    public void attach(Person p){
        persons.add(p);
    }

    //移除
    public void detach(Person p)
    {
        persons.remove(p);
    }

    //显示评测请框
    public void display(Action action)
    {
        for(Person p:persons)
            p.accept(action);
    }

}
