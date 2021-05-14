package 重温设计模式.行为模式.模版方法模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content: 具体社交网络，对基础类中的模版方法进行重写。
 * @date 2021/5/11 15:08
 */
public class FaceBook extends NetWork {

    public FaceBook(String userName,String password){
        this.userName = userName;
        this.password = password;
    }




    @Override
    boolean logIn(String userName, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.userName);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Facebook");
        return true;
    }

    private void simulateNetworkLatency() {

        try{
            int i = 0;
            System.out.println();
            while(i < 10){
                System.out.println(",");
                Thread.sleep(100);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Message: '" + new String(data) + "' was posted on Facebook");
            return true;
        } else {
            return false;
        }
    }

    @Override
    void logOut() {
        System.out.println("User: '" + userName + "' was logged out from Facebook");
    }
}
