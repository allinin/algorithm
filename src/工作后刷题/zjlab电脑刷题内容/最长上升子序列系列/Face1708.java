package 工作后刷题.zjlab电脑刷题内容.最长上升子序列系列;

import java.util.Arrays;

/**
 * @Author: ZBL
 * @Date: 2024-01-10  09:47
 * <p>
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。
 * 出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。
 * 已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 * <p>
 * 示例：
 * <p>
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * 提示：
 * <p>
 * height.length == weight.length <= 10000
 */
public class Face1708 {
    //o(n^2)的时间复杂度，超时了
    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[][] tmp = new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            tmp[i][0] = height[i];
            tmp[i][1] = weight[i];
        }
        //先按某一维进行排序，排序后，剩下的一维边长了最长子序列问题
        Arrays.sort(tmp, (a, b) -> a[0] - b[0]);
        int[] dp = new int[height.length];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (tmp[i][0] > tmp[j][0] && tmp[i][1] > tmp[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }

    //最小结尾子数组的方式 O(NlogN)
    public int bestSeqAtIndex2(int[] height, int[] weight) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[][] tmp = new int[height.length][2];
        for (int i = 0; i < height.length; i++) {
            tmp[i][0] = height[i];
            tmp[i][1] = weight[i];
        }
        //先按某一维进行排序，如果排序维度相等，则按照另一维度降序排序后，剩下的一维边长了最长子序列问题
        Arrays.sort(tmp, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[][] dp = new int[height.length + 1][2];
        for(int[] help : dp) {
            Arrays.fill(help,Integer.MAX_VALUE);
        }
        dp[1][0] = tmp[0][0];
        dp[1][1] = tmp[0][1];
        int effectLen = 1;
        for (int i = 1; i < height.length; i++) {
            int left = 1, right = effectLen + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid][0] < tmp[i][0] && dp[mid][1] < tmp[i][1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == effectLen + 1) {
                effectLen++;
                dp[effectLen][0] = tmp[i][0];
                dp[effectLen][1] = tmp[i][1];
            } else {
                //此时dp[left][0]可能是== tmp[i][0]的
                if (dp[left][1] > tmp[i][1]) {
                    dp[left][0] = tmp[i][0];
                    dp[left][1] = tmp[i][1];
                }
            }

        }

        return effectLen;
    }

    public static void main(String[] args) {
        int[] height = new int[]{65, 70, 56, 75, 60, 68};
        int[] weight = new int[]{100, 150, 90, 190, 95, 110};
        new Face1708().bestSeqAtIndex2(height, weight);

    }
}
