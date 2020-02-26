package 左神算法.进阶班二.第五章;

import java.util.HashSet;

/**
 * @author zbl
 * @version 1.0
 * @content:假设所有的图形都在第一象限内，
rectangles = [
[1,1,3,3],
[3,1,4,2],
[3,2,4,4],
[1,3,2,4],
[2,3,3,4]
]
其中，
[1,1,3,3]表示第1个矩形左上角的坐标为(1,1)，右下角的坐标为(3,3)
[3,1,4,2]表示第2个矩形左上角的坐标为(3,1)，右下角的坐标为(4,2)
...
按照这种方法可以给你几组矩形，请判断他们能不能正好组成一个完整的大矩形，且没
有重合的部分。
完整描述：搜perfect rectangle  https://leetcode-cn.com/problems/perfect-rectangle/
 * @date 2020/2/24 16:05
 */
public class Code_06_Perfect_Rectangle {

  public static boolean isRectangleCover(int[][] rectangles){
      if(rectangles.length==0 || rectangles[0].length==0)
          return false;
      //用来记记录最后的矩形中x,y的最小值以及最大值
      int x1=Integer.MAX_VALUE;
      int x2=Integer.MIN_VALUE;
      int y1=Integer.MAX_VALUE;
      int y2=Integer.MIN_VALUE;
      int area=0;
      HashSet<String>set=new HashSet<>();
      for(int[] rec:rectangles){
          x1=Math.min(x1,rec[0]);
          x2=Math.max(x2,rec[2]);
          y1=Math.min(y1,rec[1]);
          y2=Math.max(y2,rec[3]);
          area+=(rec[2]-rec[0])*(rec[3]-rec[1]);
          String s1=rec[0]+"_"+rec[1];
          String s2=rec[0]+"_"+rec[3];
          String s3=rec[2]+"_"+rec[1];
          String s4=rec[2]+"_"+rec[3];
          if(!set.add(s1)) set.remove(s1);
          if(!set.add(s2)) set.remove(s2);
          if(!set.add(s3)) set.remove(s3);
          if(!set.add(s4)) set.remove(s4);


      }

      if(!set.contains(x1+"_"+y1)|| !set.contains(x1+"_"+y2) || !set.contains(x2+"_"+y1)
              || !set.contains(x2+"_"+y2) || set.size()!=4)
          return false;
      return area==(x2-x1)*(y2-y1);
  }
}
