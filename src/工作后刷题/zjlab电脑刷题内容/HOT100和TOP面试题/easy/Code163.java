package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-02  14:14
 * 缺失的区间
 * <p>
 * 给你一个闭区间 [lower, upper] 和一个 按从小到大排序 的整数数组 nums ，其中元素的范围在闭区间 [lower, upper] 当中。
 * <p>
 * 如果一个数字 x 在 [lower, upper] 区间内，并且 x 不在 nums 中，则认为 x 缺失。
 * <p>
 * 返回 准确涵盖所有缺失数字 的 最小排序 区间列表。也就是说，nums 的任何元素都不在任何区间内，并且每个缺失的数字都在其中一个区间内。
 * ————————————————
 * 版权声明：本文为CSDN博主「xuxigifxfh」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_45794129/article/details/132188157
 */
public class Code163 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(lower);
            list.add(upper);
            res.add(list);
            return res;
        }
        int pre = lower - 1;
        for (int num : nums) {
            if (num > pre + 1) {
                List<Integer> list = new ArrayList<>();
                list.add(lower + 1);
                list.add(num - 1);
                res.add(list);
            }
            pre = num;
        }
        if (upper > pre + 1) {
            List<Integer> list = new ArrayList<>();
            list.add(pre + 1);
            list.add(upper);
            res.add(list);
        }
        return res;
    }
}
