package 重温设计模式.其他模式.Future模式;

import com.sun.mail.util.QDecoderStream;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/19 13:20
 */
public class Client {

    public Data request(String query){
        FutureData futureData = new FutureData();
        new Thread(){
            @Override
            public void run(){
                // RealData的构建很慢，所以在单独的线程中进行
                RealData realData = new RealData(query);
                //setRealData()的时候会notify()等待在这个future上的对象
                futureData.setRealData(realData);
            }

        }.start();
        return futureData;

    }


}
