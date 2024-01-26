package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * 数组中的第K个最大元素
 * <p>
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Code215 {

    //快排的方式实现
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int targetIndex = n - k;
        while (left < right) {
            //每次find()操作后，时间复杂度平均变为上一次的1/2,累加后时间负责度小于o(2n),所以总得时间复杂度可以认为是o(n)
            int[] ans = find(nums, left, right);
            if (ans[0] <= targetIndex && ans[1] >= targetIndex) {
                return nums[ans[0]];
            } else if (ans[1] < targetIndex) {
                left = ans[1] + 1;
            } else {
                right = ans[0] - 1;
            }
        }
        return nums[left];
    }

    //o(N)寻找nums[right]在数组第一次出现的位置及最后一次出现的位置
    private int[] find(int[] nums, int left, int right) {
        int[] ans = new int[2];
        int l = left - 1, r = right + 1;
        int target = nums[right];
        while (left < r) {
            if (nums[left] < target) {
                swap(nums, ++l, left++);
            } else if (nums[left] > target) {
                swap(nums, --r, left);
            } else {
                left++;
            }
        }
        //记录target 第一次出现的位置及最后一次出现的位置
        ans[0] = l + 1;
        ans[1] = r - 1;
        return ans;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    //堆排序的方式
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        //构建大顶堆
        buildHeap(nums);
        for (int i = 0;i < k;i++) {
            swap(nums,0,--n);
            heapfy(nums,0,n - 1);
        }
        return nums[n];
    }


    //构建大顶堆
    private void buildHeap(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //如果子节点 < 当前节点，则替换二者的位置
            while (nums[i] > nums[(i - 1) / 2]) {
                swap(nums, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    private void heapfy(int[] nums,int start,int end) {
        int left = 2 * start + 1;
        while(left <= end) {
            int indexMax = (left + 1 <= end && nums[left] < nums[left + 1]  ? left + 1 : left );
            if(nums[start] >= nums[indexMax]) {
                break;
            } else {
                swap(nums,start,indexMax);
                start = indexMax;
                left = start * 2 + 1;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(new Code215().findKthLargest2(nums, 9));
    }
}
