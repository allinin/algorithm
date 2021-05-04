package 重温设计模式.结构型设计模式.适配器模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/4/29 19:41
 */
public class SquarePegAdapter extends RoundPeg {

    private SquarePeg squarePeg;

    public  SquarePegAdapter(SquarePeg squarePeg){
        this.squarePeg = squarePeg;
    }

    //适配器的转换工作
    @Override
    public double getRadius(){
        double result;
        result = (Math.sqrt(Math.pow(squarePeg.getWidth() / 2,2) * 2));
        return result;
    }

}
