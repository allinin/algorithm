package Gof.facade;

public class DVDPlayer {

    private static final DVDPlayer instance=new DVDPlayer();
    private DVDPlayer(){};

    public static DVDPlayer getInstance()
    {
        return instance;
    }

    public void on()
    {
        System.out.println("dvd on");
    }
    public void off()
    {
        System.out.println("dvd off");
    }

    public void pause()
    {
        System.out.println("dvd pause");
    }
    public void play()
    {
        System.out.println("dvd play");
    }
}
