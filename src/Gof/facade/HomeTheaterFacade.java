package Gof.facade;

public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Stereo stereo;
    private Screen screen;

    public HomeTheaterFacade()
    {
        super();
        this.dvdPlayer=DVDPlayer.getInstance();
        this.screen=Screen.getInstance();
        this.stereo=Stereo.getInstance();
    }

    //操作分成四部
    public void ready()
    {
        dvdPlayer.off();
        stereo.on();;
        screen.down();
    }

    public void play()
    {
        dvdPlayer.play();
    }
    public void pause()
    {
        dvdPlayer.pause();
    }

    public void end()
    {
        dvdPlayer.off();;
        screen.up();
        stereo.off();
    }

}
