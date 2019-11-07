package Gof.observer;

public class Baidu implements Observer {

    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
         this.temperature=temperature;
         this.pressure=pressure;
         this.humidity=humidity;
         display();
    }

    public void display()
    {
        System.out.println("====百度=======");
        System.out.println("***百度网站 气温 : " + temperature + "***");
        System.out.println("***百度网站 气压: " + pressure + "***");
        System.out.println("***百度网站 湿度: " + humidity + "***");
    }
}
