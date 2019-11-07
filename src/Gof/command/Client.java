package Gof.command;

public class Client {

    public static void main(String[] args) {
        LightReceiver lightReceiver=new LightReceiver();
        LightOnCommand lightOnCommand=new LightOnCommand(lightReceiver);
        LightOffCommadn lightOffCommadn=new LightOffCommadn(lightReceiver);
        RemoteController remoteController=new RemoteController(1);
        remoteController.setCommand(0,lightOnCommand,lightOffCommadn);

        System.out.println("----------开灯---------");
        remoteController.onButtonWasPush(0);
        System.out.println("---------关灯----------");
        remoteController.offButtonWasPush(0);
        remoteController.undoButtonWasPush();

    }
}
