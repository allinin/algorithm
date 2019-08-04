package org.sd;

import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javassist.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) throws Exception {

     //test01();
     //test02();

        Parent a=new Parent();
        Parent[][] b=new Parent[2][1];
        System.out.println(b.getClass());


    }
    public static void test01() throws NotFoundException, IOException, CannotCompileException {
        ClassPool pool= ClassPool.getDefault();
        CtClass cc=pool.get("org.sd.Emp");
        byte[] bytes=cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(cc.getName());
        System.out.println(cc.getSimpleName());
        System.out.println(cc.getSuperclass());
        System.out.println(cc.getInterfaces());
    }

    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("org.sd.Emp");
        CtMethod m=new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{System.out.println(\"ss\");returun $1+$2}");
        cc.addMethod(m);

        //通过反射调用新生成的方法
        Class clazz=cc.toClass();
        Object obj=clazz.newInstance();
        Method method=clazz.getDeclaredMethod("add",int.class,int.class);
        Object result=method.invoke(obj,200,200);
        System.out.println(result);


    }
}
class Parent{
    static{
        System.out.println("helleo");
    }
        }
