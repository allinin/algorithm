package 左神算法.高频面试题.数组问题;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个长度为N（N>1)的整型数组arr,可以划分为左右两部分，左部分为arr[0,k],右部分为arr[k+1,N-1],k可以取值的范围为[0,N-2],求这么多划分案例中，作部分的最大值
 * 减去右部分的最大值的绝对值中，最大是多少？
 * @date 2020/1/3 10:45
 */
public class MaxABSBetweenLeftAndRight {

    //最终的结果一定是整个数组的最大值减去某一个数，当最大值在左半部分时，右半部分一定包括最右边的元素，所以右半部分的最大值>=arr[arr.length-1];
    //同理当最大值在数组的右半部分时。所以只需要用最大值减去arr[0]与arr[arr.length-1]中的较小的那个。
    public static int maxABS1(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }
        return max-Math.min(arr[0],arr[arr.length-1]);
    }
    //采用辅助数组的方式，记录以数组中每个位置为分点的左右两部分的最值，然后分别判断二者的差绝对值最大的。
    public static int maxABS2(int[] arr){
        if(arr==null || arr.length<2)
            return 0;
        int res=Integer.MIN_VALUE;
        int[] rmax=new int[arr.length];
        rmax[arr.length-1]=arr[arr.length-1];
        int[] lmax=new int[arr.length];
        lmax[0]=arr[0];
        for(int i=arr.length-2;i>-1;i--){
            rmax[i]=Math.max(arr[i],rmax[i+1]);
        }
        for(int i=1;i<arr.length;i++)
        {
            lmax[i]=Math.max(lmax[i-1],arr[i]);
        }

        for(int i=0;i<arr.length-1;i++){
            res=Math.max(res,Math.abs(lmax[i]-rmax[i+1]));
        }
        return res;
    }

    public static int[] generateRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i != arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000) - 499;
        }
        return arr;
    }

    public static void main(String[] args) {
        for(int i=0;i<50000;i++){
            int[] arr = generateRandomArray(200);
            int i1 = maxABS1(arr);
            int i2 = maxABS2(arr);
            if(i1!=i2){
                System.out.println("出错了！！！！");
                return;
            }
        }
        System.out.println("完全正确！！！！！");
       // System.out.println(maxABS3(arr));
    }
}
