package org.sd.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() == o2.getAge()) {
            return o1.getId() - o2.getId();
        } else {
            return o1.getAge() - o2.getAge();
        }
    }

    public static void main(String args[]) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, 21, "关羽"));
        list.add(new Student(2, 21, "张飞"));
        list.add(new Student(3, 18, "刘备"));
        list.add(new Student(4, 32, "袁绍"));
        list.add(new Student(5, 36, "赵云"));
        list.add(new Student(6, 16, "曹操"));
        System.out.println("排序前:");
        for (Student student : list) {
            System.out.println(student.toString());
        }

        Collections.sort(list, new StudentComparator());
        System.out.println("排序后：  ");
        for(Student student:list){
            System.out.println(student);
        }
    }
}
