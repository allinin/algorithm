package Gof.proxy.dynamicProxy;

import Gof.proxy.dynamicProxy.ITeacherDao;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach(String name) {
        System.out.println("老师教 "+name+"中,.......");
    }
}
