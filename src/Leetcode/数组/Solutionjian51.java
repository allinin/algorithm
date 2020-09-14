package Leetcode.数组;

/**
 * @author zbl
 * @version 1.0
 * @content:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

 

示例 1:

输入: [7,5,6,4]
输出: 5
 

限制：

0 <= 数组长度 <= 50000

通过次数39,944提交次数86,959

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/9/9 10:02
 */
public class Solutionjian51 {

    public int res=0;
    public int reversePairs(int[] nums) {
        if(nums==null || nums.length<2) return 0;
        int left=0,right=nums.length-1;
        reversePairs(nums,left,right);
        return res;

    }

    public void reversePairs(int[] nums,int left,int right){
        if(left<right){
            int mid=(left+right)>>>1;
            reversePairs(nums,left,mid);
            reversePairs(nums,mid+1,right);
            if(nums[mid]<=nums[mid+1])
                return;
            sort(nums,left,right);
        }
    }

    public void sort(int[]nums,int left,int right){
        if(left==right) return;
        int[] help=new int[right-left+1];
        int mid=(left+right)>>>1;
        int index=0,l=left,r=mid+1;
        while(l<=mid && r<=right){
            if(nums[l]<=nums[r]){//左边的小就计算一下逆序对的数量，此时说明有r-mid-1个小于nums[l]的数跑到了l位置的后面，所以计算一下逆序对的数量r-mid-1;
                help[index++]=nums[l++];
            }else{
                res+=(mid-l+1);
                help[index++]=nums[r++];
            }
        }
        while(l<=mid){
            help[index++]=nums[l++];
        }
        while(r<=right){
            help[index++]=nums[r++];
        }
        index=0;
        for(int i=left;i<=right;i++){
            nums[i]=help[index++];
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,3,2,3,1};
        System.out.println(new Solutionjian51().reversePairs(arr));
    }
}
