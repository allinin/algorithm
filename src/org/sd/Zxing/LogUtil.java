package org.sd.Zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class LogUtil {

    public static BufferedImage logoMatrix(BufferedImage bufferedImage,String logo) throws IOException {
        //在二维码上产生一个画板
        Graphics2D g2 = bufferedImage.createGraphics();
        //画logo：string--》bufferedImage
        BufferedImage logoImage=ImageIO.read(new File(logo));
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        //
        g2.drawImage(logoImage,width/5*2,height/5*2,width/5,height/5,null);
        //产生一个画白色圆角正方形的画笔
        BasicStroke stroke=new BasicStroke(5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        //将画板与画笔绑定
        g2.setStroke(stroke);
        //创建一个正方形
        RoundRectangle2D.Float round=new RoundRectangle2D.Float(width/5*2,height*2/5,width/5,height/5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        g2.setColor(Color.WHITE);
        g2.draw(round);

        //灰色边框
        BasicStroke stroke2=new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        g2.setStroke(stroke2);
        RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(width*2/5+2,height* 2/5+2,    width*1/5-4,height* 1/5 -4, BasicStroke.CAP_ROUND ,BasicStroke.JOIN_ROUND);
//		Color color = new Color(128,128,128) ;
        g2.setColor(Color.GRAY);
        g2.draw(round2);

        g2.dispose();
        bufferedImage.flush();
        return bufferedImage;

    }

}
