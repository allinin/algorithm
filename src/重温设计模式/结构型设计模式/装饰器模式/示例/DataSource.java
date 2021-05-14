package 重温设计模式.结构型设计模式.装饰器模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content: 定义了读和写的通用数据接口
 * @date 2021/5/13 13:57
 */
public interface DataSource {

    void writeData(String str);
    String readData();
}
