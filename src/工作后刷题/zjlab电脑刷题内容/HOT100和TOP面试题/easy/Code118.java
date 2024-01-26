package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2023-12-20  15:48
 * <p>
 * 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 */
public class Code118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (res.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                res.add(list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                List<Integer> pre = res.get(i - 2);
                if (pre.size() < 2) {
                    list.add(1);
                    res.add(list);
                } else {
                    for (int j = 1; j < i - 1; j++) {
                        int sum = pre.get(j - 1) + pre.get(j);
                        list.add(sum);
                    }
                    list.add(1);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Code118().generate(5);
        for(List<Integer> list : res) {
            for(Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
