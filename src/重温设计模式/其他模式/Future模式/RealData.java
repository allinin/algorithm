package 重温设计模式.其他模式.Future模式;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/19 13:11
 */
public class RealData implements Data {

    protected final String result;
    public RealData(String para) {
        StringBuffer sb=new StringBuffer();
        //假设这里很慢很慢，构造RealData不是一个容易的事
        result =sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
