package org.sd.Zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jp.sourceforge.qrcode.util.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ZxingUtil {
    //加密：文字--》二维码
    public static void encodingImg(String content,String format,String imgPath,int width,int height,String logo) throws WriterException, IOException {
        Hashtable<EncodeHintType,Object> hints=new Hashtable<>();
        //设置排错率：L<M<Q<H
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //编码
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        //外边距
        hints.put(EncodeHintType.MARGIN, 1);

        BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
        //内存中的图片，此时需要的图片是是二维码---》需要一个boolean[][]-->BitMatrix
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for(int x=0;x<width;x++)
        {
            for(int y=0;y<height;y++)
            {
                bufferedImage.setRGB(x,y,(bitMatrix.get(x,y)? Color.BLACK:Color.WHITE) );
            }
        }
        //画logo
        bufferedImage=LogUtil.logoMatrix(bufferedImage,logo);
        File file=new File(imgPath);
        ImageIO.write(bufferedImage,format,file);
    }
    public static void decodeImage(File file) throws IOException, NotFoundException {
        if(!file.exists()) return;
        BufferedImage bufferedImage=ImageIO.read(file);
        MultiFormatReader multiFormatReader=new MultiFormatReader();
        LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedImage);
        Binarizer binarizer=new HybridBinarizer(luminanceSource);
        Map map=new HashMap();
        map.put(EncodeHintType.CHARACTER_SET,"utf-8");
        BinaryBitmap binaryBitmap=new BinaryBitmap(binarizer);
        Result result=multiFormatReader.decode(binaryBitmap,map);
        System.out.println(result.toString());
    }
}
