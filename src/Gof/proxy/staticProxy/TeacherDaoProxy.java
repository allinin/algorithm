package Gof.proxy.staticProxy;

public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target;

    public TeacherDaoProxy(TeacherDao teacherDao) {
        this.target = teacherDao;
    }

    @Override
    public void teach(String name) {
        System.out.println("开始上课。。。。");
        target.teach(name);
        System.out.println("下课了。。。。");
    }
}
