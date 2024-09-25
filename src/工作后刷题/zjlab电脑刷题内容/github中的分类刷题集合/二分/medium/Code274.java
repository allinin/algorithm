package 工作后刷题.zjlab电脑刷题内容.github中的分类刷题集合.二分.medium;

import java.util.Arrays;

/**
 * H指数 medium
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * 示例 2：
 * <p>
 * 输入：citations = [1,3,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 *
 * @author: ZBL
 * @date: 2024-09-25  20:03
 */
public class Code274 {

    //O(nlogn)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int left = 0, right = citations.length;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (find(citations, mid) >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int find(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr.length - left;
    }

    //O(N)
    public int hIndex2(int[] citations) {
        int[] help = new int[citations.length + 1];
        for (int num : citations) {
            help[Math.min(num, citations.length)]++;
        }
        int ans = 0;
        for (int i = citations.length; i >= 0; i--) {
           ans += help[i];
           if(ans >= i) {
               return i;
           }
        }
        return 0;
    }



}
