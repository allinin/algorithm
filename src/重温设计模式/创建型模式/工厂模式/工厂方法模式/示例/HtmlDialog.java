package 重温设计模式.创建型模式.工厂模式.工厂方法模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content: 具体创建者
 * @date 2021/5/18 21:10
 */
public class HtmlDialog extends Dialog {
    @Override
    Button createButton() {
        return new HtmlButton();
    }
}
