package org.sd.Zxing;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, WriterException, NotFoundException {
        String content="http://www.baidu.com";
        String imgPath="src/百度.png";
        String logo="src/flower.jpg";
        //加密：文字---》二维码
       // ZxingUtil.encodingImg(content,"gif",imgPath,430,430,logo);
        //解密：二维码--》文字
        ZxingUtil.decodeImage(new File("src/百度.png"));
    }
}
