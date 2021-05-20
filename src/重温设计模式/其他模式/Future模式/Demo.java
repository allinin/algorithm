package 重温设计模式.其他模式.Future模式;

import sun.util.cldr.CLDRLocaleDataMetaInfo;
import 重温设计模式.行为模式.责任链模式.示例.ThrottlingMiddleware;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/19 13:10
 */
public class Demo {

    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
        try{
            //这里可以用一个sleep代替了对其他业务逻辑的处理
            //在处理这些业务逻辑的过程中，RealData被创建，从而充分利用了等待时间
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //使用真实的数据，如果到这里数据还没有准备好，getResult()会等待数据准备完，再返回
        System.out.println("数据 = " + data.getResult());
    }
}
