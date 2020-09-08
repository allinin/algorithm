package 公司笔面试真题.猿辅导.二零_1;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:猿辅导APP需要下发一些宣传文本给学生，工程师们使用了一种字符压缩算法，为简单起见，假设被压缩的字符全部为大写字母序列，A,B,C,D....Z,压缩规则如下：
1.AAAB可以压缩为A3B (单字符压缩不加括号)
2.ABABA可以压缩为(AB)2A （多字符串压缩才加括号）

输入数据保证不会出现冗余括号，且表示重复的数字一定合法且大于1，即不会出现：
1.（A)2B   ------- （应为：A2B）
2.  ((AB))2C,-----(应为：（AB)2C  )
3. （A)B  ----- （应为：AB）
4.   A1B，（AB)1C，（应为 AB，ABC）

注意：数字可能出现多位数即A11B或者(AB)10C或者A02这种情况。
A11B = AAAAAAAAAAAB
(AB)10C = ABABABABABABABABABABC
A02 = AA

数据分布：
对于60%的数据，括号不会出现嵌套，即不会有 ((AB)2C)2这种结构。
对于80%的数据，括号最多只嵌套一层，即不会有 (((AB)2C)2D)99 这种结构。
对于100%的数据，括号可以嵌套任意层。

输入描述:
第一行是正整数C(C <= 100)，表示下面有C组数据。之后C行，每行为一组数据，每组数据为一个字符串。

每个字符串由A-Z,数字0-9和(,)组成表示一个压缩后的串，保证输入数据一定合法且字符串长度小于50。

输出描述:
输出C行，每行对应一个数据的输出结果，表示压缩前的字符串，保证每个字符串展开后的长度不超过10^6。

输入例子1:
5
A11B
(AA)2A
((A2B)2)2G
(YUANFUDAO)2JIAYOU
A2BC4D2

输出例子1:
AAAAAAAAAAAB
AAAAA
AABAABAABAABG
YUANFUDAOYUANFUDAOJIAYOU
AABCCCCDD
 * @date 2020/7/26 13:03
 */
public class Solution3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int c=sc.nextInt();
        String[] strs=new String[c];
        for(int i=0;i<c;i++){
            strs[i]=sc.next();
        }
        for(int i=0;i<c;i++){
            System.out.println(process(strs[i]));
        }

    }

    private static String process(String str){
        int len=str.length();
        StringBuilder sb=new StringBuilder();
        String res="";
        int index=0;
        String tmp="";
        while(index<len){
            char c=str.charAt(index);
            if(c>='A' && c<='Z' )
                if(index>=1 && str.charAt(index-1)>='A' && str.charAt(index-1)<='Z') {
                    res += sb.toString();
                    sb = new StringBuilder();
                    sb.append(c);
                    index++;
                }else {
                    sb.append(c);
                    index++;
            }else if(c>='0' && c<='9'){
                int num=c-'0';
                index++;
                while(index<len && Character.isDigit(str.charAt(index))){
                    num=num*10+str.charAt(index++)-'0';
                }
                if(!"".equals(tmp)){
                    for(int i=0;i<num;i++){
                        res+=tmp;
                    }
                    tmp="";
                }else{
                    String s=sb.toString();
                    for(int i=1;i<num;i++){
                        sb.append(s);
                    }
                    res+=sb.toString();
                    sb=new StringBuilder();
                }
            }else if(c=='('){ //遇到了（
                //先结算前面的
                if(sb.length()>0){
                    res+=sb.toString();
                    sb=new StringBuilder();
                }
                String[] help= process(str,index+1);
                index=Integer.valueOf(help[1]);
                tmp=help[0];
            }
        }
        res+=sb.toString();
        return res;

    }

    /**
     * 遇到(就进入该方法计算，遇到）终止计算
     * @param str
     * @param index
     * @return ：当前计算的结果值以及）后一个位置的索引
     */
    private static String[] process(String str,int index){
         String[] ans=new String[2];
         ans[0]="";
         int len=str.length();
         String rs="";
         String tmp="";
         StringBuilder sb=new StringBuilder();
         while(str.charAt(index)!=')'){
             char c=str.charAt(index);
             if(c=='('){
                 //先结算前面的
                 if(sb.length()>0){
                     ans[0]+=sb.toString();
                     sb=new StringBuilder();
                 }
                 String[] help=process(str,index+1);
                 index=Integer.valueOf(help[1]);
                 tmp=help[0];
             }else if(c>='A' && c<='Z'){
                 if(index>=1 && str.charAt(index-1)>='A' && str.charAt(index-1)<='Z') {
                     ans[0] += sb.toString();
                     sb = new StringBuilder();
                     sb.append(c);
                     index++;
                 }else {
                     sb.append(c);
                     index++;
                 }
             }else if(c>='0' && c<='9'){
                 int num=c-'0';
                 index++;
                 while(str.charAt(index)!=')' && Character.isDigit(str.charAt(index))){
                     num=num*10+str.charAt(index++)-'0';
                 }
                 if(!"".equals(tmp)){
                     for(int i=0;i<num;i++){
                         rs+=tmp;
                     }
                     ans[0]+=rs;
                     tmp="";
                     rs="";
                 }else{
                     String s=sb.toString();
                     for(int i=1;i<num;i++){
                         sb.append(s);
                     }
                     ans[0]+=sb.toString();
                     sb=new StringBuilder();
                 }

             }
         }
         ans[0]+=sb.toString();
         ans[1]=String.valueOf(index+1);
         return ans;
    }

}
