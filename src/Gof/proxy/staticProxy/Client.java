package Gof.proxy.staticProxy;

public class Client {

    public static void main(String[] args) {
        TeacherDao teacherDao=new TeacherDao();
        TeacherDaoProxy teacherDaoProxy=new TeacherDaoProxy(teacherDao);
        teacherDaoProxy.teach("小明");
    }


}
