package 重温设计模式.行为模式.模版方法模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content: 基础社交网络类，定义了模版方法以及其中的步骤方法
 * @date 2021/5/11 15:04
 */
public abstract class NetWork {

    String userName;
    String password;

    /**
     * 模版方法
     * @param message
     * @return
     */
    public boolean post(String message){
        if(logIn(this.userName,this.password)){
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    /**
     * 以下三个是步骤方法，具体子类中可以对这些步骤方法进行重写
     * @param userName
     * @param password
     * @return
     */
    abstract boolean logIn(String userName,String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
}
