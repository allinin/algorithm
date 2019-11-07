package Gof.state;

import java.util.Random;

public class CanRaffleState implements State {

   RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("已经扣除积分了");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖。。");
        Random random=new Random();
        int num=random.nextInt(10);
        if(num==0)
        {
            activity.setState(activity.getDispenseState());
            return true;
        }else{
            System.out.println("很遗憾没有抽中");
            activity.setState(activity.getNoRaffleState());
            return false;
        }

    }

    @Override
    public void dispensePrize() {
        System.out.println("不发放奖品");
    }
}
