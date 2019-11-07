package Gof.iterator;

import java.util.List;
import java.util.Iterator;
public class OutPutImpl {

    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    //遍历整个学校
    public void printCollege()
    {
        Iterator<College> iterator = collegeList.iterator();

        while(iterator.hasNext())
        {
            College college=iterator.next();
            System.out.println("======"+college.getName()+"========");
            printDepartment(college.createIterator());
        }
    }

    public void printDepartment(Gof.iterator.Iterator iterator){

        while(iterator.hasNext())
        {
            Department next = (Department)iterator.next();
            System.out.println(next.getName());
        }
    }

}
