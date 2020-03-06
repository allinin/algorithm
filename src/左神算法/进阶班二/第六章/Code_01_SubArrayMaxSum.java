package 左神算法.进阶班二.第六章;

/**
 * @author zbl
 * @version 1.0
 * @content:子数组的最大累加和问题
【题目】
给定一个数组arr，返回子数组的最大累加和。
例如，arr=[1,-2,3,5,-2,6,-1]，所有的子数组中，[3,5,-2,6]
可以累加出最大的和12，所以返回12。
【要求】
如果arr长度为N，要求时间复杂度为O(N)，额外空间复杂度为
O(1)。
【补充题目】
给定一个数组arr，返回两个不相容子数组的最大累加和。
 * @date 2020/2/28 15:54
 */
public class Code_01_SubArrayMaxSum {


    public static int getMax(int[] arr){
        if(arr==null || arr.length==0)
            return 0;
        int cur=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            cur+=arr[i];
            max=Math.max(cur,max);
            if(cur<0)
                cur=0;
        }
        return max;
    }

    //进阶：其实是原来题目的改进，求0~i的子数组的最大累加和以及i~N-1位置的子数组的
    //最大累加和，然后找出对应的二者相加

    public static int getMax2(int[] arr){
        if(arr==null || arr.length==0)
            return 0;

        int[] leftMax = getLeftMax(arr);
        int[] rightMax = getRightMax(arr);
        int res=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            res=Math.max(res,leftMax[i]+rightMax[i+1]);
        }
        return res;

    }

    //求数组中0~i位置的最大子数组的累加和
    private static int[] getLeftMax(int[] arr){
        int[] res=new int[arr.length];
        res[arr.length-1]=0;
        for(int i=0;i<arr.length-1;i++){
            int cur=0;
            int max=Integer.MIN_VALUE;
            for(int j=0;j<=i;j++){
                cur+=arr[j];
                max=Math.max(cur,max);
                if(cur<0)
                    cur=0;
            }
            res[i]=max;

        }
        return res;
    }
    //求数组中i~arr.length-1位置的最大子数组的累加和
    private static int[] getRightMax(int[] arr){
        int[] res=new int[arr.length];
        res[0]=0;
        for(int i=arr.length-1;i>0;i--){
            int max=Integer.MIN_VALUE;
            int cur=0;
            for(int j=i;j<arr.length;j++){
                cur+=arr[j];
                max=Math.max(max,cur);
                cur=cur<0?0:cur;
            }
            res[i]=max;

        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
        System.out.println(getMax2(arr1));

        int[] arr2 = { -2, -3, -5, 0, 1, 2, -1 };
        System.out.println(getMax2(arr2));

        int[] arr3 = { -2, -3, -5, -1 };
        System.out.println(getMax2(arr3));

    }
}
