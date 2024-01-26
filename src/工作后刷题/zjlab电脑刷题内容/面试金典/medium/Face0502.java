package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-05  14:15
 * <p>
 * 二进制数转字符串。
 * 给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * <p>
 * 示例1:
 * <p>
 * 输入：0.625
 * 输出："0.101"
 * 示例2:
 * <p>
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 * <p>
 * <p>
 * 提示：
 * <p>
 * 32位包括输出中的 "0." 这两位。
 * 题目保证输入用例的小数位数最多只有 6 位
 */
public class Face0502 {

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        double z = 0.5;
        while (num != 0 && sb.length() < 32) {
            if (num >= z) {
                sb.append(1);
                num -= z;
            } else {
                sb.append(0);
            }
            z /= 2;
        }
        return sb.length() >= 32 ? "ERROR" : sb.toString();
    }
}
