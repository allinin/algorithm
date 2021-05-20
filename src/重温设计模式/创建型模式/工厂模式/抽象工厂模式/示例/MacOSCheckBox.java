package 重温设计模式.创建型模式.工厂模式.抽象工厂模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/19 17:00
 */
public class MacOSCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
