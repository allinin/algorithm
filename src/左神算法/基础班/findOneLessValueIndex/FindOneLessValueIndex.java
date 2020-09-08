package 左神算法.基础班.findOneLessValueIndex;

/**
 * 二分法的应用：
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度 为N(N>1)时，如果arr[0]<arr[1]，
 * 那么arr[0]是局部最小；如果 arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，既有 arr[i]<arr[i-1]，
 * 又有arr[i]<arr[i+1]，那么arr[i]是局部最小。给定无序数组arr，已知arr中任意两个相邻的数都不相等。
 * 写一个函 数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class FindOneLessValueIndex {

    public static int getLessIndex(int[] arr)
    {
       if(arr==null || arr.length==0)
           return -1;
       if(arr.length==1 || arr[0]<arr[1])
           return 0;
       if(arr[arr.length-1]<arr[arr.length-2])
           return arr.length-1;
       int left=1,right=arr.length-2;
       int mid=0;
       while(left<right){
           mid=(left+right)>>>1;
           if(arr[mid]>arr[mid-1]){
               right=mid-1;
           }else if(arr[mid]>arr[mid+1]){
               left=mid+1;
           }else{
               return mid;
           }
       }
       return left;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 6, 4, 3, 5, 6, 7, 8 };
        printArray(arr);
        int index = getLessIndex(arr);
        System.out.println("index: " + index + ", value: " + arr[index]);

    }


}
