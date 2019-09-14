package Gof.Prototype;

import java.io.Serializable;

public class DeepCopyChild implements Serializable,Cloneable {
    String name;
     int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DeepCopyChild(String name, int age) {
        this.name = name;
        this.age = age;
    }



    @Override
    protected DeepCopyChild clone() throws CloneNotSupportedException {
        return (DeepCopyChild) super.clone();
    }
}
