package Gof.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理对象类
public class ProxyFactory {

    //维护一个目标对象
    private Object target;

    public ProxyFactory( Object target) {
        this.target=target;
    }
//    public static Object newProxyInstance(ClassLoader loader,
//                                          Class<?>[] interfaces,
//                                          InvocationHandler h)

    //1. ClassLoader loader ： 指定当前目标对象使用的类加载器, 获取加载器的方法固定
    //2. Class<?>[] interfaces: 目标对象实现的接口类型，使用泛型方法确认类型
    //3. InvocationHandler h : 事情处理，执行目标对象的方法时，会触发事情处理器方法, 会把当前执行的目标对象方法作为参数传入
    public Object getProxyInstance()
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk代理开始。。。");
                Object returnVal = method.invoke(target, args);//args是传入的目标对象的参数，目标对象的方法如果没有返回值，则返回null
                System.out.println("jdk代理结束");
                return returnVal;
            }
        });
    }
}
