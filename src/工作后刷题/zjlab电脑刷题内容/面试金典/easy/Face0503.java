package 工作后刷题.zjlab电脑刷题内容.面试金典.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZBL
 * @Date: 2024-01-05  14:26
 * 翻转数位
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(01112)
 * 输出: 4
 */
public class Face0503 {

    public static int reverseBits(int num) {
        int ans = 1;
        List<int[]> help = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) == 0) {
                //连续1的起始位置，结束位置
                if(start <= i - 1) {
                    help.add(new int[]{start, i - 1});
                }
                start = i + 1;
            }
            if ((i == 31) && (num & (1 << i)) != 0) {
                help.add(new int[]{start, i});
            }
        }
        for (int i = 0; i < help.size(); i++) {
            int left1 = help.get(i)[0];
            int right1 = help.get(i)[1];
            if (i < help.size() - 1) {
                int left2 = help.get(i + 1)[0];
                int right2 = help.get(i + 1)[1];

                if (left2 == right1 + 2) {
                    ans = Math.max(right2 - left1 + 1, ans);
                } else {
                    ans = Math.max(right1 - left1 + 2, ans);
                }
            } else {
                ans = Math.max(right1 - left1 + 2,ans);
            }
        }
        return ans > 32 ? 32 : ans;
    }

    public static void main(String[] args) {
        int num = -1;
        int n =reverseBits(num);

        System.out.println(n);
    }
}
