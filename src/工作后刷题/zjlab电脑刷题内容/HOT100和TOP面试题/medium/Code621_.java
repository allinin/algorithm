package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 任务调度器
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * 诸如此类
 * 示例 3：
 * <p>
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= task.length <= 104
 * tasks[i] 是大写英文字母
 * n 的取值范围为 [0, 100]
 */
public class Code621_ {

    //TODO 思路不够清晰，多次调试才通过

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] help = new int[26];
        int validNum = 0;
        for (char task : tasks) {
            if (help[task - 'A'] == 0) {
                validNum++;
            }
            help[task - 'A']++;
        }
        //构建大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return help[o2] - help[o1];
            }
        });

        for (int i = 0; i < 26; i++) {
            if (help[i] != 0) {
                priorityQueue.add(i);
            }
        }
        int ans = 0;
        while (validNum != 0 && !priorityQueue.isEmpty()) {
            int i = 0;
            int[] tmp = new int[n + 1];
            Arrays.fill(tmp, -1);
            for (; i <= n; i++) {
                Integer index = priorityQueue.poll();
                ans++;
                help[index]--;
                if (help[index] == 0) {
                    validNum--;
                } else {
                    tmp[i] = index;
                }
                if (priorityQueue.isEmpty()) {
                    break;
                }

            }
            //说明不同元素的数量小于n + 1,或者当前已经没有元素了，只有不是没有元素的前提下才进行等待
            if (i < n && validNum != 0) {
                ans += n - i;
            }
            for (int j = 0; j <= n; j++) {
                if (tmp[j] != -1) {
                    priorityQueue.add(tmp[j]);
                }
            }

        }
        return ans;
    }

    /**
     * 方法二:最终使用时间为(maxCount - 1) * (n + 1) + maxNum
     * 其中maxCount为tasks数组中出现频率最高的字符出现的次数，maxNum为出现频率为maxCount的字符的数量
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval2(char[] tasks, int n) {

        return 0;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        char[] tasks1 = {'A','B','C','D','E','A','B','C','D','E'};
        char[] tasks2 = {'A','A','A','B','B','B','C','C','C','D','D','E'};

        System.out.println(new Code621_().leastInterval(tasks2, 2));
    }
}
