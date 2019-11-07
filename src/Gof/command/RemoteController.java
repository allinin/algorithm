package Gof.command;

public class RemoteController {

    Command[] onCommands;
    Command[] offCommands;

    //执行撤销的命令
    Command undoCommand;

    //n:指定了一共有几个命令按钮
    public RemoteController(int n)
    {
        onCommands=new Command[n];
        offCommands=new Command[n];
        for(int i=0;i<n;i++)
        {
            onCommands[i]=new NoCommand();
            offCommands[i]=new NoCommand();
        }
    }

    //给我们的命令按钮设置我们的命令
    public void setCommand(int no,Command OnCommand, Command OffCommand){
        onCommands[no]=OnCommand;
        offCommands[no]=OffCommand;
    }

    public void onButtonWasPush(int no)
    {
        onCommands[no].execute();
        //记录按下的按钮，用于撤销
        undoCommand=onCommands[no];
    }

    public void offButtonWasPush(int no){
        offCommands[no].execute();
        undoCommand=offCommands[no];
    }

    //执行撤销命名
    public void undoButtonWasPush()
    {
        undoCommand.undo();
    }
}
