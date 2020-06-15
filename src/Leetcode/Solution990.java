package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:990. 等式方程的可满足性

给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。



示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。

示例 2：

输出：["b==a","a==b"]
输入：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。

示例 3：

输入：["a==b","b==c","a==c"]
输出：true

示例 4：

输入：["a==b","b!=c","c==a"]
输出：false

示例 5：

输入：["c==c","b==d","x!=z"]
输出：true

 * @date 2020/6/8 14:55
 */
public class Solution990 {


    //通过floyd算法来计算
    public static boolean equationsPossible(String[] equations) {
        int len=equations.length;
        if(len==1){
            if(equations[0].charAt(0)==equations[0].charAt(3) && equations[0].charAt(1)=='=')
                return true;
            else if(equations[0].charAt(0)!=equations[0].charAt(3) && equations[0].charAt(1)=='!')
                return true;
            else
                return false;
        }
        //构建图，先假设为真
        boolean res=true;
        boolean[][] letter=new boolean[26][26];
        List<Integer> list=new ArrayList<>();//用来记录！==表达式的序号
        for(int i=0;i<len;i++){
            int m=equations[i].charAt(0)-'a';
            int n=equations[i].charAt(3)-'a';
            if(equations[i].charAt(1)=='='){
                letter[m][n]=true;
                letter[n][m]=true;
            }else{
                list.add(i);
            }
        }
        //通过floyd算法来更新数据表
        for(int k=0;k<26;k++){//中间结点
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(letter[i][k] && letter[k][j]){
                        letter[i][j]=true;
                        letter[j][i]=true;
                    }

                }
            }
        }

        //遍历不相等的表达式
        for(Integer id :list){
            int m=equations[id].charAt(0)-'a';
            int n=equations[id].charAt(3)-'a';
            if(letter[m][n] || m==n){//如果m,n位置已经相等相连接，或者n==m，直接返回false;
                return false;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }



}
