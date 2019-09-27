package Gof.Adapter;

public class Phone {

    public void charging(IVoltage5v iVoltage5v)
    {
        if(iVoltage5v.output5v()==5)
        {
            System.out.println("电压为5v,可以充电");
        }else if(iVoltage5v.output5v()>5){
            System.out.println("电压大于5v,不能充电。。");
        }
    }
}
