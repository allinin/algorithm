package 重温设计模式.结构型设计模式.适配器模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/4/29 19:40
 */
public class SquarePeg {

    private double width;

    public SquarePeg(double width){
        this.width = width;
    }

    public double getWidth(){
        return width;
    }

    public double getSquare(){
        double result;
        result = Math.pow(width,2);
        return result;
    }

}
