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
        System.out.println(getAns(2222,new int[] {3,4,5}));
    }

    public static int getAns(int n, int[] arr) {
        Arrays.sort(arr);
        int len = String.valueOf(n).length();
        int tmpAns = process(n, arr,len,0,0 );
        if(tmpAns > 0) {
            return tmpAns;
        }
        int ans = 0;
        for(int i = 0;i < len - 1;i++) {
            ans = ans * 10 + arr[arr.length - 1];
        }
        return ans;
    }

    /**
     * 寻找小于n的最大值，如果
     * @param targetNum
     * @param arr :已经是经过处理的从小到大排序的数组
     * @param targetLen
     * @param nowLen
     * @param nowNum
     * @return
     */

    private static int process(int targetNum, int[] arr, int targetLen, int nowLen, int nowNum) {
        if (nowLen == targetLen && nowNum < targetNum) {
            return nowNum;
        }
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
}
