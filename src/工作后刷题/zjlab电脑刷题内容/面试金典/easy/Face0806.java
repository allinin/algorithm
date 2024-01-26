package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-09  09:19
 *
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。
 * 一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 * 示例1:
 *
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 * 示例2:
 *
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 * 提示:
 *
 * A中盘子的数目不大于14个。
 */
public class Face0806 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        process(A.size(),A,B,C);
    }

    private void process(int size,List<Integer> A, List<Integer> B, List<Integer> C) {
        //只有一个盘子，直接放到C即可
        if(size == 1) {
            C.add(A.remove(A.size() - 1));//这里不能直接remove(0),因为size == 1的时候不一定是0位置的盘子
        } else {
            //先将A的前n-1个盘子放到借助C放到B
            process(size - 1,A,C,B);
            //再将A的最后一个盘子放到C
            C.add(A.remove(A.size() - 1));
            //最后将B中的n-1个盘子借助A放到C
            process(size -  1,B,A,C);
        }
    }
}
