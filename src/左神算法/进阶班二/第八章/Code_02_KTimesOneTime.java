package 左神算法.进阶班二.第八章;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 数组中有一个数出现了奇数次，剩下的数出现了偶数次，打印
这个出现奇数次的数
数组中有两个数出现了奇数次，剩下的数出现了偶数次，打印
这两个出现奇数次的数
数组中有一个数出现1次，剩下的数出现了k次，打印这个出现1
次的数
 * @date 2020/3/3 9:17
 */
public class Code_02_KTimesOneTime {

    //第一题
    public static int solution1(int[] arr){
        if(arr==null || arr.length==0)
            throw new RuntimeException("数组为空！");
            int res=0;
            for(int i =0;i<arr.length;i++){
                res^=arr[i];
            }
            return res;
    }

    //第二题
    public static int[] solution2(int[] arr){
        if(arr==null || arr.length==0)
            throw new RuntimeException("数组为空！");
        int res=0;
        for(int i=0;i<arr.length;i++){
            res^=arr[i];
        }

        //找出res最右边的1
        res=res&(~res+1);

        int ans1=0;
        int ans2=0;
        for(int i=0;i<arr.length;i++){
            if((arr[i] & res)==0)
                ans1^=arr[i];
            else{
                ans2^=arr[i];
            }
        }
        return new int[]{ans1,ans2};

    }

    //第三题
    public static int onceNum(int[] arr,int k){
       int[] e=new int[32];
       for(int i=0;i<arr.length;i++){
           setExclusiveOr(e,arr[i],k);
       }
       int res=getNumFromKSysNum(e,k);
       return res;
    }

    private static void setExclusiveOr(int[] eo, int v, int k) {
        int[] kSystemFromNum = getKSystemFromNum(v, k);
        for(int i=0;i<kSystemFromNum.length;i++){
            eo[i]=(eo[i]+kSystemFromNum[i])%k;
        }

    }

    public static int[] getKSystemFromNum(int value,int k){
        int[] res=new int[32];
        int index=0;
        while(value!=0){
            res[index++]=value%k;
            value/=k;
        }
        return res;

    }

    //将k进制的数转换成十进制的数
    public static int getNumFromKSysNum(int[] eO, int k) {
        int res = 0;
        for (int i = eO.length - 1; i != -1; i--) {
            res = res * k + eO[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = { 1, 1, 1, 2, 6, 6, 2, 2, 10, 10, 10, 12, 12, 12, 6, 9 };
        System.out.println(onceNum(test1, 3));

        int[] test2 = { -1, -1, -1, -1, -1, 2, 2, 2, 4, 2, 2 };
        System.out.println(onceNum(test2, 5));

    }
}
