package org.sd.dyanmicProxy;

public class ProxyStar implements Star {

    StarHandler starHandler;
    public ProxyStar(StarHandler starHandler) {
        this.starHandler = starHandler;
    }

    /**
     * 面谈
     */
    @Override
    public void confer() throws Throwable {
        starHandler.invoke(this,this.getClass().getDeclaredMethod("confer"),null);
    }

    /**
     * 签合同
     */
    @Override
    public void signContract() throws Throwable {
    starHandler.invoke(this,this.getClass().getDeclaredMethod("signContract"),null);
    }

    /**
     * 订票
     */
    @Override
    public void bookTicket() throws Throwable {
        starHandler.invoke(this,this.getClass().getDeclaredMethod("bookTicket"),null);
    }

    /**
     * 唱歌
     */
    @Override
    public void sing() throws Throwable {
    starHandler.invoke(this,this.getClass().getDeclaredMethod("sing"),null);
    }

    /**
     * 收钱
     */
    @Override
    public void collectMoney() throws Throwable {
    starHandler.invoke(this,this.getClass().getDeclaredMethod("collectMoney"),null);
    }




}
