package Gof.proxy.CglibProxy;

public class Client {

    public static void main(String[] args) {
        TeacherDao teacherDao=new TeacherDao();
        ProxyFactory proxyFactory=new ProxyFactory(teacherDao);
        TeacherDao proxyInstnce = (TeacherDao)proxyFactory.getProxyInstnce();
        String teach = proxyInstnce.teach();
        System.out.println(teach);
    }
}
