package org.sd.QRcode;

public class Test {
    public static void main(String[] args)throws Exception {
       //生成二维码的路径
        //内容
        String path="src/二维码.png";
        String content="http://www.baidu.com";
        QRCodeUtil qrCodeUtil=new QRCodeUtil();
        qrCodeUtil.encoderQRCode(content,path,"png",7);

    }
}
