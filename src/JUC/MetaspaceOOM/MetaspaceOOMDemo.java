package JUC.MetaspaceOOM;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MetaspaceOOMDemo {

    static class OOMTest{

    }

    public static void main(String[] args) {

        int i=0;
        try{
            while(true){
                Enhancer enhancer=new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper(obj,args);
                    }
                });
                i++;
            }
        }catch (Exception e)
        {
            System.out.println("=-=============="+i);
            e.printStackTrace();
        }
    }
}
