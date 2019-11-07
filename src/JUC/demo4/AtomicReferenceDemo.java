package JUC.demo4;

import java.util.concurrent.atomic.AtomicReference;

class User{
    String name;
    int age;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class AtomicReferenceDemo {

    public static void main(String[] args) {
//        User user=new User("lisi");
//        User user1=new User("zhangsan");
//        AtomicReference<User> atomicReference=new AtomicReference<>();
//        atomicReference.set(user);
//        System.out.println(atomicReference.compareAndSet(user,user1)+"\t"+atomicReference.get().toString());
//        System.out.println(atomicReference.compareAndSet(user,user1)+"\t"+atomicReference.get().toString());



    }
}
