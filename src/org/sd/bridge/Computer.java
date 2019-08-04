package org.sd.bridge;

import javax.sound.midi.SoundbankResource;

public class Computer {
     protected  Brand brand;
    public  Computer(Brand b)
    {this.brand=b;}
    public  void sale()
    {
        brand.sale();
    }
}
class Desktop extends Computer{
    public Desktop(Brand b)
    {
        super(b);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}
class Laptop extends Computer
{
    public  Laptop(Brand b)
    {
        super(b);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}