package Gof.state;

public class NoRaffleState implements State {

    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity)
    {
        this.activity=activity;
    }


    @Override
    public void deductMoney() {
        System.out.println("扣除50积分，可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("当前状态不能抽奖。。");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
