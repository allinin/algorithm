package 重温设计模式.创建型模式.工厂模式.工厂方法模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/18 21:08
 */
public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
