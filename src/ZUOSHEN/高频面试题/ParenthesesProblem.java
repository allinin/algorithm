package ZUOSHEN.高频面试题;

/**
 * @author zbl
 * @version 1.0
 * @content: 已知一个字符串都是由左括号和后括号组成，判断该字符串是否是有效括号组合。
 * 进阶：已知一个字符串都是由左括号和右括号组成，返回最长有效括号子串的长度
 * @date 2019/12/26 11:20
 */
public class ParenthesesProblem {

    public static boolean isValid(String str)
    {
        if(str==null || str.equals(""))
            return false;
        char[] charArr=str.toCharArray();
        int count=0;
        for(int i=0;i<charArr.length;i++){
            if(charArr[i]=='(')
                count++;
            if(charArr[i]==')'&& --count<0)
                return false;

        }
        return count==0;

    }

    /**  进阶
    *@param
    *@return
    */

    public static int maxLength(String str){
        if(str==null || str.equals(""))
            return 0;
        char[] charArr=str.toCharArray();
        int[] dp=new int[charArr.length];//记录以对应位置字符结尾的子串的长度
        int res=0;
        int pre=0;//
        dp[0]=0;
        for(int i=1;i<charArr.length;i++)
        {
            if(charArr[i]=='(')
                dp[i]=0;
            else{
               pre=i-dp[i-1]-1;
               if(pre>=0 && charArr[pre]=='(')
               {
                   dp[i]=dp[i-1]+2+(pre-1>0 ? dp[pre-1]:0);
               }

            }
            res=Math.max(dp[i],res);
        }
        return res;

    }

    public static void main(String[] args) {
        String str1 = "((())())";
        System.out.println(isValid(str1));
        System.out.println(maxLength(str1));

        String str2 = "(())(()(()))";
        System.out.println(isValid(str2));
        System.out.println(maxLength(str2));

        String str3 = "()(()()(";
        System.out.println(isValid(str3));
        System.out.println(maxLength(str3));

    }
}
