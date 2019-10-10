package Gof.proxy.staticProxy;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach(String name) {
        System.out.println("老师教 "+name+"中,.......");
    }
}
