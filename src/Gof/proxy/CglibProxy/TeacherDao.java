package Gof.proxy.CglibProxy;

public class TeacherDao {

    public String teach(){
        System.out.println("老师上课中，我是cglib代理，不需要实现接口");
        return "hello";
    }
}
