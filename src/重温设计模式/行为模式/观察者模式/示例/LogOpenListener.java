package 重温设计模式.行为模式.观察者模式.示例;

import java.io.File;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/8 16:41
 */
public class LogOpenListener implements EventListener{
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " +
                eventType + " operation with the following file: " + file.getName());
    }
}
