package org.sd.StaticProxy;

import org.sd.dyanmicProxy.Star;

public class ProxyStar implements Star {
    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    /**
     * 面谈
     */
    @Override

    public void confer() {
        System.out.println("ProxyStar.confer()");

    }

    /**
     * 签合同
     */
    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract()");

    }

    /**
     * 订票
     */
    @Override
    public void bookTicket() {
        System.out.println("ProxyStar.bookTicket()");

    }

    /**
     * 唱歌
     */
    @Override
    public void sing() throws Throwable {
    this.star.sing();
    }

    /**
     * 收钱
     */
    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.collectMoney()");

    }
}
