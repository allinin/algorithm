package Gof.facade;

public class Screen {
    private static final Screen instance=new Screen();
    private Screen(){};
    public static Screen getInstance()
    {
        return instance;
    }

    public void up()
    {
        System.out.println("screen up");
    }

    public void down()
    {
        System.out.println("screen down");
    }



}
