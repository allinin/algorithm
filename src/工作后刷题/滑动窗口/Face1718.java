package 工作后刷题.滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author:zbl
 * @Date:2024/1/9 21:05
 * 最短超串(medium)
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * <p>
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * 示例 2:
 * <p>
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * 提示：
 * <p>
 * big.length <= 100000
 * 1 <= small.length <= 100000
 */
public class Face1718 {

    public int[] shortestSeq(int[] big, int[] small) {
        int[] ans = new int[]{0, big.length - 1};
        Set<Integer> set = new HashSet<>();
        for (int num : small) {
            set.add(num);
        }
        int smallDiffNums = set.size();
        int left = 0, right = 0, n = big.length;
        Map<Integer, Integer> bigMap = new HashMap<>();
        int effectNums = 0;
        boolean find = false;
        while (right < n) {
            int num = big[right++];
            bigMap.put(num, bigMap.getOrDefault(num, 0) + 1);
            if (set.contains(num) && bigMap.get(num) == 1) {
                effectNums++;
            }
            if (effectNums == smallDiffNums) {
                find = true;
                int oldStart = ans[0], oldEnd = ans[1];
                while (effectNums == smallDiffNums) {
                    ans[0] = left;
                    ans[1] = right - 1;
                    int leftNum = big[left++];
                    if (bigMap.get(leftNum) == 1) {
                        bigMap.remove(leftNum);
                        if (set.contains(leftNum)) {
                            effectNums--;
                        }
                    } else {
                        bigMap.put(leftNum, bigMap.get(leftNum) - 1);
                    }
                }
                if (ans[1] - ans[0] >= oldEnd - oldStart) {
                    ans[0] = oldStart;
                    ans[1] = oldEnd;
                }
            }


        }
        return find ? ans : new int[0];
    }

}
