package org.sd.QRcode;
import com.swetake.util.Qrcode;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class QRCodeUtil {

    //加密：文字信息---》二维码。png
    /**
     *   imgpath:src/二维码。png
     *   content:helloworld
     *   imgType:png
     */
    public void encoderQRCode(String content,String imgPath,String imgType,int size) throws Exception
    {
        BufferedImage bufferedImage=qRcodeCommon(content,imgType,size);
        File file =new File(imgPath);
        //生成图片
        ImageIO.write(bufferedImage, imgType, file);
    }

    //产生一个二维码的BufferedImage
    /**
     *
     */

    public BufferedImage qRcodeCommon (String content,String imgType,int size)throws Exception
    {
        BufferedImage bufferedImage=null;
        //QrCode对象：字符串--》boolean[][]
        Qrcode qrcode=new Qrcode();
        //设置二维码的排错率：7%<l<m<q<h<30%:排错率越高，可存储的信息越少：但是对二维码清晰度要求越高
        qrcode.setQrcodeErrorCorrect('M');
        //可存放的信息类型：N:数字，A；数字+字母：B：所有
        qrcode.setQrcodeEncodeMode('B');

        //尺寸：取值范围：1-40
        qrcode.setQrcodeVersion(size);
        byte[] contentType=content.getBytes("utf-8");
        //转换为字节数组
        boolean[][] codeOut=qrcode.calQrcode(contentType);

        int imgSize=67+12*(size-1);
        //bufferedImage:内存中的图片
        bufferedImage=new BufferedImage(imgSize,imgSize,BufferedImage.TYPE_INT_BGR);

        //创建一个画板
        Graphics2D gs=bufferedImage.createGraphics();
        gs.setBackground(Color.WHITE);//将画板的背景色设置为白色
        gs.clearRect(0,0,imgSize,imgSize);//初始化
        gs.setColor(Color.BLACK);//设置画板上图像的颜色（二维码颜色）
        int pixoff=2;

        for(int i=0;i<codeOut.length;i++)
        {
            for(int j=0;j<codeOut.length;j++)
            {
                if(codeOut[i][j])
                    gs.fillRect(j*3+pixoff,i*3+pixoff,3,3);
            }
        }

        //增加logo
        //将硬盘中的图片转化为image对象
        Image logo=ImageIO.read(new File("src/flower.jpg"));
        int height=bufferedImage.getHeight();
        int width=bufferedImage.getWidth();
        gs.drawImage(logo,imgSize/3,imgSize/3,height/3,width/3,null);
        gs.dispose();
        bufferedImage.flush();

        return bufferedImage;
    }
}
