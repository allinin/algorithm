package 重温设计模式.行为模式.观察者模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/8 16:42
 */
public class Demo {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.managers.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.managers.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
