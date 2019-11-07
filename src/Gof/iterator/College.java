package Gof.iterator;

public interface College  {

    public String getName();

    public Iterator createIterator();

    public void addDepartment(String name,String desc);

}
