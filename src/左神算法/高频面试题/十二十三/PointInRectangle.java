package 左神算法.高频面试题.十二十三;

/**
 * @author zbl
 * @version 1.0
 * @content: 判断一个点是否在矩形内部
 * @date 2020/2/4 17:08
 */
public class PointInRectangle {

    //矩形与坐标轴平行的情况
    public static boolean isInside(double x1, double y1, double x4, double y4, double x, double y) {
        if (x1 >= x)
            return false;
        if (x4 <= x)
            return false;
        if (y >= y1)
            return false;
        if (y <= y4)
            return false;
        return true;
    }

    //矩形与坐标轴不平行，先旋转矩形，使他平行
    public static boolean isInside(double x1, double y1, double x2, double y2,
                                    double x3, double y3, double x4, double y4, double x, double y) {
        if(y1==y2){ //说明与坐标轴平行
            return isInside(x1,y1,x4,y4,x,y);
        }
        //旋转
        double l=Math.abs(y3-y4);
        double k=Math.abs(x3-x4);
        double s=Math.sqrt(l*l+k*k);
        double sin=l/s;
        double cos=k/s;
        double x1R=cos*x1+sin*y1;
        double y1R=-x1*sin+y1*cos;
        double x4R = cos * x4 + sin * y4;
        double y4R = -x4 * sin + y4 * cos;
        double xR = cos * x + sin * y;
        double yR = -x * sin + y * cos;
        return isInside(x1R, y1R, x4R, y4R, xR, yR);

        }

    public static void main(String[] args) {
        // (x1,y1),(x2,y2),(x3,y3),(x4,y4) stand for a Rectangle.
        double x1 = 0;
        double y1 = 3;// (x1,y1) should be the most left
        double x2 = 3;
        double y2 = 7;// (x2,y2) should be the most top.
        double x3 = 4;
        double y3 = 0;// (x3,y3) should be the most below.
        double x4 = 7;
        double y4 = 4;// (x4,y4) should be the most right.

        double x = 4;
        double y = 3;
        System.out.print(isInside(x1, y1, x2, y2, x3, y3, x4, y4, x, y));

    }
}
