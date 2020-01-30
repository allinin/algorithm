package ZUOSHEN.进阶班.进阶八;

/**
 * @author zbl
 * @version 1.0
 * @content: 给定一个数组arr,值可正可负，可0；一个整数aim,求累加和小于等于aim的最长子数组
 * @date 2020/1/27 9:47
 */
public class LongestSubarrayLessSumSolution {

    //O(N）
    public static int maxLengthAwesome(int[] arr,int aim){

        if(arr==null || arr.length==0 )
            return 0;
        int[] sums=new int[arr.length];
        int[] ends=new int[arr.length];
        sums[arr.length-1]=arr[arr.length-1];
        ends[arr.length-1]=arr.length-1;

        for(int i=arr.length-2;i>=0;i--){
            if(sums[i+1]<0){
                sums[i]=arr[i]+sums[i+1];
                ends[i]=ends[i+1];
            }else{
                sums[i]=arr[i];
                ends[i]=i;
            }
        }
        int end=0;
        int sum=0;
        int res=0;
        for(int i=0;i<arr.length;i++){
            while(end<arr.length && sums[end]+sum<=aim)
            {
               sum+=sums[end];
               end=ends[end]+1;
            }
            sum-=end>i ? arr[i]:0; //不是再次从i+1位置重复判断，而是减去i位置的值，再次进行判断,如果减去i位置的值
            //仍然不满足，则直接跳过i+1位置。
            res=Math.max(res,end-i);
            end=Math.max(end,i+1);
        }
        //这样做的话会重复计算，使时间复杂度成了O(n^2)
//        for(int i=0;i<arr.length;i++){
//
//            while(end<arr.length && sums[end]+sum<=aim)
//            {
//                sum+=sums[end];
//                end=ends[end]+1;
//            }
//            res=Math.max(res,end-i);
//            end=i+1;
//            sum=0;
//        }
        return res;

    }

    //O(NlogN)
    public static int maxLength(int[] arr, int k) {
        int[] h = new int[arr.length + 1];
        int sum = 0;
        h[0] = sum;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            h[i + 1] = Math.max(sum, h[i]);
        }
        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            pre = getLessIndex(h, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    public static int getLessIndex(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int res = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= num) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int len, int maxValue) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            int[] arr = generateRandomArray(10, 20);
            int k = (int) (Math.random() * 20) - 5;
            if (maxLengthAwesome(arr, k) != maxLength(arr, k)) {
                System.out.println("oops!");
            }
        }

    }

}
