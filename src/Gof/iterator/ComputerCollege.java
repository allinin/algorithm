package Gof.iterator;

public class ComputerCollege implements College{

    Department[] departments;
    int numOfDepartment=0;//保存当前数组的对象个数

    public ComputerCollege() {
        departments=new Department[5];
        addDepartment("java","java");
        addDepartment("PHP","PHP");
        addDepartment("math","math");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public Iterator createIterator() {
       return  new ComputerCollegeIterator(departments);
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department=new Department(name,desc);
        departments[numOfDepartment]=department;
        numOfDepartment++;
    }
}
