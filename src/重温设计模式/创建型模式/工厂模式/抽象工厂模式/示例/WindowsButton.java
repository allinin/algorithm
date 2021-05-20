package 重温设计模式.创建型模式.工厂模式.抽象工厂模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/19 16:59
 */
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
