package Gof.proxy.CglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target) {
        this.target=target;
    }
    //返回一个代理对象
    public Object getProxyInstnce()
    {
        //创建一个工具类
        Enhancer enhancer = new Enhancer();
        //设置父类,即代理目标
        enhancer.setSuperclass(target.getClass());
        //设置单一回调对象，在调用中拦截目标方法的调用
        enhancer.setCallback(this);
        //创建子类对象，即代理对象
        return enhancer.create();
    }

    /**
     *
     * @param o 代理对象
     * @param method 拦截方法
     *
     * @param args 拦截方法的参数
     * @param methodProxy 代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理模式。。。开始");
        Object invoke = method.invoke(target, args);
        System.out.println("cglib代理模式结束。。。。");
        return invoke;
    }
}
