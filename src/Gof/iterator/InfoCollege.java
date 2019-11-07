package Gof.iterator;

import java.util.ArrayList;
import java.util.List;

public class InfoCollege implements College {

    List<Department> departments;


    public InfoCollege() {
        departments=new ArrayList<>();
        departments.add(new Department("信息安全","信息安全"));
        addDepartment("网络安全专业", " 网络安全专业 ");
        addDepartment("服务器安全专业", " 服务器安全专业 ");
    }

    @Override
    public String getName() {
        return "信息学院";
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departments);
    }

    @Override
    public void addDepartment(String name, String desc) {
         Department department=new Department(name,desc);
         departments.add(department);
    }
}
