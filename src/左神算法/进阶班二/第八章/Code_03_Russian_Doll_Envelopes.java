package 左神算法.进阶班二.第八章;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zbl
 * @version 1.0
 * @content:给KM定P算一法个扩N*展2的题矩目阵二，表示N个信封的长和宽，
例如
6,4
3,9
4,3
第0个信封，长6宽4
第1个信封，长3宽9
第2个信封，长4宽3
长和宽是两个维度而已，不要把信封旋转让其长变宽，宽变长。
如果信封a的长和宽都比信封b大，那么说b可以放在a的里面，
给定这么一个矩阵，求信封最多可以套几层。
比如上个例子，选[4,3][6,4]，[4,3]可以放在[6,4]里，最多套两层，返回2.
 * @date 2020/3/3 9:17
 */
public class Code_03_Russian_Doll_Envelopes{

    public static class Dot{
        public int w;
        public int h;

        public Dot(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    public static class DotComparator implements Comparator<Dot>{

        @Override
        public int compare(Dot o1, Dot o2) {
            if(o1.w==o2.w)
                return o2.h-o1.h;
            else
                return o1.w-o2.w;
        }
    }

    public static int maxEnvelopes(int[][]es){
        if(es==null || es.length==0 || es[0]==null || es[0].length==0)
            return 0;
        Dot[] dots=new Dot[es.length];
        for(int i=0;i<es.length;i++){
            dots[i]=new Dot(es[i][0],es[i][1]);
        }

        Arrays.sort(dots,new DotComparator());
        int[] ens=new int[dots.length];//最小结尾数组
        ens[0]=dots[0].h;
        int right=0;
        int l=0;
        int r=0;
        int m=0;
        for(int i=1;i<dots.length;i++){
            l=0;
            r=right;
            while(l<=r)
            {
                m=(l+r)/2;
                if(dots[i].h>ens[m]){
                    l=m+1;
                }else{   //找到在ens数组中最接近dots[i].h的值的位置。
                    r=m-1;
                }
            }
            right=Math.max(l,right);
            ens[l]=dots[i].h;
        }
        return right+1;

    }

}
