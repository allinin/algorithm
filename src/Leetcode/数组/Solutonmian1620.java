package Leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：



示例 1:

输入: num = "8733", words = ["tree", "used"]
输出: ["tree", "used"]
示例 2:

输入: num = "2", words = ["a", "b", "c", "d"]
输出: ["a", "b", "c"]
提示：

num.length <= 1000
words.length <= 500
words[i].length == num.length
num中不会出现 0, 1 这两个数字

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/t9-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/17 14:16
 */
public class Solutonmian1620 {

    private char[][] nums=new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},
            {'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res=new ArrayList<>();
        int n=num.length();
        char[] chs=num.toCharArray();
        for(String str: words){
            char[] target=str.toCharArray();
            if(process(chs,target)){
                res.add(str);
            }
        }
        return res;
    }

    private boolean process(char[] chs,char[] target){
        int len=chs.length;
        for(int i=0;i<len;i++){
            char[] des=nums[chs[i]-'0'];
            int j=0;
            for(;j<des.length;j++){
                if(des[j]==target[i])
                    break;
            }
            if(j==des.length)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String num="2";
        String[] words={"a","b","c","d"};
        System.out.println(new Solutonmian1620().getValidT9Words(num,words));
    }
}
