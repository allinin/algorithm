package Leetcode.回溯剪枝;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。

形式上，斐波那契式序列是一个非负整数列表 F，且满足：

0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
F.length >= 3；
对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。

返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。

 

示例 1：

输入："123456579"
输出：[123,456,579]
示例 2：

输入: "11235813"
输出: [1,1,2,3,5,8,13]
示例 3：

输入: "112358130"
输出: []
解释: 这项任务无法完成。
示例 4：

输入："0123"
输出：[]
解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
示例 5：

输入: "1101111"
输出: [110, 1, 111]
解释: 输出 [11,0,11,11] 也同样被接受。
 

提示：

1 <= S.length <= 200
字符串 S 中只含有数字。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/8 12:01
 */
public class Solution842 {

    List<Integer> res=new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String S) {
        if(S==null || S.length()<3) return res;
        process(S,0,0);
        return res;

    }

    private boolean process(String s,int start,int num){
        if(start==s.length() && num>=3)
            return true;
        for(int i=start+1;i<=s.length();i++){
            if(s.charAt(start)=='0' && i>start+1){//说明当前取得数字大于一位，并且开头是0；
                break;
            }
            long next=getNum(s,start,i);
            if(next>Integer.MAX_VALUE) //根据题目的意思，不能大于int的最大范围
                break;
            if(num>=2 &&  next>res.get(res.size()-1)+res.get(res.size()-2)){//剪枝过程
                break;
            }
            if(num<=1 || next==res.get(res.size()-1)+res.get(res.size()-2)){
                res.add((int)next);
                if(process(s,i,num+1)){
                    return true;
                }
                res.remove(res.size()-1);
            }
        }
        return false;
    }

    //将字符串数字转化成整数数字
    private long getNum(String s,int start,int end){
        char[] chs=s.toCharArray();
        long ans=0;
        for(int i=start;i<end;i++){
            ans=ans*10+chs[i]-'0';
        }
        return ans;
    }
}
