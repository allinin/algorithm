package 重温设计模式.行为模式.责任链模式.示例;

import Gof.flyweight.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zbl
 * @version 1.0
 * @content:本例与许多作者给出的该模式的标准版本有些不同。 绝大多数模式示例都会寻找正确的处理者，
 * 并在处理后退出链。 但在这里我们会执行每个处理者， 直至某个处理者无法处理请求。 请注意， 尽管流程略有不同，
 * 但这仍是责任链模式。
 * @date 2021/5/14 21:33
 */
public class Demo {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;



    public static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        Middleware middleware = new ThrottlingMiddleware(2)
                .linkedWith(new UserExistsMiddleware(server))
                .linkedWith(new RoleCheckMiddleware());

        server.setMiddleware(middleware);

    }

    public static void main(String[] args) throws IOException {
        init();
        boolean success;
        do{
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        }while(!success);
    }

}
