package ZUOSHEN.高频面试题.十一;

/**
 * 把只包含因子2,3,5的数称为丑数。例如；6、8都是丑数，但14不是，因为他包含因子7.习惯上我们把1当作第一个丑数
 * 求从小到大的顺序的第n个丑数。
 */
public class UglyNumber {

    public static int uglyNumber1(int n){
        int count=0;
        int num=0;
        while(count<n){
            ++num;
            if(isUgly(num))
                count++;
        }
        return num;
    }
    public static boolean isUgly(int num){
        while(num%2==0)
            num/=2;
        while(num%3==0)
            num/=3;
        while(num%5==0)
            num/=5;
        return num==1 ? true:false;
    }
   public static int uglyNumber2(int num){
      int[] help=new int[num];
      help[0]=1;
      int i2=0;
      int i3=0;
      int i5=0;
      int index=1;
      while(index<num){
          help[index]=Math.min(2*help[i2],Math.min(3*help[i3],5*help[i5]));
          if(help[index]==2*help[i2])
              i2++;
          if(help[index]==3*help[i3])
              i3++;
          if(help[index]==help[i5]*5)
              i5++;
          index++;
      }
      return help[index-1];
   }

    public static void main(String[] args) {
        int test = 1000;
        System.out.println(uglyNumber1(test));
        System.out.println(uglyNumber2(test));
    }
}
