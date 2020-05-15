package Gof.proxy.dynamicProxy;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach(String name) {
        System.out.println("老师教 "+name+"中,.......");
    }

    @Override
    public void lesson(String name) {
        System.out.println("老师正在上课: "+name);
    }
}
