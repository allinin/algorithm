package 重温设计模式.行为模式.责任链模式.示例;

import javax.swing.*;

/**
 * @author zbl
 * @version 1.0
 * @content: 基础验证接口
 * @date 2021/5/14 21:41
 */
public abstract class Middleware {
    private Middleware next;

    public Middleware linkedWith(Middleware next){
        this.next = next;
        return next;
    }

    public abstract boolean check(String email,String password);

    public boolean checkNext(String email,String password){
        if(this.next == null){
            return true;
        }
        return next.check(email,password);
    }
}
