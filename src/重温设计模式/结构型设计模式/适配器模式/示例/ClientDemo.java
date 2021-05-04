package 重温设计模式.结构型设计模式.适配器模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/4/29 19:46
 */
public class ClientDemo {

    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if(roundHole.fits(roundPeg)){
            System.out.println("fitsssssssssssssss");
        }

        SquarePeg squareSmall = new SquarePeg(2);
        SquarePeg squareLarge = new SquarePeg(20);

        //客户端代码想要调用RoundHole的fits接口在看一下SquarePeg是否适合该hole,由于接口不适配，所以这里使用了SquarePeg的适配器
        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(squareSmall);
        SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(squareLarge);

        if(roundHole.fits(smallSquarePegAdapter)){
            System.out.println("fitssssssssssssssssss");
        }else {
            System.out.println("unfitsssssssssssssssss");
        }

        if(roundHole.fits(largeSquarePegAdapter)){
            System.out.println("fitssssssssssssssssss");
        }else {
            System.out.println("unfitsssssssssssssssss");
        }



    }



}
