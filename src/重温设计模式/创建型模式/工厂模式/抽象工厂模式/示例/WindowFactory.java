package 重温设计模式.创建型模式.工厂模式.抽象工厂模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/19 17:04
 */
public class WindowFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckbox() {

        return new WindowsCheckBox();
    }
}
