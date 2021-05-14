package 重温设计模式.结构型设计模式.装饰器模式.示例;

import java.util.Base64;

/**
 * @author zbl
 * @version 1.0
 * @content: 加密装饰
 * @date 2021/5/13 14:05
 */
public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String str){
        super.writeData(encode(str));
    }

    @Override
    public String readData(){
        return decode(super.readData());
    }

    public String encode(String data){
        byte[] bytes = data.getBytes();
        for(int i = 0;i < bytes.length;i++){
            bytes[i] +=(byte)1;
        }
        return Base64.getEncoder().encodeToString(bytes);

    }

    public String decode(String data){
        byte[] bytes = Base64.getDecoder().decode(data);
        for(int i = 0;i < bytes.length;i++){
            bytes[i] -=(byte)1;
        }
        return new String(bytes);
    }



}
