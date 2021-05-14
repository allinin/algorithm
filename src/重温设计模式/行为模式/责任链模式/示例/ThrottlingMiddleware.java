package 重温设计模式.行为模式.责任链模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/14 21:41
 */
public class ThrottlingMiddleware extends Middleware {

    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute){
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }


    @Override
    public boolean check(String email, String password) {
        if(System.currentTimeMillis() > currentTime + 60000){
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        request++;
        if(request > requestPerMinute){
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(email,password);
    }
}
