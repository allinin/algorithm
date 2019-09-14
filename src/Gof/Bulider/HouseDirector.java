package Gof.Bulider;

public class HouseDirector {
    HouseBuilder houseBuilder=null;

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何处理建造房子的流程交给指挥者
    public House constructHouse()
    {
        houseBuilder.buildBaise();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
       return houseBuilder.buildHouse();
    }
}
