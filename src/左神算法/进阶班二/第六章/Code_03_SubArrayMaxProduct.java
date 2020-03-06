package 左神算法.进阶班二.第六章;

/**
 * @author zbl
 * @version 1.0
 * @content:数组中子数组的最大累乘积
【题目】
给定一个double类型的数组arr，其中的元素可正、可负、可0，返回
子数组累乘的最大乘积。例如，arr=[-2.5，4，0，3，0.5，8，-1]，
子数组[3，0.5，8]累乘可以获得最大的乘积12，所以返回12。
 * @date 2020/2/28 15:55
 */
public class Code_03_SubArrayMaxProduct {

    //以每个位置结尾考虑,求每一个位置的最大值与最小值
    public static double maxProduct(double[] arr){
        if(arr==null || arr.length==0)
            return 0;
        double max=arr[0];//动态记录以每一个位置结尾的最大值
        double min=arr[0];//动态记录以每一个位置结尾的最小值
        double res=arr[0];
        //int cur=1;
        for(int i=1;i<arr.length;i++){
            max=Math.max(arr[i],Math.max(arr[i]*max,arr[i]*min));
            min=Math.min(arr[i],Math.min(arr[i]*max,arr[i]*min));
            res=Math.max(res,max);
        }
        return res;
    }

    public static void main(String[] args) {
        double[] arr = { -2.5, 4, 0, 3, 0.5, 8, -1 };
        System.out.println(maxProduct(arr));
    }
}
