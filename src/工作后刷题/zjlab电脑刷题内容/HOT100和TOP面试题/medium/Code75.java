package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 颜色分类
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 *
 * 进阶：
 *
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Code75 {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) {
            return ;
        }
        int n = nums.length,target = 1;
        int left = -1,right = n,index = 0;
        while(index < right) {
            int num = nums[index];
            if(num < target) {
                swap(nums,++left,index++);
            } else if(num > target) {
                swap(nums,--right,index);
            } else {
                index++;
            }
        }
    }

    private void swap(int[] arr,int left,int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,0,2,1,1,0};
        new Code75().sortColors(arr);
        for(int i : arr) {
            System.out.println( i);
        }
    }
}
