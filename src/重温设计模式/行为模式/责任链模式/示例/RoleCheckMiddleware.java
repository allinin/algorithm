package 重温设计模式.行为模式.责任链模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/14 21:42
 */
public class RoleCheckMiddleware extends Middleware {

    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);

    }
}
