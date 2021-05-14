package 重温设计模式.行为模式.观察者模式.示例;

import java.io.File;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/8 16:29
 */
public interface EventListener {

    void update(String eventType,File file);
}
