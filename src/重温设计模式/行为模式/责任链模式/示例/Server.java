package 重温设计模式.行为模式.责任链模式.示例;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content: 授权目标
 * @date 2021/5/14 21:53
 */
public class Server {

    private HashMap<String,String> user = new HashMap<>();
    private Middleware middleware;

    public void setMiddleware(Middleware middleware){
        this.middleware = middleware;
    }

    public boolean logIn(String email,String password){
        if(middleware.check(email,password)){
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.

            return true;
        }
        return false;
    }

    public void register(String email,String password){
        user.put(email,password);
    }

    public boolean hasEmail(String email){
        return user.containsKey(email);
    }

    public boolean isValidPassword(String email,String password){
        return user.get(email).equals(password);
    }


}
