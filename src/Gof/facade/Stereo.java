package Gof.facade;

import com.sun.org.apache.xml.internal.security.keys.storage.implementations.CertsInFilesystemDirectoryResolver;

public class Stereo {
     private static final Stereo instance=new Stereo();
     private Stereo(){};
     public static Stereo getInstance()
     {return instance;
     }
    public void on()
    {
        System.out.println("stereo on");
    }
    public void off() {
        System.out.println("stereo off");
    }
    public void up()
    {
        System.out.println("stereo up");
    }
}
