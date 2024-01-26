package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.easy;

/**
 * @Author: ZBL
 * @Date: 2023-12-25  15:33
 * <p>
 * Excel表列序号
 * <p>
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 */
public class Code171 {

    public int titleToNumber(String columnTitle) {
        if(columnTitle == null || columnTitle.length() == 0) {
            return 0;
        }
        int ans = 0;
        for(int i = columnTitle.length() - 1;i >= 0;i--) {
            char c = columnTitle.charAt(i);
            ans += (c - 'A' + 1) * Math.pow(26,columnTitle.length() - 1 - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Code171().titleToNumber("AB"));
    }
}
