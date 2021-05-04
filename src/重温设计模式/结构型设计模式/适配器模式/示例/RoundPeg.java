package 重温设计模式.结构型设计模式.适配器模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/4/29 19:38
 */
public class RoundPeg {

    private double radius;

    public RoundPeg(){

    }

    public RoundPeg(double radius){

        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
