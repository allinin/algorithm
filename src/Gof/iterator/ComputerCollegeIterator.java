package Gof.iterator;

public class ComputerCollegeIterator implements Iterator {

    Department[] departments;
    int position=0;//遍历的位置

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(position>=departments.length || departments[position]==null)
            return false;
        else
            return true;
    }

    @Override
    public Object next() {
       Department department=departments[position];
       position++;
       return  department;
    }

    @Override
    public void remove() {

    }
}
