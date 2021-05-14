package 重温设计模式.结构型设计模式.装饰器模式.示例;

/**
 * @author zbl
 * @version 1.0
 * @content: 抽象基础封装
 * @date 2021/5/13 14:02
 */
public class DataSourceDecorator implements DataSource{

    private DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee){
        this.wrappee = wrappee;
    }

    @Override
    public void writeData(String str) {
        wrappee.writeData(str);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
