package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/17 15:41
 */
public class Solution415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int len1=num1.length()-1;
        int len2=num2.length()-1;
        int help=0;
        while(len1>=0 && len2>=0){
            int n1=num1.charAt(len1--)-'0';
            int n2=num2.charAt(len2--)-'0';
            int h=(n1+n2+help)%10;
            help=(n1+n2+help)/10;
            sb.append(h);


        }

        while(len1>=0){
            int n1=num1.charAt(len1--)-'0';
            int h=(n1+help)%10;
            help=(n1+help)/10;
            sb.append(h);

        }

        while(len2>=0){
            int n1=num2.charAt(len2--)-'0';
            int h=(n1+help)%10;
            help=(n1+help)/10;
            sb.append(h);

        }
        if(help!=0)
            sb.append(help);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1="98";
        String str2="9";
        System.out.println(new Solution415().addStrings(str1,str2));
    }
}
