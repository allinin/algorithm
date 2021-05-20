package 重温设计模式.创建型模式.工厂模式.抽象工厂模式.示例;

import java.awt.*;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/19 17:02
 */
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new MacOSCheckBox();
    }
}
