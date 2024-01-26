package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZBL
 * @Date: 2023-12-25  15:31
 * <p>
 * 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 如果存在多个答案，只需返回 任意一个 。
 * <p>
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 * <p>
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 * <p>
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 */
public class Code166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == Integer.MIN_VALUE && denominator == -1) {
            long tmp = (long) Integer.MIN_VALUE * (-1);
            return String.valueOf(tmp);
        }
        if (denominator == 1 || denominator == -1) {
            return String.valueOf(numerator * denominator);
        }
        if(numerator == 0) {
            return "0";
        }

        long numeratorTmp = Math.abs((long)numerator);
        long denominatorTmp = Math.abs((long)denominator);
        StringBuilder sb = new StringBuilder();
        sb.append((numerator < 0 ? -1 : 1) * (denominator < 0 ? -1 : 1 ) < 0  ? "-" :"");
        //记录小数点后每个除数对应的结果位置
        Map<Long, Integer> map = new HashMap<>();
        boolean flag = false;
        while (numeratorTmp != 0) {
            long tmp = numeratorTmp / denominatorTmp;
            sb.append(tmp);
            numeratorTmp %= denominatorTmp;
            //说明是循环小数
            if (map.containsKey(numeratorTmp)) {
                String last = sb.toString().substring(map.get(numeratorTmp));
                String first = sb.toString().substring(0,map.get(numeratorTmp));
                return first + "(" + last + ")";
            }
            if (numeratorTmp != 0) {
                if(!flag) {
                    sb.append(".");
                    flag = true;
                }
                map.put(numeratorTmp, sb.length());
                numeratorTmp =  numeratorTmp * 10;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Code166 code166 = new Code166();
        System.out.println(code166.fractionToDecimal(-1, -2147483648));
    }
}
