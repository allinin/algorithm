package 重温设计模式.结构型设计模式.装饰器模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2021/5/13 13:56
 */
public class Demo {

    public static void main(String[] args) {
        String test = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("test.txt")));
        encoded.writeData(test);

        DataSource plain = new FileDataSource("test.txt");

        System.out.println("- Input ----------------");
        System.out.println(test);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());

    }
}
