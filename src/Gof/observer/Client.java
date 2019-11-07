package Gof.observer;

public class Client {


    public static void main(String[] args) {
        Observer observer=new Baidu();

        WetherData wetherData=new WetherData();
        wetherData.registObserver(observer);

       wetherData.setData(3f,5f,3f);
    }
}
