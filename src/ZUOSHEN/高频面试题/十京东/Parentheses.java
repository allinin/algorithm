package ZUOSHEN.高频面试题.十京东;
/*
 四：合法的括号匹配序列被定义为：
 1.空串“”是合法的括号序列
 2.如果“x"和”y"是合法的序列，那么“xy"也是一个合法的括号序列
 3.如果“x"是一个合法的序列，那么”(x)"也是一个合法的括号序列
 4.每个括号序列都是由上面的规则生成
 现在在有一个合法的括号序列s,一次移除操作分为两步：
 1，移除序列s中第一个左括号
 2 移除序列s中任意一个右括号，保证操作之后s还是一个合法的括号序列
 现在想知道使用上述的移除操作有多少种方案可以把s变为空
 */
public class Parentheses {

    public static int possibilities(String str){
        char[] chas=str.toCharArray();
        int len=chas.length/2;
        int [] rlen=new int[len];
        int left=0;
        int right=0;
        int j=0;
        for(int i=chas.length-1;i>-1;i--){
            if(chas[i]==')')
                right++;
            if(chas[i]=='(')
            {
                rlen[j++]=right-left;
                left++;
            }
        }
        int res=1;
        for(int i=0;i<len;i++){
            res*=rlen[i];
        }
        return res;
    }
    public static int possibilities2(String parentheses) {
        char[] chas = parentheses.toCharArray();
        int cur = 0;
        int ans = 1;
        for (int i = chas.length - 1; i >= 0; i--) {
            if (chas[i] == ')') {
                cur++;
            } else {
                ans *= cur--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String test1 = "(((())))";
        System.out.println(possibilities(test1));
        System.out.println(possibilities2(test1));


        String test2 = "()()()()()";
        System.out.println(possibilities(test2));
        System.out.println(possibilities2(test2));

    }
}
