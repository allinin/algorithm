package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-08  09:32
 * <p>
 * 下一个数。(TODO 多次debug才通过)
 * 给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 * <p>
 * 输入：num = 1
 * 输出：[2, -1]
 * 提示:
 * <p>
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 */
public class Face0504_DONE {

    public static int[] findClosedNumbers(int num) {
        int[] ans = new int[2];
        int idx = -1;//最左边1的位置
        int idx2 = -1;//左边第2个有效0的位置
        int idx3 = -1;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                if (idx == -1) {
                    idx = i;
                } else if (idx2 != -1) {
                    idx3 = i;
                    break;
                }
            } else {
                if (idx != -1 && idx2 == -1) {
                    idx2 = i;
                }
            }
        }

        int deleteLastOne = num & (num - 1);
        if (idx != 0) {
            ans[1] = deleteLastOne | (1 << (idx - 1));
        } else {
            if (idx2 == 31 || idx3 == -1) {
                ans[1] = -1;
            } else {
                int tmp = num | (1 << (idx3 - 1));
                tmp ^= (1 << idx3);
                int add = 2;
                //将idx2之前的1移动到idx3 -1之后,先取消置0再置1，否则会有问题
                for (int i = idx2 - 1; i >= 0; i--) {
                    if ((num & (1 << i)) != 0) {
                        tmp ^= (1 << i);
                        tmp |= (1 << (idx3 - add));
                        add++;
                    }
                }
                ans[1] = tmp;
            }
        }

        if (idx2 == 31) {
            ans[0] = -1;
            return ans;
        }
        num |= (1 << idx2);
        num ^= (1 << (idx2 - 1));
        int id = 0;
        //idx2 - 1之前的1右移，先取消置0再置1
        for (int i = 0; i < idx2 - 1; i++) {
            if ((num & (1 << i)) != 0) {
                num ^= (1 << i);
                num |= (1 << id);
                id++;
            }
        }
        ans[0] = num;
        return ans;
    }

    public static void main(String[] args) {
        findClosedNumbers(2147483647);
    }

}
