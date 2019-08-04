package org.sd.dyanmicProxy;

public class RealStar implements Star {

    /**
     * 面谈
     */
    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }

    /**
     * 签合同
     */
    @Override
    public void signContract() {
        System.out.println("RealStar.signContract()");

    }

    /**
     * 订票
     */
    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");

    }

    /**
     * 唱歌
     */
    @Override
    public void sing() {
        System.out.println("RealStar(周杰伦本人).sing()");

    }

    /**
     * 收钱
     */
    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");

    }
}
