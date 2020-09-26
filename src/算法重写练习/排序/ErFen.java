package 算法重写练习.排序;

/**
 * @author zbl
 * @version 1.0
 * @content:统计一个数字在排序数组中出现的次数。

 

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
 

限制：

0 <= 数组长度 <= 50000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/9/15 16:11
 */
public class ErFen {

    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int n=nums.length;
        int left=0,right=n-1;
        int start=-1,end=-1;
        while(left<right){//寻找第一次出现的位置
            int mid=(left+right)>>>1;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        start=left;
        if(nums[start]!=target) return 0;
        left=0;
        right=n-1;
        while(left<right){//寻找最后一次出现的位置
            int mid=(left+right+1)>>>1;
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid;
            }
        }
        end=left;
        return end-start+1;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{5,7,7,8,8,10};
        System.out.println(search(arr,7));
    }

}
