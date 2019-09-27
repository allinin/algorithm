package Gof.Adapter;

import javax.sound.midi.SoundbankResource;

public class VoltageAdapter implements IVoltage5v {

    private Voltage220 voltage220;

    public VoltageAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }


    @Override
    public int output5v() {
       int dst=0;
       if(null!=voltage220)
       {
           int src=voltage220.output220v();
           System.out.println("使用适配器对象进行适配：");
           dst=src/44;
           System.out.println("适配完成，输出电压为： "+dst);
       }
       return dst;
    }
}
