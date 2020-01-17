package ZUOSHEN.高频面试题.八数组子序列问题;

/**
 * @author zbl
 * @version 1.0
 * @content: 求一个数组中的最长递增子序列
 * @date 2020/1/15 15:01
 */
public class LongestIncrSubqueue {

    //O(n^2)
    public static int getLongestIncrSubqueue1(int[] arr){
          if(arr==null || arr.length==0)
              return 0;
          int[]help=new int[arr.length];//help记录的是以每个元素结尾的最长递增子序列的长度
          help[0]=1;
          int temp=1;
          for(int i=1;i<arr.length;i++){

              if(arr[i]==arr[i-1])
              {
                  help[i]=help[i-1];
              }else{
                  temp=1;
                  for(int j=i-1;j>-1;j--){
                      if(arr[i]>arr[j])
                      {
                          temp=Math.max(temp,help[j]);
                          help[i]=temp+1;
                      }else if(arr[i]==arr[j]){
                          if(help[i]<help[j])
                          help[i]=help[j];
                      }
                  }

              }
          }
          int res=Integer.MIN_VALUE;
          for(int i=0;i<help.length;i++){
              res=Math.max(res,help[i]);
          }
          return res;
    }

    //O(n)
    public static int getLongestIncrSub(int[] arr){
            if(arr==null || arr.length==0)
                return 0;
            int[] lens=new int[arr.length];//记录以每个元素结尾的最长递增子序列的长度
            lens[0]=1;
            int[] ends=new int[arr.length];//最小结尾子数组
            ends[0]=arr[0];
            int l=0;
            int r=0;
            int m=0;
            int right=0;//right表示ends的有效长度，即非零元素的长度，最终后的right再加上1就是最大递增子序列的长度
            for(int i=1;i<arr.length;i++){
                l=0;
                r=right;
                //找到第一个大于等于arr[i]的值的下标，即循环退出时l的值
                while(l<=r){
                    m=(l+r)/2;
                    if(arr[i]>ends[m])
                    {
                        l=m+1;
                    }else{
                        r=m-1;
                    }
                }
                right=Math.max(right,l);
                ends[l]=arr[i];//while循环一定是l>r退出的，根据l=m+1,r=m-1,得出，arr[i]的恰当位置就是ends[l]的位置
                lens[i]=l+1;//如果仅仅是为了求最大递增子序列的长度，lens可以不需要，lens数组是辅助求出最大递增子序列有哪些元素。
            }

            return right+1;
    }


    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

    public static void main(String[] args) {
      for(int i=0;i<100000;i++){
            int [] arr=  generateRandomArray(10);
            if(getLongestIncrSubqueue1(arr)!=getLongestIncrSub(arr))
            System.out.println("fuck"+i);

        }


    }
}
