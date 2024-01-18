package 工作后刷题.快排中的三分数组;

/**
 * @Author:zbl
 * @Date:2024/1/13 21:15
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * <p>
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * <p>
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class Face1714 {

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int n = arr.length;
        if (n == k) {
            return arr;
        }
        int left = 0, right = n - 1;
        while (true) {
            int[] tmp = process(arr, left, right, arr[right]);
            if (tmp[0] <= k - 1 && k - 1 <= tmp[1]) {
                break;
            } else if (tmp[0] > k - 1) {
                right = tmp[0] - 1;
            } else {
                left = tmp[1] + 1;
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private int[] process(int[] arr, int left, int right, int target) {
        int l = left - 1, r = right + 1; //l : 小于target的最大索引，r:大于target的最小索引
        while (left < r) {
            int num = arr[left];
            if (num < target) {
                swap(arr, ++l, left++);
            } else if (num > target) {
                swap(arr, --r, left);
            } else {
                left++;
            }
        }
        int[] ans = new int[2];
        ans[0] = l + 1;
        ans[1] = r - 1;
        return ans;
    }

    private void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        int[] ints = new Face1714().smallestK(arr, k);
        for (int i : ints) {
            System.out.print(i + ",");
        }
    }
}
