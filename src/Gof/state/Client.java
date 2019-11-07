package Gof.state;

public class Client {

    public static void main(String[] args) {
        RaffleActivity activity=new RaffleActivity(2);
        for(int i=0;i<30;i++)
        {
            System.out.println("第"+(i+1)+"次抽奖---");
            activity.debuctMoney();
            activity.raffle();
        }
    }
}
