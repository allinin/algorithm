package Gof.bridge;



public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand){
        this.brand=brand;
    }

    public void open()
    {
        brand.open();
    }
    public void call()
    {
        brand.call();;
    }
    public void close()
    {
        brand.close();
    }
}
