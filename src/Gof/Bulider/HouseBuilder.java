package Gof.Bulider;

public abstract class HouseBuilder {

    protected House house=new House();
    public abstract void buildBaise();
    public abstract void buildWalls();
    public abstract void roofed();

    //建造好房子将房子返回
    public House buildHouse()
    {
        return house;
    }
}
