package Gof.state;

public interface State {

    public abstract  void deductMoney();//扣除积分
    public abstract boolean raffle();//是否抽中奖品
    public abstract void dispensePrize();//发放奖品
}