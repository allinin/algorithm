package Gof.Adapter;

public class Voltage220 {

    public int output220v()
    {
        int src=220;
        System.out.println("电压="+src);
        return src;
    }
}
