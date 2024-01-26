package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * @Author: ZBL
 * @Date: 2023-12-21  10:58
 * <p>
 * 加油站
 * <p>
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * <p>
 * 提示:
 * <p>
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 */
public class Code134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n;) {
            if (gas[i] < cost[i]) {
                ++i;
                continue;
            }
            int index = (i + 1) % n;
            int value = gas[i] - cost[i];
            boolean pass = true;
            while (index != i) {
                //此时value一定是大于0的，即：value+gas[index]一定是大于gas[index]的，也就是说此时拥有的汽油一定是大于直接从index
                //位置走拥有的汽油。==》如果此时不通过，则直接从index位置走一定也不能通过！
                if (value + gas[index] < cost[index]) {
                    pass = false;
                    break;
                }
                //上次循环的if通过，更新后的value一定是大于0的
                value = value + gas[index] - cost[index];
                index = (index + 1) % n;
            }
            if(pass) {
                return i;
            } else {
                //若果index已经跨过了最后一个加油站，则一定不存在能够到达的加油站
               if(index < i) {
                   return -1;
               } else {
                   //否则从不能到达的加油站开始计算
                   i = index + 1;
               }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code134().canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}));
    }
}
