package Gof.bridge;

public class Client {
    public static void main(String[] args) {
        Phone phone=new UpRightPhone(new XiaoMi());
        phone.call();
        phone.open();
        phone.close();

        Phone phone1=new FoldPhone(new Apple());
        phone1.open();
    }
}
