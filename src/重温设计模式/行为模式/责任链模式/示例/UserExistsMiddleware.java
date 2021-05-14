package 重温设计模式.行为模式.责任链模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/14 21:41
 */
public class UserExistsMiddleware extends Middleware{

    private Server server;

    public UserExistsMiddleware(Server server){
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if(!server.hasEmail(email)){
            System.out.println("This email is not registered!");
            return false;
        }
        if(!server.isValidPassword(email,password)){
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email,password);
    }
}
