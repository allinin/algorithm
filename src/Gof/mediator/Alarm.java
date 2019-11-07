package Gof.mediator;



public class Alarm extends Colleague {

    private Mediator mediator;
    private String name;

    public Alarm(Mediator mediator, String name) {
        super(mediator,name);
        mediator.register(name,this);
    }

    public void sendAlarm(int stageChange)
    {
        sendMessage(stageChange);
    }

    @Override
    public void sendMessage(int stageChange) {
          this.getMediator().getMessage(this.name,stageChange);
    }
}
