package org.sd.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student>{


        private int id;
        private int age;
        private String name;

        public Student(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
        @Override
        public int compareTo(Student o) {
            //降序
            //return o.age - this.age;
            //升序
            return this.age - o.age;
        }
        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String args[]){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,25,"关羽"));
        list.add(new Student(2,21,"张飞"));
        list.add(new Student(3,18,"刘备"));
        list.add(new Student(4,32,"袁绍"));
        list.add(new Student(5,36,"赵云"));
        list.add(new Student(6,16,"曹操"));
        System.out.println("排序前:");
        for (Student student : list) {
            System.out.println(student.toString());
        }
        //使用默认排序
        Collections.sort(list);


        System.out.println("默认排序后:");
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }



}



