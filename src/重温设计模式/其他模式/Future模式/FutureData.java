package 重温设计模式.其他模式.Future模式;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/19 13:10
 */
public class FutureData implements Data{

    private RealData realData;
    private boolean isReady;

    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
        return;
    }



    @Override
    public String getResult() {
        while(!isReady){
            try{
                //一直等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }
}
