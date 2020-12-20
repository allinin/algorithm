package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299
说明: N 是在 [0, 10^9] 范围内的一个整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/monotone-increasing-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/15 12:25
 */
public class Solution738 {

    //方法一：
    public static int monotoneIncreasingDigits(int N) {
        String str=String.valueOf(N);
        int m=str.length();
        int index=0;
        char pre=str.charAt(0);
        int j=1;
        for(;j<m;j++){
            char c=str.charAt(j);
            if(c<pre){
                index=j-1;
                break;
            }
            pre=c;
        }
        if(j==m) return N;
        while(index>0 && str.charAt(index)==str.charAt(index-1)){
            index--;
        }
        StringBuilder sb=new StringBuilder();
        if(index==0 && str.charAt(index)=='1'){
            int i=0;
            while(i<m-1){
                sb.append(9);
                i++;
            }
        }else{
            for(int i=0;i<index;i++){
                sb.append(str.charAt(i));
            }
            int target=str.charAt(index)-'0';
            sb.append(target-1);
            int i=index+1;
            while(i<m){
                sb.append(9);
                i++;
            }
        }

        return Integer.valueOf(sb.toString());
    }

    //方法二：
    public  static int monotoneIncreasingDigits2(int N) {
        char[] chs=Integer.toString(N).toCharArray();
        int i=1;
        while(i<chs.length && chs[i-1] <= chs[i]){//找到第一个不符合要求的位置
            i+=1;
        }
        if(i < chs.length){
            while(i > 0 && chs[i-1] > chs[i]){//从不符合要求的前一个位置开始-1操作
                chs[i - 1] -= 1;
                i -= 1;
            }
            for(++i; i < chs.length; i++){
                chs[i]='9';
            }
        }
        return Integer.parseInt(new String(chs));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits2(10));
    }
}
