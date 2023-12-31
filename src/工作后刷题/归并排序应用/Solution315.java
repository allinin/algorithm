package 工作后刷题.归并排序应用;


import java.util.*;

/**
 * @Author:zbl
 * @Date:2023/12/31 13:59
 * <p>
 * 计算右侧小于当前元素的个数(逆序对的变种)
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 * <p>
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Solution315 {


    //归并的方式

    public static int[] index;
    int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        this.index = new int[nums.length];
        this.ans = new int[nums.length];
        //索引数组：表示顺序更改后的每一个元素在原数组中的位置
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1);
        for (int num : ans) {
            res.add(num);
        }
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        //因为是从大到小排序，如果前半部的最小值小于于后半部分的最大值才进行merge
        if (nums[mid] <= nums[mid + 1]) {
            mergeProcess(nums, left, right);
        }

    }

    private void mergeProcess(int[] nums, int left, int right) {
        int[] help = new int[right - left + 1];
        int[] tmpIndex = new int[right - left + 1];
        int mid = left + (right - left) / 2;
        int idx1 = left, idx2 = mid + 1, idx = 0;
        //这里改为从大到小排序
        while (idx1 <= mid && idx2 <= right) {
            if (nums[idx1] > nums[idx2]) {
                tmpIndex[idx] = index[idx1];
                ans[index[idx1]] += (right - idx2 + 1);
                help[idx++] = nums[idx1++];
            } else {
                tmpIndex[idx] = index[idx2];
                help[idx++] = nums[idx2++];
            }
        }
        while (idx1 <= mid) {
            tmpIndex[idx] = index[idx1];
            help[idx++] = nums[idx1++];

        }

        while (idx2 <= right) {
            tmpIndex[idx] = index[idx2];
            help[idx++] = nums[idx2++];
        }
        for (int i = left; i <= right; i++) {
            index[i] = tmpIndex[i - left];
            nums[i] = help[i - left];
        }

    }


    //树状数组的方式
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //结构只与nums中元素的相对大小有关，首先进行离散化处理
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //离散化编号处理，值越小编号越小，值越大编号越大，编码代表了在树状数组底层数组的索引位置
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int num : set) {
            map.put(num, idx++);
        }
        TreeArray treeArray = new TreeArray(nums.length + 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            //获取离散化后的编码值
            int id = map.get(nums[i]);
            //编码为id的数量 + 1，对应的前缀和+1
            treeArray.add(id,1);
            //找出id - 1位置之前元素的前缀和
            res.add(treeArray.query(id - 1));
        }
        Collections.reverse(res);
        return res;
    }

    class TreeArray {

        //数状数组的前缀和表示
        int[] count;

        //树状数组计算的原底层数组
        int[] nums;

        public TreeArray(int n) {
            this.count = new int[n];
            this.nums = new int[n];
        }

        public void add(int idx, int delta) {
            while (idx < count.length) {
                count[idx] += delta;
                idx += lowBit(idx);
            }
        }

        //获取数组的前缀和
        public int query(int x) {
            int ans = 0;
            while (x > 0) {
                ans += count[x];
                x -= lowBit(x);
            }
            return ans;
        }

        //返回x二进制表示中最低为1表示的值
        private int lowBit(int x) {
            return x & (-x);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 6, 1};
        List<Integer> integers = new Solution315().countSmaller2(arr);
        for(int num : integers) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : arr) {
            System.out.print(num + " ");
        }
//        int x = 5;
//        System.out.println((x & (-x)) == (x - (x&(x - 1))));
    }
}
