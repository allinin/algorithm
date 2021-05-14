package 重温设计模式.行为模式.观察者模式.示例;

import java.io.File;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/8 16:38
 */
public class EmailNotificationListener implements EventListener{

    private String email;

    public EmailNotificationListener(String email){
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email +" : Someone has performed "+
                eventType + " operation with the following file: " + file.getName());

    }
}
