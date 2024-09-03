package 工作后刷题.zjlab电脑刷题内容.社招面试题目.字节;

import java.util.Arrays;

/**
 * 给定一个数字字符串S和一个数组nums，数组中的元素都在0~9之间，问从数组中选择元素组成的数字，小于N的最大值是多少？
 * <p>
 * 例如：S = "24378"，nums:{2,3,9}，组成的最大值为23999。
 *
 * @author: ZBL
 * @date: 2024-08-28  09:04
 */
public class BiggestNumLessThanN {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(getAns(24378, new int[]{2, 4, 5, 8}));
        System.out.println(getAns2(24378, new int[]{2, 4, 5, 8}));

        System.out.println(findFirstAppearanceIndex(new int[]{1, 2, 3, 5, 5, 6}, 8));

    }

    /**
     * 时间复杂度 mlogm + mk,其中m为数组arr的长度，k为n的位数
     *
     * @param n
     * @param arr
     * @return
     */
    public static int getAns(int n, int[] arr) {
        Arrays.sort(arr);
        int len = String.valueOf(n).length();
        int tmpAns = process(n, arr, len, 0, 0);
        if (tmpAns > 0) {
            return tmpAns;
        }
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            ans = ans * 10 + arr[arr.length - 1];
        }
        return ans;
    }

    /**
     * 寻找小于n的最大值，如果
     *
     * @param targetNum
     * @param arr       :已经是经过处理的从小到大排序的数组
     * @param targetLen
     * @param nowLen
     * @param nowNum
     * @return
     */

    private static int process(int targetNum, int[] arr, int targetLen, int nowLen, int nowNum) {
        //因为arr是从大到小排序的，所以第一个符合的结果一定就是最终目标值
        if (nowLen == targetLen && nowNum < targetNum) {
            return nowNum;
        }
        //方法二：todo 将这个for循环改为二分查找的方式，查找小于等于targetNum 第 nowLen + 1位的数字最早出现的位置，如果不存在，则直接返回-1,此时时间复杂度为 klogm
        for (int i = arr.length - 1; i >= 0; i--) {
            if (targetNum / Math.pow(10, targetLen - nowLen - 1) < nowNum * 10 + arr[i]) {
                continue;
            }
            nowNum = nowNum * 10 + arr[i];
            return process(targetNum, arr, targetLen, nowLen + 1, nowNum);
        }
        //没有返回值说明没有找到答案，返回一个无效值辅助最终结果构建
        return -1;
    }

    public static int getAns2(int n, int[] arr) {
        Arrays.sort(arr);
        int len = String.valueOf(n).length();
        int tmpAns = process2(String.valueOf(n), arr, len, 0, 0);
        if (tmpAns > 0) {
            return tmpAns;
        }
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            ans = ans * 10 + arr[arr.length - 1];
        }
        return ans;
    }

    private static int process2(String targetNum, int[] arr, int targetLen, int nowLen, int nowNum) {
        //因为arr是从大到小排序的，所以第一个符合的结果一定就是最终目标值
        if (nowLen == targetLen && nowNum < Integer.parseInt(targetNum)) {
            return nowNum;
        }
        if (nowLen == targetLen) {
            return -1;
        }
        int index = findFirstAppearanceIndex(arr, targetNum.charAt(nowLen) - '0');
        //说明不存在相同的值,取index - 1位置的值
        if (arr[index] > targetNum.charAt(nowLen) - '0') {
            if(index == 0) {
                return -1;
            }
            nowNum = nowNum * 10 + arr[index - 1];
            //后续的直接取数组中的最大值
            for(int i = 0;i < targetLen - nowLen - 1;i++) {
                nowNum = nowNum * 10 + arr[arr.length - 1];
            }
            return nowNum;
        } else {
            //index 位置的元素小于等于targetNum对应位置的值
            nowNum = nowNum * 10 + arr[index];
        }
        return process2(targetNum, arr, targetLen, nowLen + 1, nowNum);

    }


    private static int findFirstAppearanceIndex(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
