package 重温设计模式.结构型设计模式.装饰器模式.示例;

import java.io.*;

/**
 * @author zbl
 * @version 1.0
 * @content: 简单数据读写器
 * @date 2021/5/13 13:58
 */
public class FileDataSource implements DataSource{

    private String name;

    public FileDataSource(String name){
        this.name = name;
    }

    @Override
    public void writeData(String str) {
        File file = new File(name);
        try(OutputStream fos = new FileOutputStream(file)){
            fos.write(str.getBytes(),0,str.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try(FileReader reader = new FileReader(file)) {
            buffer = new char[(int)file.length()];
            reader.read(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buffer);
    }
}
