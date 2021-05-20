package 重温设计模式.创建型模式.工厂模式.工厂方法模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content: 基础建造者。
 * @date 2021/5/18 21:09
 */
public abstract class Dialog {
    public void renderWindow() {
        // ... other code ...

        Button okButton = createButton();
        okButton.render();
    }

    /**
     * 工厂方法
     * @return
     */
    abstract Button createButton();
}
