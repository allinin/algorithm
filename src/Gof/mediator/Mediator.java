package Gof.mediator;

public abstract class Mediator {

    public abstract void register(String colleagueName,Colleague colleague);
     //接受消息，具体的对象发出
    public abstract void getMessage(String colleagueName,int stateChange);

    public abstract void sendMessage();
}
