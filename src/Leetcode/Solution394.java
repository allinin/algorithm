package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/5/28 15:43
 */
public class Solution394 {

    public static String decodeString(String s) {
        StringBuilder sb=new StringBuilder();
        char[] chs=s.toCharArray();
        int num=0;
        int i=0;
        while(i<chs.length){
            if(chs[i]>='0' && chs[i]<='9'){
                if(num==0){
                    num=chs[i]-'0';
                    i++;
                }else{
                    num=num*10+(chs[i++]-'0');
                }
            }else if(chs[i]=='['){
                String[] res=process(s,i);
                for(int j=0;j<num;j++){
                    sb.append(res[0]);
                }
                num=0;
                if(Integer.valueOf(res[1])==chs.length-1)
                    break;
                else
                    i=Integer.valueOf(res[1])+1;
            }else{
                sb.append(chs[i++]);
            }
        }
        return sb.toString();

    }

    private static String[] process(String s,int start) {//返回部分结果值以及终结的位置
        String [] ans=new String[2];
        int len=s.length();
        int num=0;
        StringBuilder sb=new StringBuilder();
        if(s.charAt(start)=='['){
            start++;
        }
        while(start<len){
            if(s.charAt(start)!=']' && !(s.charAt(start)>='0' && s.charAt(start)<='9') && s.charAt(start)!='['){
                sb.append(s.charAt(start++));
            }else if(s.charAt(start)==']'){
                String res=sb.toString();
                ans[0]=res;
                ans[1]=String.valueOf(start);
                return ans;
            }else if(s.charAt(start)>='0' && s.charAt(start)<='9' ){ //当前start位置为数字
                 if(num==0)
                      num=s.charAt(start++)-'0';
                 else{
                     num=num*10+(s.charAt(start++)-'0');
                 }

            }else{
                String[] tmp=process(s,start);
                for(int i=0;i<num;i++){
                    sb.append(tmp[0]);
                }
                num=0;
                start=Integer.valueOf(tmp[1])+1;
            }
        }
        ans[0]=sb.toString();
        ans[1]=String.valueOf(start-1);
        return ans;
    }
    public static void main(String[] args) {
        String str="3[a10[bc]]";
        System.out.println(decodeString(str));
    }
}
