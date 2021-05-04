package 重温设计模式.结构型设计模式.适配器模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/4/29 19:36
 */
public class RoundHole {

    private double radius;

    public RoundHole(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public boolean fits(RoundPeg peg){
        return this.getRadius() >= peg.getRadius();
    }


}
