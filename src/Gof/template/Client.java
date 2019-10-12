package Gof.template;

public class Client {

    public static void main(String[] args) {
        PureSoyaMike pureSoyaMike = new PureSoyaMike();
        pureSoyaMike.make();

        RedBeanSoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();
    }
}
