package Gof.command;

public class LightOffCommadn implements Command {

    private LightReceiver lightReceiver;

    public  LightOffCommadn(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.off();
    }

    @Override
    public void undo() {
        lightReceiver.on();
    }
}
